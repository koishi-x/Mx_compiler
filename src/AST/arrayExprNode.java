package AST;


import Util.position;

public class arrayExprNode extends exprNode {
    public exprNode arrayName; //type is judged during semantic check
    public exprNode index;     //must be int

    public arrayExprNode(exprNode arrayName, exprNode index, position pos) {
        super(pos);
        this.arrayName = arrayName;
        this.index = index;
    }
    @Override
    public boolean isAssignable() {return true;}
    @Override
    public void accept(ASTVisitor visitor) { visitor.visit(this); }
}
