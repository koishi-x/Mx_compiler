package AST;

public interface ASTVisitor {
    void visit(rootNode it);
    void visit(classDefNode it);
    void visit(fnRootNode it);

    void visit(varDefStmtNode it);
    void visit(returnStmtNode it);
    void visit(exprStmtNode it);
    void visit(ifStmtNode it);

    void visit(assignExprNode it);
    void visit(binaryExprNode it);
    void visit(constExprNode it);
    void visit(cmpExprNode it);
    void visit(varExprNode it);
    void visit(paraListNode it);
    void visit(functionNode it);

    void visit(typeNode it);

    void visit(varDefUnitNode it);

    void visit(whileStmtNode it);

    void visit(exprForStmtNode it);

    void visit(vardefForStmtNode it);

    void visit(breakStmtNode it);

    void visit(continueStmtNode it);

    void visit(sufFixExprNode it);

    void visit(preFixExprNode it);

    void visit(ternaryConditionalExprNode it);

    void visit(unaryPlusExprNode it);

    void visit(unaryMinusExprNode it);

    void visit(logicalNotExprNode it);

    void visit(bitwiseNotExprNode it);

    void visit(arrayExprNode it);

    void visit(funcCallExpr it);

    void visit(newExprNode it);

    void visit(classComponentNode it);

    void visit(declarationNode it);

    void visit(newTypeNode it);

    void visit(blockStmtNode it);

    void visit(emptyStmt it);
}
