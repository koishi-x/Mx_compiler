package Frontend;

import AST.*;
import AST.binaryExprNode.binaryOpType;
import AST.cmpExprNode.cmpOpType;
import Parser.MxBaseVisitor;
import Parser.MxParser;
import Util.Function;
import Util.Type;
import Util.error.semanticError;
import Util.error.syntaxError;
import Util.globalScope;
import Util.position;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;

public class ASTBuilder extends MxBaseVisitor<ASTNode> {

    private globalScope gScope;
    public ASTBuilder(globalScope gScope) {
        this.gScope = gScope;
    }

    Type intType, boolType, stringType, voidType, conType, arrayType, thisType, nullType;

    @Override public ASTNode visitProgram(MxParser.ProgramContext ctx) {
//        rootNode root = new rootNode(new position(ctx), (fnRootNode)visit(ctx.mainFn()));
//        ctx.classDef().forEach(cd -> root.classDefs.add((classDefNode) visit(cd)));
//        ctx.funcDef().forEach(fd -> root.functionDefs.add((functionNode) visit(fd)));
//        return root;
        intType = new Type();
        boolType = new Type();
        stringType = new Type();
        voidType = new Type();
        conType = new Type();
        arrayType = new Type();
        thisType = new Type();
        nullType = new Type();

        intType.isInt = true;
        boolType.isBool = true;
        stringType.isString = true;
        voidType.isVoid = true;
        conType.isCon = true;
        arrayType.isArray = true;
        thisType.isThis = true;
        nullType.isNull = true;

        rootNode root = new rootNode(new position(ctx));
        for (MxParser.DeclarationContext it: ctx.declaration()) {
            if (it.mainFn() != null) {
                if (root.hasMain) {
                    throw new semanticError("mutiple definition of main function.", new position(it));
                }
                root.hasMain = true;
                declarationNode dec = new declarationNode(0, new position(it));
                dec.fnRoot = (fnRootNode) visit(it.mainFn());
                root.declarations.add(dec);
            } else if (it.varDef() != null) {
                varDefStmtNode varDef = (varDefStmtNode) visit(it.varDef());
                declarationNode dec = new declarationNode(1, new position(it));
                dec.varDef = varDef;
                root.declarations.add(dec);
            } else if (it.classDef() != null) {
                classDefNode classDef = (classDefNode) visit(it.classDef());
                declarationNode dec = new declarationNode(2, new position(it));
                dec.classDef = classDef;
                root.declarations.add(dec);
            } else if (it.funcDef() != null) {
                functionNode funcDef = (functionNode) visit(it.funcDef());
                declarationNode dec = new declarationNode(3, new position(it));
                dec.funcDef = funcDef;
                root.declarations.add(dec);
            }
        }
        if (!root.hasMain)
            throw new semanticError("main function does not exist.", new position(ctx));
        return root;
    }

    @Override public ASTNode visitMainFn(MxParser.MainFnContext ctx) {
        fnRootNode root = new fnRootNode(new position(ctx));
//        intType = root.intType;
//        boolType = root.boolType;
//        stringType = root.stringType;
//        voidType = root.voidType;
//        conType = root.conType;
//        arrayType = root.arrayType;
//        thisType = root.thisType;
//        nullType = root.nullType;


        gScope.addType("int", intType, root.pos);
        gScope.addType("bool", boolType, root.pos);
        gScope.addType("string", stringType, root.pos);
        gScope.addType("void", voidType, root.pos);
        gScope.addType("class", conType, root.pos);

        typeNode voidTypeNode = new typeNode("void", 0, root.pos);
        typeNode stringTypeNode = new typeNode("string", 0, root.pos);
        typeNode intTypeNode = new typeNode("int", 0, root.pos);

        ArrayList<Type> singleString = new ArrayList<>();
        singleString.add(stringType);

        ArrayList<Type> singleInt = new ArrayList<>();
        singleInt.add(intType);

        ArrayList<Type> twoInt = new ArrayList<>();
        twoInt.add(intType);
        twoInt.add(intType);

        //gScope.addFunc("print", new functionNode("print", singleString, voidTypeNode, root.pos), root.pos);
        gScope.addFunc("print", new Function("print", singleString, voidType, root.pos), root.pos);
        gScope.addFunc("println", new Function("println", singleString, voidType, root.pos), root.pos);

        gScope.addFunc("printInt", new Function("printInt", singleInt, voidType, root.pos), root.pos);
        gScope.addFunc("printlnInt", new Function("printlnInt", singleInt, voidType, root.pos), root.pos);

        gScope.addFunc("getString", new Function("getString", null, stringType, root.pos), root.pos);
        gScope.addFunc("getInt", new Function("getInt", null, intType, root.pos), root.pos);

        gScope.addFunc("toString", new Function("toString", singleInt, stringType, root.pos), root.pos);

        gScope.defineVariable("this", thisType, root.pos);

        arrayType.funcs = new HashMap<>();
        arrayType.funcs.put("size", new Function("size", null, intType, root.pos));

        stringType.funcs = new HashMap<>();
        stringType.funcs.put("length", new Function("length", null, intType, root.pos));
        stringType.funcs.put("substring", new Function("substring", twoInt, stringType, root.pos));
        stringType.funcs.put("parseInt", new Function("parseInt", null, intType, root.pos));
        stringType.funcs.put("ord", new Function("ord", singleInt, intType, root.pos));

        if (ctx.suite() != null) {
            for (ParserRuleContext stmt : ctx.suite().statement()) {
                stmtNode tmp = (stmtNode) visit(stmt);
                if (tmp != null) root.stmts.add(tmp);
            }
        }
        return root;
    }

    @Override public ASTNode visitIfStmt(MxParser.IfStmtContext ctx) {
        stmtNode thenStmt = (stmtNode)visit(ctx.trueStmt), elseStmt = null;
        exprNode condition = (exprNode)visit(ctx.expression());
        if (ctx.falseStmt != null) elseStmt = (stmtNode)visit(ctx.falseStmt);
        return new ifStmtNode(condition, thenStmt, elseStmt, new position(ctx));
    }

    @Override public ASTNode visitWhileStmt(MxParser.WhileStmtContext ctx) {
        return new whileStmtNode((exprNode) visit(ctx.expression()), (stmtNode) visit(ctx.statement()), new position(ctx));
    }

    @Override public ASTNode visitExprForStmt(MxParser.ExprForStmtContext ctx) {
        exprNode init = null;
        exprNode condition = null;
        exprNode step = null;
        if (ctx.init != null) init = (exprNode) visit(ctx.init);
        if (ctx.condition != null) condition = (exprNode) visit(ctx.condition);
        if (ctx.step != null) step = (exprNode) visit(ctx.step);

        stmtNode body = (stmtNode) visit(ctx.statement());

        return new exprForStmtNode(init, condition, step, body, new position(ctx));
    }

    @Override public ASTNode visitVardefForStmt(MxParser.VardefForStmtContext ctx) {
        varDefStmtNode init = (varDefStmtNode) visit(ctx.init);
        exprNode condition = null;
        exprNode step = null;
        if (ctx.condition != null) condition = (exprNode) visit(ctx.condition);
        if (ctx.step != null) step = (exprNode) visit(ctx.step);

        stmtNode body = (stmtNode) visit(ctx.statement());

        return new vardefForStmtNode(init, condition, step, body, new position(ctx));
    }

    @Override public ASTNode visitReturnStmt(MxParser.ReturnStmtContext ctx) {
        exprNode value = null;
        if (ctx.expression() != null) value = (exprNode) visit(ctx.expression());
        return new returnStmtNode(value, new position(ctx));
    }

    @Override public ASTNode visitPureExprStmt(MxParser.PureExprStmtContext ctx) {
        return new exprStmtNode((exprNode) visit(ctx.expression()), new position(ctx));
    }

    @Override public ASTNode visitBreakStmt(MxParser.BreakStmtContext ctx) { return new breakStmtNode(new position(ctx)); }

    @Override public ASTNode visitContinueStmt(MxParser.ContinueStmtContext ctx) { return new continueStmtNode(new position(ctx)); }


    @Override public ASTNode visitSuite(MxParser.SuiteContext ctx) {
        //return visitChildren(ctx);
        blockStmtNode node = new blockStmtNode(new position(ctx));
        if (!ctx.statement().isEmpty()) {
            for (ParserRuleContext stmt : ctx.statement()) {
                stmtNode tmp = (stmtNode) visit(stmt);
                if (tmp != null) node.stmts.add(tmp);
            }
        }
        return node;
    }

    @Override public ASTNode visitBlock(MxParser.BlockContext ctx) {
        return visit(ctx.suite());
    }

    @Override public ASTNode visitEmptyStmt(MxParser.EmptyStmtContext ctx) {
        return new emptyStmt(new position(ctx));
    }


    @Override public ASTNode visitVarDef(MxParser.VarDefContext ctx) {
        exprNode expr = null;

        typeNode varType = (typeNode) visit(ctx.type());
        varDefStmtNode varDef = new varDefStmtNode(varType, new position(ctx));
        if (ctx.varDefUnit() != null) {
            for (ParserRuleContext unit : ctx.varDefUnit())
                varDef.units.add((varDefUnitNode) visit(unit));
        }
        return varDef;
    }

    @Override public ASTNode visitVardefStmt(MxParser.VardefStmtContext ctx) { return visit(ctx.varDef()); }
    @Override public ASTNode visitVarDefUnit(MxParser.VarDefUnitContext ctx) {
        if (ctx.expression() != null) {
            return new varDefUnitNode(ctx.Identifier().toString(), (exprNode) visit(ctx.expression()), new position(ctx));
        } else {
            return new varDefUnitNode(ctx.Identifier().toString(), null, new position(ctx));
        }
    }

    @Override public ASTNode visitSingleType(MxParser.SingleTypeContext ctx) {
        //assert(ctx != null);
        if (ctx.singleTypeName().Int() != null) return new typeNode(ctx.singleTypeName().Int().toString(), 0, new position(ctx));
        else if (ctx.singleTypeName().Bool() != null) return new typeNode(ctx.singleTypeName().Bool().toString(), 0, new position(ctx));
        else if (ctx.singleTypeName().String() != null) return new typeNode(ctx.singleTypeName().String().toString(), 0, new position(ctx));

        return null;

    }
    @Override public ASTNode visitClassType(MxParser.ClassTypeContext ctx) {
        if (ctx.Identifier() != null) return new typeNode(ctx.Identifier().toString(), 0, new position(ctx));

        return null;
    }
    @Override public ASTNode visitArrayType(MxParser.ArrayTypeContext ctx) {
        if (ctx.type() != null) {
            typeNode lastType = (typeNode) visit(ctx.type());
            return new typeNode(lastType.typeName, lastType.dimensions + 1, new position(ctx));
        }
        return null;
    }

    @Override public ASTNode visitAtomExpr(MxParser.AtomExprContext ctx) {
        return visit(ctx.primary());
    }

    @Override public ASTNode visitPreFixExpr(MxParser.PreFixExprContext ctx) {
        if (ctx.PlusPlus() != null) return new preFixExprNode((exprNode) visit(ctx.expression()), 0, new position(ctx));
        else if (ctx.MinusMinus() != null) return new preFixExprNode((exprNode) visit(ctx.expression()), 1, new position(ctx));

        throw new syntaxError("???", new position(ctx));
    }

    @Override public ASTNode visitSufFixExpr(MxParser.SufFixExprContext ctx) {

        if (ctx.PlusPlus() != null) return new sufFixExprNode((exprNode) visit(ctx.expression()), 0, new position(ctx));
        else if (ctx.MinusMinus() != null) return new sufFixExprNode((exprNode) visit(ctx.expression()), 1, new position(ctx));

        throw new syntaxError("???", new position(ctx));
    }

    @Override public ASTNode visitBinaryExpr(MxParser.BinaryExprContext ctx) {
        exprNode lhs = (exprNode) visit(ctx.l),
                rhs = (exprNode) visit(ctx.r);

        if (ctx.Plus() != null) {
            return new binaryExprNode(lhs, rhs, binaryOpType.add, new position(ctx));
        }
        if (ctx.Minus() != null) {
            return new binaryExprNode(lhs, rhs, binaryOpType.sub, new position(ctx));
        }
        if (ctx.Multiply() != null) {
            return new binaryExprNode(lhs, rhs, binaryOpType.mul, new position(ctx));
        }
        if (ctx.Divide() != null) {
            return new binaryExprNode(lhs, rhs, binaryOpType.div, new position(ctx));
        }
        if (ctx.Modulo() != null) {
            return new binaryExprNode(lhs, rhs, binaryOpType.mod, new position(ctx));
        }
        if (ctx.LeftShift() != null) {
            return new binaryExprNode(lhs, rhs, binaryOpType.lshift, new position(ctx));
        }
        if (ctx.RightShift() != null) {
            return new binaryExprNode(lhs, rhs, binaryOpType.rshift, new position(ctx));
        }
        if (ctx.And() != null) {
            return new binaryExprNode(lhs, rhs, binaryOpType.and, new position(ctx));
        }
        if (ctx.Or() != null) {
            return new binaryExprNode(lhs, rhs, binaryOpType.or, new position(ctx));
        }
        if (ctx.Caret() != null) {
            return new binaryExprNode(lhs, rhs, binaryOpType.xor, new position(ctx));
        }
        if (ctx.AndAnd() != null) {
            return new binaryExprNode(lhs, rhs, binaryOpType.andand, new position(ctx));
        }
        if (ctx.OrOr() != null) {
            return new binaryExprNode(lhs, rhs, binaryOpType.oror, new position(ctx));
        }
        if (ctx.Equal() != null) {
            return new cmpExprNode(lhs, rhs, cmpOpType.eq, boolType, new position(ctx));
        }
        if (ctx.NotEqual() != null) {
            return new cmpExprNode(lhs, rhs, cmpOpType.neq, boolType, new position(ctx));
        }
        if (ctx.Less() != null) {
            return new cmpExprNode(lhs, rhs, cmpOpType.less, boolType, new position(ctx));
        }
        if (ctx.LessEqual() != null) {
            return new cmpExprNode(lhs, rhs, cmpOpType.leq, boolType, new position(ctx));
        }
        if (ctx.Greater() != null) {
            return new cmpExprNode(lhs, rhs, cmpOpType.greater, boolType, new position(ctx));
        }
        if (ctx.GreaterEqual() != null) {
            return new cmpExprNode(lhs, rhs, cmpOpType.geq, boolType, new position(ctx));
        }
        throw new semanticError("undefine binary op", new position(ctx));
    }

    @Override public ASTNode visitPrimary(MxParser.PrimaryContext ctx) {
        if (ctx.expression() != null) return visit(ctx.expression());
        else if (ctx.literal() != null) return visit(ctx.literal());
        else if (ctx.This() != null) {
            varExprNode node = new varExprNode(ctx.This().toString(), new position(ctx.This()));
            node.type = thisType;
            return node;
            //return new varExprNode(ctx.This().toString(), new position(ctx.This()));
        }
        else return new varExprNode(ctx.Identifier().toString(), new position(ctx.Identifier()));
    }

    @Override public ASTNode visitAssignExpr(MxParser.AssignExprContext ctx) {
        exprNode lhs = (exprNode) visit(ctx.l),
                rhs = (exprNode) visit(ctx.r);
        return new assignExprNode(lhs, rhs, new position(ctx));
    }

    @Override public ASTNode visitLiteral(MxParser.LiteralContext ctx) {
        if (ctx.DecimalInteger() != null) {
            constExprNode node = new constExprNode(intType, new position(ctx));
            node.intValue = Long.parseLong(ctx.DecimalInteger().toString());
            return node;
        } else if (ctx.logicalLiteral() != null) {
            constExprNode node = new constExprNode(boolType, new position(ctx));
            node.boolValue = Boolean.parseBoolean(ctx.logicalLiteral().toString());
            return node;
        } else if (ctx.StringLiteral() != null) {
            constExprNode node = new constExprNode(stringType, new position(ctx));
            node.stringValue = ctx.StringLiteral().toString();
            return node;
        } else if (ctx.Null() != null) {
            return new constExprNode(nullType, new position(ctx));
        }
        //return null;
        throw new semanticError("invalid literal", new position(ctx));
    }

    @Override public ASTNode visitUnaryPlus(MxParser.UnaryPlusContext ctx) {
        return new unaryPlusExprNode((exprNode) visit(ctx.expression()), new position(ctx));
    }

    @Override public ASTNode visitUnaryMinus(MxParser.UnaryMinusContext ctx) {
        return new unaryMinusExprNode((exprNode) visit(ctx.expression()), new position(ctx));
    }

    @Override public ASTNode visitLogicalNot(MxParser.LogicalNotContext ctx) {
        return new logicalNotExprNode((exprNode) visit(ctx.expression()), new position(ctx));
    }

    @Override public ASTNode visitBitwiseNot(MxParser.BitwiseNotContext ctx) {
        return new bitwiseNotExprNode((exprNode) visit(ctx.expression()), new position(ctx));
    }
    @Override public ASTNode visitTernaryConditional(MxParser.TernaryConditionalContext ctx) {
        return new
            ternaryConditionalExprNode((exprNode) visit(ctx.expression(0)), (exprNode) visit(ctx.expression(1)), (exprNode) visit(ctx.expression(2)), new position(ctx));
    }

    @Override public ASTNode visitArrayExpr(MxParser.ArrayExprContext ctx) {
        return new arrayExprNode((exprNode) visit(ctx.expression(0)), (exprNode) visit(ctx.expression(1)), new position(ctx));
    }

    @Override public ASTNode visitFunctionCallExpr(MxParser.FunctionCallExprContext ctx) {
        return visit(ctx.funcCall());
    }

    @Override public ASTNode visitMemberFuncExpr(MxParser.MemberFuncExprContext ctx) {
        funcCallExpr node = (funcCallExpr) visit(ctx.funcCall());
        node.parentClass = (exprNode) visit(ctx.expression());
        return node;
    }

    @Override public ASTNode visitFuncCall(MxParser.FuncCallContext ctx) {
        funcCallExpr node = new funcCallExpr(ctx.Identifier().toString(), new position(ctx));
        if (ctx.funcCallArglist() != null) {
            for (ParserRuleContext expr: ctx.funcCallArglist().expression()) {
                node.argList.add((exprNode) visit(expr));
            }
        }
        return node;
    }

    @Override public ASTNode visitMemberVariableExpr(MxParser.MemberVariableExprContext ctx) {
        varExprNode node = new varExprNode(ctx.Identifier().toString(), new position(ctx));
        node.parentClass = (exprNode) visit(ctx.expression());
        return node;
    }

    @Override public ASTNode visitNewExpr(MxParser.NewExprContext ctx) {
        return new newExprNode((newTypeNode) visit(ctx.newType()), new position(ctx));
    }

    @Override public ASTNode visitNewClass(MxParser.NewClassContext ctx) {
        return new newTypeNode(ctx.Identifier().toString(), 0, new position(ctx));
    }

    @Override public ASTNode visitNewSingleArray(MxParser.NewSingleArrayContext ctx) {
        newTypeNode node;

        //System.out.println(ctx.newArrayExprCount().size() + ctx.newArrayEmptyCount().size());
        if (ctx.newArrayEmptyCount() != null) {
            for (MxParser.NewArrayEmptyCountContext it: ctx.newArrayEmptyCount()) {
                if (it.expression() != null) {
                    throw new syntaxError("syntax error: invalid new array expression", new position(ctx));
                }
            }
        }
        if (ctx.singleTypeName().Int() != null)
            node = new newTypeNode("int", ctx.newArrayExprCount().size() + ctx.newArrayEmptyCount().size(), new position(ctx));
        else if (ctx.singleTypeName().Bool() != null)
            node = new newTypeNode("bool", ctx.newArrayExprCount().size() + ctx.newArrayEmptyCount().size(), new position(ctx));
        else if (ctx.singleTypeName().String() != null)
            node = new newTypeNode("string", ctx.newArrayExprCount().size() + ctx.newArrayEmptyCount().size(), new position(ctx));
        else throw new semanticError("FUCK XXX!", new position(ctx));
        node.sizes = new ArrayList<>();
        for (MxParser.NewArrayExprCountContext it: ctx.newArrayExprCount()) {
            node.sizes.add((exprNode) visit(it.expression()));
        }
        return node;
    }

    @Override public ASTNode visitNewClassArray(MxParser.NewClassArrayContext ctx) {
        if (ctx.newArrayEmptyCount() != null) {
            for (MxParser.NewArrayEmptyCountContext it: ctx.newArrayEmptyCount()) {
                if (it.expression() != null) {
                    throw new syntaxError("syntax error: invalid new array expression", new position(ctx));
                }
            }
        }

        newTypeNode node = new newTypeNode(ctx.Identifier().toString(), ctx.newArrayExprCount().size() + ctx.newArrayEmptyCount().size(), new position(ctx));
        node.sizes = new ArrayList<>();
        for (MxParser.NewArrayExprCountContext it: ctx.newArrayExprCount()) {
            node.sizes.add((exprNode) visit(it.expression()));
        }
        return node;
    }

    @Override public ASTNode visitReturnType(MxParser.ReturnTypeContext ctx) {
        if (ctx.Void() != null) return new typeNode(ctx.Void().toString(), 0, new position(ctx));

        return (typeNode) visit(ctx.type());
    }

    @Override public ASTNode visitFuncDef(MxParser.FuncDefContext ctx) {

        functionNode node;
        if (ctx.parameterList() != null)
            node = new functionNode(ctx.Identifier().toString(), (paraListNode) visit(ctx.parameterList()), (typeNode) visit(ctx.returnType()), new position(ctx));
        else node = node = new functionNode(ctx.Identifier().toString(), null, (typeNode) visit(ctx.returnType()), new position(ctx));
        if (!ctx.suite().statement().isEmpty()) {
            //throw new semanticError("Semantic error: empty function body", node.pos);
            for (ParserRuleContext stmt: ctx.suite().statement()) {
                node.stmts.add((stmtNode) visit(stmt));
            }
        }

        return node;
    }

    @Override public ASTNode visitParameterList(MxParser.ParameterListContext ctx) {
        paraListNode node = new paraListNode(new position(ctx));
        for (ParserRuleContext type: ctx.type()) {
            node.typeList.add((typeNode) visit(type));
        }
        for (TerminalNode name: ctx.Identifier()) {
            node.nameList.add(name.toString());
        }
        return node;
    }

    @Override public ASTNode visitClassDef(MxParser.ClassDefContext ctx) {
//        classDefNode structDef = new classDefNode(new position(ctx), ctx.Identifier().toString());
//        ctx.varDef().forEach(vd -> structDef.varDefs.add((varDefStmtNode) visit(vd)));
//        return structDef;
        String className = ctx.Identifier().toString();
        classDefNode node = new classDefNode(className, new position(ctx));
        boolean hasCon = false;
        for (ParserRuleContext it: ctx.classComponent()) {
            classComponentNode classComponent = (classComponentNode) visit(it);
            if (classComponent.componentType == 0) {
                classComponent.varDef.parentClassName = className;
                node.varDefs.add(classComponent.varDef);
            } else if (classComponent.componentType == 1) {
                if (hasCon) {
                    throw new semanticError("Semantic error: mutiple construction function", classComponent.pos);
                }
                hasCon = true;
                classComponent.funcDef.parentClassName = className;
                node.constructionFunc = classComponent.funcDef;
                if (!node.constructionFunc.name.equals(className)) {
                    throw new semanticError("Mismatched constructor name", classComponent.pos);
                }
            } else {    //2
                classComponent.funcDef.parentClassName = className;
                node.memberFunc.add(classComponent.funcDef);
                if (classComponent.funcDef.name.equals(className)) {
                    throw new semanticError("Constructor Type Error", classComponent.pos);
                }
            }
        }
        return node;
    }

    @Override public ASTNode visitClassMember(MxParser.ClassMemberContext ctx) {
        varDefStmtNode varDef = (varDefStmtNode) visit(ctx.varDef());
        classComponentNode node = new classComponentNode(0, new position(ctx));
        node.varDef = varDef;
        return node;
    }

    @Override public ASTNode visitConstructionFunc(MxParser.ConstructionFuncContext ctx) {
        functionNode funcDef = new functionNode(ctx.constructionFuncDef().Identifier().toString(), null, new typeNode("class", 0, new position(ctx.constructionFuncDef().Identifier())), new position(ctx.constructionFuncDef()));
//        if (ctx.constructionFuncDef().suite().statement().isEmpty()) {
//            throw new semanticError("Semantic error: empty function body", funcDef.pos);
//        }
        if (!ctx.constructionFuncDef().suite().statement().isEmpty())
            for (ParserRuleContext stmt: ctx.constructionFuncDef().suite().statement()) {
                funcDef.stmts.add((stmtNode) visit(stmt));
            }
        classComponentNode node = new classComponentNode(1, new position(ctx));
        node.funcDef = funcDef;
        return node;
    }

    @Override public ASTNode visitClassMethod(MxParser.ClassMethodContext ctx) {
        functionNode funcDef = (functionNode) visit(ctx.funcDef());
        classComponentNode node = new classComponentNode(2, new position(ctx));
        node.funcDef = funcDef;
        return node;
    }
}