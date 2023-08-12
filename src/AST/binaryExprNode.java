package AST;

import Util.position;

public class binaryExprNode extends exprNode {
    public exprNode lhs, rhs;
    public enum binaryOpType {
        add, sub, mul, div, mod, lshift, rshift, and, or, xor, andand, oror
    }
    public binaryOpType opCode;

    public binaryExprNode(exprNode lhs, exprNode rhs, binaryOpType opCode, position pos) {
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
        this.opCode = opCode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
