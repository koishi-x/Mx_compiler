package AST;

import Util.position;

import java.util.ArrayList;

public class funcCallExpr extends exprNode{

    public String name;

    public exprNode parentClass;
    public ArrayList<exprNode> argList;

    public funcCallExpr(String name, position pos) {
        super(pos);
        this.name = name;
        this.argList = new ArrayList<>();
        this.parentClass = null;
    }
    @Override
    public void accept(ASTVisitor visitor) { visitor.visit(this); }
}
