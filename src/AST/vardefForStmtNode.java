package AST;

import Util.position;

public class vardefForStmtNode extends stmtNode {
    public varDefStmtNode init;
    public exprNode condition;
    public exprNode step;
    public stmtNode body;

    public vardefForStmtNode(varDefStmtNode init, exprNode condition, exprNode step, stmtNode body, position pos) {
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
