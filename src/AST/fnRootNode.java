package AST;
import Util.Type;
import Util.position;

import java.util.ArrayList;

public class fnRootNode extends ASTNode {
    public ArrayList<stmtNode> stmts;
    public Type intType, boolType, stringType, voidType, conType, arrayType, thisType, nullType;

    public fnRootNode(position pos) {
        super(pos);
        stmts = new ArrayList<>();
        intType = new Type();
        boolType = new Type();
        stringType = new Type();
        voidType = new Type();
        conType = new Type();
        arrayType = new Type();
        thisType = new Type();
        nullType = new Type();

        intType.isInt = true;
        boolType.isBool = true;
        stringType.isString = true;
        voidType.isVoid = true;
        conType.isCon = true;
        arrayType.isArray = true;
        thisType.isThis = true;
        nullType.isNull = true;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
