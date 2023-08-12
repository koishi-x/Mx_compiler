package AST;

import Util.position;

public class varExprNode extends exprNode {
    public exprNode parentClass;

    public String name;

    public varExprNode(String name, position pos) {
        super(pos);
        this.name = name;
        parentClass = null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAssignable() {return true;}

}
