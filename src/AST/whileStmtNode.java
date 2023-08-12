package AST;

import Util.position;

public class whileStmtNode extends stmtNode{
    public exprNode condition;
    public stmtNode body;

    public whileStmtNode(exprNode condition, stmtNode body, position pos) {
        super(pos);
        this.condition = condition;
        this.body = body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
