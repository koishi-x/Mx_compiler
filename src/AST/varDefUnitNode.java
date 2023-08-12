package AST;

import Util.position;

public class varDefUnitNode extends ASTNode {
    //public String typeName;

    public String name;
    public exprNode init;

    public varDefUnitNode(String name, exprNode init, position pos) {
        super(pos);
        this.name = name;
        this.init = init;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
