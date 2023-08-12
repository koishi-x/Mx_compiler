package AST;

import Util.Type;
import Util.position;

public abstract class stmtNode extends ASTNode {
    public Type rtType = null;
    public stmtNode(position pos) {
        super(pos);
    }

    public boolean isBlockStmt() {return false;}

    public void setForBlock() {}
}
