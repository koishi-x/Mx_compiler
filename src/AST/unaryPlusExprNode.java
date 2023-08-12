package AST;

import Util.position;

public class unaryPlusExprNode extends exprNode{
    public exprNode expr;
    public unaryPlusExprNode(exprNode expr, position pos) {
        super(pos);
        this.expr = expr;
    }


    @Override
    public void accept(ASTVisitor visitor) { visitor.visit(this); }
}
