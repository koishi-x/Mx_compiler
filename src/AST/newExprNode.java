package AST;

import Util.position;

public class newExprNode extends exprNode{
    public newTypeNode newType = null;

//    public newExprNode(String typeName, int dimesions, position pos) {
//        super(pos);
//        type = new newTypeNode(typeName, dimesions, pos);
//
//    }
    public newExprNode(newTypeNode newType, position pos) {
        super(pos);
        this.newType = newType;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override public boolean isNewExpr() {return true;}
}
