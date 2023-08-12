package AST;

import Util.position;
public class classComponentNode extends ASTNode {

    // 0 represents member variable, 1 represents construction function, 2 represents member function.
    public int componentType;

    public varDefStmtNode varDef = null;
    public functionNode funcDef = null;

    public classComponentNode(int componentType, position pos) {
        super(pos);
        this.componentType = componentType;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
