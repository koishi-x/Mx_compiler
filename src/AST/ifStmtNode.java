package AST;

import Util.position;

public class ifStmtNode extends stmtNode {
    public exprNode condition;
    public stmtNode thenStmt, elseStmt;

    public ifStmtNode(exprNode condition, stmtNode thenStmt, stmtNode elseStmt, position pos) {
        super(pos);
        this.condition = condition;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
