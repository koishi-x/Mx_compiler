package AST;

import Util.position;

import java.util.ArrayList;

public class functionNode extends ASTNode{

    public ArrayList<stmtNode> stmts;
    public paraListNode paraList;
    public String parentClassName;

    public typeNode rtType;
    public String name;
    public functionNode(String name, paraListNode paraList, typeNode rtType, position pos) {
        super(pos);
        this.name = name;
        this.stmts = new ArrayList<>();
        this.paraList = paraList;
          //todo:deliver scope
        this.parentClassName = null;
        this.rtType = rtType;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
