package Frontend;

import AST.*;
import AST.binaryExprNode.binaryOpType;
import AST.cmpExprNode.cmpOpType;
import Util.Function;
import Util.Scope;
import Util.Type;
import Util.error.semanticError;
import Util.error.syntaxError;
import Util.globalScope;

public class SemanticCheck implements ASTVisitor {
    private Scope currentScope;
    private globalScope gScope;
    private Type currentStruct = null;
    private Type currentRtType = null;
    private int loopDepth = 0;
    private Type intType, boolType, stringType, voidType, conType, arrayType, thisType, nullType;

    public SemanticCheck(globalScope gScope) {
        currentScope = this.gScope = gScope;
//        intType = new Type();
//        boolType = new Type();
//        stringType = new Type();
//        voidType = new Type();
//        conType = new Type();
        arrayType = new Type();
        thisType = new Type();
        nullType = new Type();

//        intType.isInt = true;
//        boolType.isBool = true;
//        stringType.isString = true;
//        voidType.isVoid = true;
//        conType.isCon = true;
        arrayType.isArray = true;
        thisType.isThis = true;
        nullType.isNull = true;
    }
    @Override
    public void visit(rootNode it) {
        intType = gScope.getTypeFromName("int", it.pos);
        boolType = gScope.getTypeFromName("bool", it.pos);
        stringType = gScope.getTypeFromName("string", it.pos);
        voidType = gScope.getTypeFromName("void", it.pos);
        conType = gScope.getTypeFromName("class", it.pos);

        for (declarationNode dec: it.declarations) {
            if (dec.decType == 0) {
                dec.fnRoot.accept(this);
            } else if (dec.decType == 1) {
                dec.varDef.accept(this);
            } else if (dec.decType == 2) {
                dec.classDef.accept(this);
            } else if (dec.decType == 3) {
                dec.funcDef.accept(this);
            }
        }
    }

    @Override
    public void visit(classDefNode it) {
//        currentStruct = gScope.getTypeFromName(it.name, it.pos);
//        it.varDefs.forEach(vd -> vd.accept(this));
//        currentStruct = null;
        currentStruct = gScope.getTypeFromName(it.name, it.pos);
        currentScope = new Scope(currentScope);

        currentStruct.members.forEach((name, type) -> {
            currentScope.defineVariable(name, type, it.pos);
        });
        currentStruct.funcs.forEach((name, f) -> {
            currentScope.addFunc(name, f, it.pos);
        });
        it.memberFunc.forEach(fd -> fd.accept(this));
        if (it.constructionFunc != null) it.constructionFunc.accept(this);

        currentStruct = null;
        currentScope = currentScope.parentScope();
    }

    @Override
    public void visit(fnRootNode it) {
//        intType = it.intType;
//        boolType = it.boolType;
//        stringType = it.stringType;
//        voidType = it.voidType;
//        conType = it.conType;
//        arrayType = it.arrayType;
//        thisType = it.thisType;
//        nullType = it.nullType;

        currentScope = new Scope(currentScope);
        currentRtType = it.intType;
        for (stmtNode stmt: it.stmts) {
            stmt.accept(this);
//            if (stmt.rtType != null) {
//                assert (stmt.rtType.equal(currentRtType));
//            }
        }
        currentScope = currentScope.parentScope();
        currentRtType = null;
    }

    @Override
    public void visit(varDefStmtNode it) {
        Type type = gScope.getTypeFromTypeNode(it.typeName, it.pos);
        for (varDefUnitNode unit: it.units) {
            if (unit.init != null) {
                unit.init.accept(this);
                if (unit.init.type.isThis) {
                    if (currentStruct != null) unit.init.type = currentStruct;
                    else throw new semanticError("Semantic error: this cannot be used out of class", unit.init.pos);
                }
                if (!unit.init.type.equal(type)) {
                    throw new semanticError("Semantic error: initialization expression type not match", unit.init.pos);
                }
            }
            currentScope.defineVariable(unit.name, type, unit.pos);
        }
    }

    @Override
    public void visit(returnStmtNode it) {
        assert(currentRtType != null);
        if (it.value == null) {
            if (!currentRtType.isVoid && !currentRtType.isCon)
                throw new semanticError("Semantic error: missing return value", it.pos);
        } else {
            it.value.accept(this);

            if (it.value.type.isThis) {
                if (currentStruct != null) it.value.type = currentStruct;
                else throw new semanticError("Semantic error: this cannot be used out of class", it.value.pos);
            }

            if (it.value.type.equal(currentRtType)) {
                it.rtType = it.value.type;
            } else throw new semanticError("Semantic error: return value not match", it.value.pos);
        }
    }

    @Override
    public void visit(exprStmtNode it) {
        it.expr.accept(this);
    }

    @Override
    public void visit(assignExprNode it) {

        it.lhs.accept(this);
        if (!it.lhs.isAssignable())
            throw new semanticError("Semantic error: type is not assignable", it.lhs.pos);

        it.rhs.accept(this);
        if (it.rhs.type.isThis) {
            if (currentStruct != null) it.rhs.type = currentStruct;
            else throw new semanticError("Semantic error: this cannot be used out of class", it.rhs.pos);
        }
        if (it.lhs.type.equal(it.rhs.type)) {
            it.type = it.lhs.type;
        } else
            throw new semanticError("Semantic error: type not match", it.lhs.pos);
    }

    @Override
    public void visit(binaryExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (it.opCode == binaryOpType.add) {

            if (it.lhs.type.isInt) {
                if (it.rhs.type.isInt) {
                    it.type = intType;
                } else {
                    throw new semanticError("Semantic error: type not match. It should be int", it.rhs.pos);
                }
            }
            else if (it.lhs.type.isString) {
                if (it.rhs.type.isString) {
                    it.type = stringType;
                } else {
                    throw new semanticError("Semantic error: type not match. It should be string", it.rhs.pos);
                }
            } else {
                throw new semanticError("Semantic error: type cannot be added", it.lhs.pos);
            }
        } else if (it.opCode == binaryOpType.sub || it.opCode == binaryOpType.mul || it.opCode == binaryOpType.div
                || it.opCode == binaryOpType.mod || it.opCode == binaryOpType.lshift || it.opCode == binaryOpType.rshift
                || it.opCode == binaryOpType.and || it.opCode == binaryOpType.or || it.opCode == binaryOpType.xor) {
            if (it.lhs.type.isInt) {
                if (it.rhs.type.isInt) {
                    it.type = intType;
                } else {
                    throw new semanticError("Semantic error: type not match. It should be int", it.rhs.pos);
                }
            } else {
                throw new semanticError("Semantic error: type cannot do arithmetic calculation", it.lhs.pos);
            }
        } else if (it.opCode == binaryOpType.andand || it.opCode == binaryOpType.oror) {
            if (it.lhs.type.isBool) {
                if (it.rhs.type.isBool) {
                    it.type = boolType;
                } else {
                    throw new semanticError("Semantic error: type not match. It should be bool", it.rhs.pos);
                }
            } else {
                throw new semanticError("Semantic error: type cannot do logical calculation", it.lhs.pos);
            }
        } else {
            throw new semanticError("Semantic error: unknown operation type", it.lhs.pos);
        }
    }

    @Override
    public void visit(constExprNode it) {
        //nothing
    }

    @Override
    public void visit(cmpExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);

        if (it.opCode == cmpOpType.less || it.opCode == cmpOpType.leq || it.opCode == cmpOpType.greater || it.opCode == cmpOpType.geq) {
            if (it.lhs.type.isInt) {
                if (it.rhs.type.isInt) {
                    it.type = boolType;
                } else {
                    throw new semanticError("Semantic error: type not match. It should be int", it.rhs.pos);
                }
            } else if (it.lhs.type.isString) {
                if (it.rhs.type.isString) {
                    it.type = boolType;
                } else {
                    throw new semanticError("Semantic error: type not match. It should be string", it.rhs.pos);
                }
            } else {
                throw new semanticError("Semantic error: type cannot be compared", it.lhs.pos);
            }
        } else if (it.opCode == cmpOpType.eq || it.opCode == cmpOpType.neq) {
            if (it.lhs.type.isInt) {
                if (it.rhs.type.isInt) {
                    it.type = boolType;
                } else {
                    throw new semanticError("Semantic error: type not match. It should be int", it.rhs.pos);
                }
            } else if (it.lhs.type.isBool) {
                if (it.rhs.type.isBool) {
                    it.type = boolType;
                } else {
                    throw new semanticError("Semantic error: type not match. It should be bool", it.rhs.pos);
                }
            } else if (it.lhs.type.isString) {
                if (it.rhs.type.isString) {
                    it.type = boolType;
                } else {
                    throw new semanticError("Semantic error: type not match. It should be string", it.rhs.pos);
                }
            } else if (it.lhs.type.isArray) {
                if (it.rhs.type.isNull) {
                    it.type = boolType;
                } else {
                    throw new semanticError("Semantic error: array cannot be compared with null", it.rhs.pos);
                }
            } else if (it.rhs.type.isArray) {
                if (it.lhs.type.isNull) {
                    it.type = boolType;
                } else {
                    throw new semanticError("Semantic error: array cannot be compared with null", it.lhs.pos);
                }
            } else {
                if (it.lhs.type.equal(it.rhs.type)) {
                    it.type = boolType;
                } else {
                    throw new semanticError("Semantic error: different types cannot be compared", it.lhs.pos);
                }
            }
        }
    }

    @Override
    public void visit(varExprNode it) {
        if (it.type != null) {
            if (it.parentClass != null) {
                it.parentClass.accept(this);
                if (it.parentClass.type.isThis) {
                    assert (currentStruct != null);
                    it.type = currentStruct.getMember(it.name, it.pos);
                } else {
                    it.type = it.parentClass.type.getMember(it.name, it.pos);
                }
            } else {
                //System.out.println("!!!");
                it.type = currentScope.getType(it.name, it.pos);
            }
        }
    }

    @Override
    public void visit(paraListNode it) {
        //nothing
    }

    @Override
    public void visit(functionNode it) {
        currentScope = new Scope(currentScope);
        currentRtType = gScope.getTypeFromTypeNode(it.rtType, it.rtType.pos);

        if (it.paraList != null) {
            assert (it.paraList.nameList.size() == it.paraList.typeList.size());
            for (int i = 0; i < it.paraList.nameList.size(); ++i) {
                currentScope.defineVariable(it.paraList.nameList.get(i),
                        gScope.getTypeFromTypeNode(it.paraList.typeList.get(i), it.pos), it.pos);
            }
        }
        boolean hasReturnValue = false;
        for (stmtNode stmt: it.stmts) {
//            it.stmts.forEach(stmt -> stmt.accept(this));
            stmt.accept(this);
            if (stmt.rtType != null) {
                assert (stmt.rtType.equal(currentRtType));
                hasReturnValue = true;
            }
        }
        if (!currentRtType.isVoid && !currentRtType.isCon && !hasReturnValue) {
            throw new semanticError("Semantic error: non-void function must have a return value", it.rtType.pos);
        }
        currentScope = currentScope.parentScope();
        currentRtType = null;
    }

    @Override
    public void visit(typeNode it) {
        //nothing
//        if (it.type == null) {
//            it.type = gScope.getTypeFromTypeNode(it, it.pos);
//        }
    }

    @Override
    public void visit(varDefUnitNode it) {
        //nothing
    }

    @Override
    public void visit(ifStmtNode it) {
        it.condition.accept(this);
        if (!it.condition.type.isBool)
            throw new semanticError("Semantic error: it should be bool", it.condition.pos);
        currentScope = new Scope(currentScope);
        if (it.thenStmt.isBlockStmt()) it.thenStmt.setForBlock();
        it.thenStmt.accept(this);
        it.rtType = it.thenStmt.rtType;
        currentScope = currentScope.parentScope();
        if (it.elseStmt != null) {
            currentScope = new Scope(currentScope);
            if (it.elseStmt.isBlockStmt()) it.elseStmt.setForBlock();
            it.elseStmt.accept(this);
            if (it.elseStmt.rtType == null) it.rtType = null;
            currentScope = currentScope.parentScope();
        }
    }

    @Override
    public void visit(whileStmtNode it) {
        it.condition.accept(this);
        if (!it.condition.type.isBool)
            throw new semanticError("Semantic error: it should be bool", it.condition.pos);

        loopDepth++;
        currentScope = new Scope(currentScope);
        if (it.body.isBlockStmt()) it.body.setForBlock();
        it.body.accept(this);
        loopDepth--;
        currentScope = currentScope.parentScope();
        it.rtType = it.body.rtType;
    }

    @Override
    public void visit(exprForStmtNode it) {
        if (it.init != null) it.init.accept(this);
        if (it.condition != null) {
            it.condition.accept(this);
            if (!it.condition.type.isBool) {
                throw new semanticError("Semantic error: for condition expression should be bool", it.condition.pos);
            }
        }
        if (it.step != null) it.step.accept(this);
        loopDepth++;
        currentScope = new Scope(currentScope);
        if (it.body.isBlockStmt()) it.body.setForBlock();
        it.body.accept(this);
        loopDepth--;
        currentScope = currentScope.parentScope();
        it.rtType = it.body.rtType;
    }

    @Override
    public void visit(vardefForStmtNode it) {


        if (it.body.isBlockStmt()) it.body.setForBlock();;
        currentScope = new Scope(currentScope);
        it.init.accept(this);
        if (it.condition != null) {
            it.condition.accept(this);
            if (!it.condition.type.isBool) {
                throw new semanticError("Semantic error: for condition expression should be bool", it.condition.pos);
            }
        }
        if (it.step != null) it.step.accept(this);
        loopDepth++;
        it.body.accept(this);
        loopDepth--;
        it.rtType = it.body.rtType;
        currentScope = currentScope.parentScope();

    }

    @Override
    public void visit(breakStmtNode it) {
        if (loopDepth == 0)
            throw new semanticError("Semantic error: invalid break", it.pos);
    }

    @Override
    public void visit(continueStmtNode it) {
        if (loopDepth == 0)
            throw new semanticError("Semantic error: invalid continue", it.pos);
    }

    @Override
    public void visit(sufFixExprNode it) {
        it.expr.accept(this);
        if (!it.expr.isAssignable()) {
            throw new semanticError("Semantic error: expression should be assignable", it.expr.pos);
        }
        if (it.expr.type.isInt) {
            it.type = intType;
        } else {
            throw new semanticError("Semantic error: expression should be int", it.expr.pos);
        }
    }

    @Override
    public void visit(preFixExprNode it) {
        it.expr.accept(this);
        if (!it.expr.isAssignable()) {
            throw new semanticError("Semantic error: expression should be assignable", it.expr.pos);
        }
        if (it.expr.type.isInt) {
            it.type = intType;
        } else {
            throw new semanticError("Semantic error: expression should be int", it.expr.pos);
        }
    }

    @Override
    public void visit(ternaryConditionalExprNode it) {
        it.condition.accept(this);
        if (it.condition.type.isBool) {
            it.thenExpr.accept(this);
            it.elseExpr.accept(this);
            if (it.thenExpr.type.isThis) {
                if (currentStruct != null) it.thenExpr.type = currentStruct;
                else throw new semanticError("Semantic error: this cannot be used out of class", it.thenExpr.pos);
            }
            if (it.elseExpr.type.isThis) {
                if (currentStruct != null) it.elseExpr.type = currentStruct;
                else throw new semanticError("Semantic error: this cannot be used out of class", it.elseExpr.pos);
            }

            if (it.thenExpr.type.equal(it.elseExpr.type)) {
                it.type = it.thenExpr.type;
            } else {
                throw new semanticError("Semantic error: type not match", it.elseExpr.pos);
            }
        } else {
            throw new semanticError("Semantic error: condition should be bool", it.condition.pos);
        }
    }

    @Override
    public void visit(unaryPlusExprNode it) {
        it.expr.accept(this);
        if (it.expr.type.isInt) {
            it.type = intType;
        } else {
            throw new semanticError("Semantic error: + should be followed by int", it.expr.pos);
        }
    }

    @Override
    public void visit(unaryMinusExprNode it) {
        it.expr.accept(this);
        if (it.expr.type.isInt) {
            it.type = intType;
        } else {
            throw new semanticError("Semantic error: - should be followed by int", it.expr.pos);
        }
    }

    @Override
    public void visit(logicalNotExprNode it) {
        it.expr.accept(this);
        if (it.expr.type.isBool) {
            it.type.isBool = true;
        } else {
            throw new semanticError("Semantic error: ! should be followed by bool", it.expr.pos);
        }
    }

    @Override
    public void visit(bitwiseNotExprNode it) {
        it.expr.accept(this);
        if (it.expr.type.isInt) {
            it.type = intType;
        } else {
            throw new semanticError("Semantic error: ~ should be followed by int", it.expr.pos);
        }
    }

    @Override
    public void visit(arrayExprNode it) {
        it.arrayName.accept(this);
//        if (it.arrayName.isNewExpr()) {
//            throw new syntaxError("syntax error: invalid array definition", it.arrayName.pos);
//        }
        if (it.arrayName.type.isArray) {
            it.index.accept(this);
            if (it.index.type.isInt) {
                if (it.arrayName.type.dimension == 1) {
                    it.type = it.arrayName.type.arrayType;
                } else {
                    it.type = new Type();
                    it.type.isArray = true;
                    it.type.dimension = it.arrayName.type.dimension - 1;
                    it.type.arrayType = it.arrayName.type.arrayType;
                }
            } else {
                throw new semanticError("Semantic error: array index should be int", it.index.pos);
            }
        } else {
            throw new semanticError("Semantic error: type not match. It should be array", it.arrayName.pos);
        }
    }

    @Override
    public void visit(funcCallExpr it) {
        Function f;
        if (it.parentClass != null) {
            it.parentClass.accept(this);
            //Function f;
            if (it.parentClass.type.isThis) {
//                assert (currentStruct != null);
                if (currentStruct == null) {
                    throw new semanticError("Semantic error: this cannot be used out of class", it.pos);
                }
                f = currentStruct.getFunction(it.name, it.pos);
            }
            else f = it.parentClass.type.getFunction(it.name, it.pos);

        } else {
            f = currentScope.getFuncFromName(it.name, it.pos);
        }

        if (it.argList.size() != f.argType.size()) {
            throw new semanticError("Semantic error: argument numbers not match", it.pos);
        }
        for (int i = 0; i < f.argType.size(); ++i) {
            it.argList.get(i).accept(this);

            if (it.argList.get(i).type.isThis) {
                if (currentStruct != null) it.argList.get(i).type = currentStruct;
                else throw new semanticError("Semantic error: this cannot be used out of class", it.argList.get(i).pos);
            }
            if (it.argList.get(i).type.equal(f.argType.get(i))) {

            } else throw new semanticError("Semantic error: function argument's type not match", it.argList.get(i).pos);
        }
        it.type = f.rtType;
    }

    @Override
    public void visit(newExprNode it) {
        assert (it.newType != null);
        if (it.newType.dimensions > 0) {
            //assert (it.newType.sizes != null);
            if (it.newType.sizes != null) {
                for (exprNode expr: it.newType.sizes) {
                    expr.accept(this);
                    if (!expr.type.isInt)
                        throw new semanticError("Semantic error: array index should be int", expr.pos);
                }
            }
            it.type = new Type();
            it.type.isArray = true;
            it.type.dimension = it.newType.dimensions;
            it.type.arrayType = gScope.getTypeFromName(it.newType.typeName, it.pos);

        } else {
            it.type = gScope.getTypeFromName(it.newType.typeName, it.pos);
        }
    }

    @Override
    public void visit(classComponentNode it) {
        //nothing
    }

    @Override
    public void visit(declarationNode it) {
        //nothing
    }

    @Override
    public void visit(newTypeNode it) {
        //nothing
    }

    @Override
    public void visit(blockStmtNode it) {
        if (!it.isForBlock) {
            currentScope = new Scope(currentScope);
        }
        for (stmtNode stmt: it.stmts) {
            stmt.accept(this);
            if (stmt.rtType != null) it.rtType = stmt.rtType;
        }
        if (!it.isForBlock) {
            currentScope = currentScope.parentScope();
        }
    }

    @Override
    public void visit(emptyStmt it) {

    }
}
