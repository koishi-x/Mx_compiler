package AST;

import Util.position;

import java.util.ArrayList;

public class rootNode extends ASTNode {
//    public fnRootNode fn;
//    public ArrayList<classDefNode> classDefs = new ArrayList<>();
//
//    public ArrayList<functionNode> functionDefs = new ArrayList<>();
    public ArrayList<declarationNode> declarations;
    public boolean hasMain = false;

    public rootNode(position pos) {
        super(pos);
        this.declarations = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
