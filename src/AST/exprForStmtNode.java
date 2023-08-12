package AST;

import Util.position;

public class exprForStmtNode extends stmtNode {
    public exprNode init;
    public exprNode condition;
    public exprNode step;
    public stmtNode body;

    public exprForStmtNode(exprNode init, exprNode condition, exprNode step, stmtNode body, position pos) {
        super(pos);
        this.init = init;
        this.condition = condition;
        this.step = step;
        this.body = body;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
