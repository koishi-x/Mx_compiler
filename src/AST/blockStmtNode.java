package AST;

import Util.position;

import java.util.ArrayList;

public class blockStmtNode extends stmtNode{
    public ArrayList<stmtNode> stmts;

    public boolean isForBlock = false;

    public blockStmtNode(position pos) {
        super(pos);
        stmts = new ArrayList<>();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override public boolean isBlockStmt() {return true;}

    @Override public void setForBlock() {isForBlock = true;}
}
