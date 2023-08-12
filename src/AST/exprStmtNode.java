package AST;

import Util.position;

public class exprStmtNode extends stmtNode {
    public exprNode expr;

    public exprStmtNode(exprNode expr, position pos) {
        super(pos);
        this.expr = expr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
