package AST;

import MIR.entity;
import Util.Type;
import Util.position;

public abstract class exprNode extends ASTNode {
    public Type type;
    public entity val;

    public exprNode(position pos) {

        super(pos);
        type = new Type();
    }

    public boolean isAssignable() {
        return false;
    }

    public boolean isNewExpr() {return false;}
}
