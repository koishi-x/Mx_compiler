package Util;

public class functionScope {
//    private HashMap<String, functionNode> members;
//    private functionScope parentScope;
//
//
//    public functionScope(functionScope parentScope) {
//        members = new HashMap<>();
//        this.parentScope = parentScope;
//    }
//
//    public functionScope parentScope() {
//        return parentScope;
//    }
//
//    public void defineFunction(String name, functionNode t, position pos) {
//        if (members.containsKey(name))
//            throw new semanticError("Semantic Error: function redefine", pos);
//        members.put(name, t);
//    }
//
//    public boolean containsFunction(String name, boolean lookUpon) {
//        if (members.containsKey(name)) return true;
//        else if (parentScope != null && lookUpon)
//            return parentScope.containsFunction(name, true);
//        else return false;
//    }
//    public functionNode getType(String name, boolean lookUpon) {
//        if (members.containsKey(name)) return members.get(name);
//        else if (parentScope != null && lookUpon)
//            return parentScope.getType(name, true);
//        return null;
//    }
}
