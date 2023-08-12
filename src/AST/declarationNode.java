package AST;

import Util.position;
public class declarationNode extends ASTNode{
    public int decType;             //0,1,2,3
    public fnRootNode fnRoot;       //0
    public varDefStmtNode varDef;   //1
    public classDefNode classDef;   //2
    public functionNode funcDef;    //3


    public declarationNode(int decType, position pos) {
        super(pos);
        this.decType = decType;
        classDef = null;
        funcDef = null;
        fnRoot = null;
        varDef = null;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
