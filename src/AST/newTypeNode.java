package AST;

import Util.position;

import java.util.ArrayList;

public class newTypeNode extends typeNode{

    public ArrayList<exprNode> sizes;
    public newTypeNode(String typeName, int dimensions, position pos) {
        super(typeName, dimensions, pos);
        sizes = new ArrayList<>();
    }

    public newTypeNode rmFirstDim() {
        assert (sizes != null);
        newTypeNode node = new newTypeNode(typeName, dimensions - 1, pos);
        node.sizes = new ArrayList<>();
        for (int i = 1; i < sizes.size(); ++i) {
            node.sizes.add(sizes.get(i));
        }
        return node;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
