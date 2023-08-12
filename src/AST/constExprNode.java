package AST;

import Util.Type;
import Util.position;

public class constExprNode extends exprNode {
    public long intValue;
    public boolean boolValue;

    public String stringValue;

    public constExprNode(Type type, position pos) {
        super(pos);
        this.type = type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
