package Util;

import AST.typeNode;
import Util.error.semanticError;

public class globalScope extends Scope{

    public globalScope(Scope parentScope) {
        super(parentScope);
    }
    public void addType(String name, Type t, position pos) {
        if (types.containsKey(name) || funcs.containsKey(name))
            throw new semanticError("multiple definition of " + name, pos);
        types.put(name, t);
    }
    public Type getTypeFromName(String name, position pos) {
        if (types.containsKey(name)) return types.get(name);
        throw new semanticError("no such type from name: " + name, pos);
    }

    public Type getTypeFromTypeNode(typeNode node, position pos) {
        if (types.containsKey(node.typeName)) {
            if (node.dimensions == 0) {
                return types.get(node.typeName);
            } else {
                Type type = new Type();
                type.isArray = true;
                type.arrayType = types.get(node.typeName);
                type.dimension = node.dimensions;
                return type;
            }
        }

        throw new semanticError("no such type from node: " + node.typeName, pos);
    }
}
