package AST;

import Util.Type;
import Util.position;
public class typeNode extends ASTNode{
    public String typeName;
    public Type type = null;
    public int dimensions;

    public typeNode(String typeName, int dimensions, position pos) {
        super(pos);
        this.typeName = typeName;
        this.dimensions = dimensions;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
