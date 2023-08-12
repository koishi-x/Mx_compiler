package AST;

import Util.position;

public class unaryMinusExprNode extends exprNode{
    public exprNode expr;
    public unaryMinusExprNode(exprNode expr, position pos) {
        super(pos);
        this.expr = expr;
    }


    @Override
    public void accept(ASTVisitor visitor) { visitor.visit(this); }
}
