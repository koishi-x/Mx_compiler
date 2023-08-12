package AST;

import Util.Type;
import Util.position;

public class cmpExprNode extends exprNode {
    public exprNode lhs, rhs;
    public enum cmpOpType {
        eq, neq, less, leq, greater, geq
    }
    public cmpOpType opCode;

    public cmpExprNode(exprNode lhs, exprNode rhs, cmpOpType opCode, Type boolType, position pos) {
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
        this.opCode = opCode;
        type = boolType;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
