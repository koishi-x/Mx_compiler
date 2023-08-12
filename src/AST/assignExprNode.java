package AST;

import Util.position;

public class assignExprNode extends exprNode {
    public exprNode lhs, rhs;

    public assignExprNode(exprNode lhs, exprNode rhs, position pos) {
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
