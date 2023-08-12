package AST;

import Util.position;

public class returnStmtNode extends stmtNode {
    public exprNode value;

    public returnStmtNode(exprNode value, position pos) {
        super(pos);
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
