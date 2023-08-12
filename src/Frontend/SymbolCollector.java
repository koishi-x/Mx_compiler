package Frontend;

import AST.*;
import Util.Function;
import Util.Type;
import Util.globalScope;

import java.util.ArrayList;
import java.util.HashMap;

public class SymbolCollector implements ASTVisitor{
    private globalScope gScope;
    private Type currentStruct = null;

    public SymbolCollector(globalScope gScope) {
        this.gScope = gScope;
    }
    @Override
    public void visit(rootNode it) {

        for (declarationNode dec: it.declarations) {
            if (dec.decType == 2) {
                Type classType = new Type();
                classType.members = new HashMap<>();
                classType.funcs = new HashMap<>();
                gScope.addType(dec.classDef.name, classType, dec.pos);
                //System.out.println(dec.classDef.name);
            }
        }

        for (declarationNode dec: it.declarations) {
            if (dec.decType == 2) {
                dec.classDef.accept(this);
            }
            else if (dec.decType == 3) {
                dec.funcDef.accept(this);
            }
        }
    }

    @Override
    public void visit(classDefNode it) {
//        Type classType = new Type();
//        classType.members = new HashMap<>();
//        classType.funcs = new HashMap<>();
//
//        it.varDefs.forEach(vd -> vd.accept(this));
//        it.constructionFunc.accept(this);
//        it.memberFunc.forEach(fd -> fd.accept(this));
//
//        gScope.addType(it.name, classType, it.pos);
        currentStruct = gScope.getTypeFromName(it.name, it.pos);
        it.varDefs.forEach(vd -> vd.accept(this));
        if (it.constructionFunc != null) it.constructionFunc.accept(this);
        it.memberFunc.forEach(fd -> fd.accept(this));
        currentStruct = null;
    }

    @Override
    public void visit(fnRootNode it) {

    }

    @Override
    public void visit(varDefStmtNode it) {
        assert (currentStruct != null);
        assert (currentStruct.members != null);
        Type type = gScope.getTypeFromTypeNode(it.typeName, it.pos);
        for (varDefUnitNode unit: it.units) {
//            if (currentStruct.members.containsKey(unit.name))
//                throw new semanticError("redefinition of member " + unit.name, unit.pos);
//            currentStruct.members.put(unit.name, type);
            currentStruct.addMember(unit.name, type, unit.pos);
        }
    }

    @Override
    public void visit(returnStmtNode it) {

    }

    @Override
    public void visit(exprStmtNode it) {

    }

    @Override
    public void visit(ifStmtNode it) {

    }

    @Override
    public void visit(assignExprNode it) {

    }

    @Override
    public void visit(binaryExprNode it) {

    }

    @Override
    public void visit(constExprNode it) {

    }

    @Override
    public void visit(cmpExprNode it) {

    }

    @Override
    public void visit(varExprNode it) {

    }

    @Override
    public void visit(paraListNode it) {

    }

    @Override
    public void visit(functionNode it) {


        ArrayList<Type> argType = new ArrayList<>();
        Type rtType = gScope.getTypeFromTypeNode(it.rtType, it.pos);
        if (it.paraList != null)
            for (typeNode type: it.paraList.typeList) {
                argType.add(gScope.getTypeFromTypeNode(type, it.pos));
            }
        Function f = new Function(it.name, argType, rtType, it.pos);
        if (currentStruct != null) {
            currentStruct.addFunction(it.name, f, it.pos);
        } else {
            gScope.addFunc(it.name, f, it.pos);
        }
    }

    @Override
    public void visit(typeNode it) {

    }

    @Override
    public void visit(varDefUnitNode it) {

    }

    @Override
    public void visit(whileStmtNode it) {

    }

    @Override
    public void visit(exprForStmtNode it) {

    }

    @Override
    public void visit(vardefForStmtNode it) {

    }

    @Override
    public void visit(breakStmtNode it) {

    }

    @Override
    public void visit(continueStmtNode it) {

    }

    @Override
    public void visit(sufFixExprNode it) {

    }

    @Override
    public void visit(preFixExprNode it) {

    }

    @Override
    public void visit(ternaryConditionalExprNode it) {

    }

    @Override
    public void visit(unaryPlusExprNode it) {

    }

    @Override
    public void visit(unaryMinusExprNode it) {

    }

    @Override
    public void visit(logicalNotExprNode it) {

    }

    @Override
    public void visit(bitwiseNotExprNode it) {

    }

    @Override
    public void visit(arrayExprNode it) {

    }

    @Override
    public void visit(funcCallExpr it) {

    }

    @Override
    public void visit(newExprNode it) {

    }

    @Override
    public void visit(classComponentNode it) {

    }

    @Override
    public void visit(declarationNode it) {

    }

    @Override
    public void visit(newTypeNode it) {

    }

    @Override
    public void visit(blockStmtNode it) {

    }

    @Override
    public void visit(emptyStmt it) {

    }
}
