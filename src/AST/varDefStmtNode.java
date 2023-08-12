package AST;

import Util.position;

import java.util.ArrayList;

public class varDefStmtNode extends stmtNode {
    //public String typeName;
    public typeNode typeName;

    public String parentClassName;

//    public ArrayList<String> name;
//    public ArrayList<exprNode> init;
    public ArrayList<varDefUnitNode> units;

    public varDefStmtNode(typeNode typeName, position pos) {
        super(pos);
        this.typeName = typeName;
        units = new ArrayList<>();
        parentClassName = null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
