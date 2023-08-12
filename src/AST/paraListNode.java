package AST;

import Util.position;

import java.util.ArrayList;

public class paraListNode extends ASTNode
{
    public ArrayList<typeNode> typeList;
    public ArrayList<String> nameList;
//    public returnType voidType;
//    public returnType conType;

    public paraListNode(position pos) {
        super(pos);
//        voidType = new returnType();
//        voidType.isVoid = true;
//        conType = new returnType();
//        conType.isConstruction = true;
        this.typeList = new ArrayList<>();
        this.nameList = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
