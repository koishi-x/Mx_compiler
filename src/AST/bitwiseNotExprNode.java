package AST;

import Util.position;

public class bitwiseNotExprNode extends exprNode{
    public exprNode expr;
    public bitwiseNotExprNode(exprNode expr, position pos) {
        super(pos);
        this.expr = expr;
    }


    @Override
    public void accept(ASTVisitor visitor) { visitor.visit(this); }
}
