package AST;

import Util.position;
public class preFixExprNode extends exprNode{
    public exprNode expr;
    public enum opType {add, sub}
    public opType op;

    public preFixExprNode(exprNode expr, int op, position pos) {
        super(pos);
        this.expr = expr;
        if (op == 0) this.op = opType.add;
        else this.op = opType.sub;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAssignable() {

        //return expr.isAssignable();     //should be true
        return true;
    }
}
