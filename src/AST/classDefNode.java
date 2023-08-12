package AST;

import Util.position;

import java.util.ArrayList;

public class classDefNode extends ASTNode {
    public ArrayList<varDefStmtNode> varDefs;
    public ArrayList<functionNode> memberFunc;
    public functionNode constructionFunc;
    public String name;

//    public classDefNode(position pos, String name, ArrayList<functionNode> memberFunc, functionNode constructionFunc) {
//        super(pos);
//        this.name = name;
//        this.memberFunc = memberFunc;
//        this.constructionFunc = constructionFunc;
//    }
    public classDefNode(String name, position pos) {
        super(pos);
        this.name = name;
        varDefs = new ArrayList<>();
        memberFunc = new ArrayList<>();
        constructionFunc = null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
