package AST;

import Util.position;

public class logicalNotExprNode extends exprNode{
    public exprNode expr;
    public logicalNotExprNode(exprNode expr, position pos) {
        super(pos);
        this.expr = expr;
    }


    @Override
    public void accept(ASTVisitor visitor) { visitor.visit(this); }
}
