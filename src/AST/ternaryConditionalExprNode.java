package AST;

import Util.position;
public class ternaryConditionalExprNode extends exprNode{
    public exprNode condition;
    public exprNode thenExpr, elseExpr;

    public ternaryConditionalExprNode(exprNode condition, exprNode thenExpr, exprNode elseExpr, position pos) {
        super(pos);
        this.condition = condition;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
