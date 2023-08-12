package Util;

import Util.error.semanticError;

import java.util.HashMap;

public class Scope {

    private HashMap<String, Type> members;

    protected HashMap<String, Function> funcs;

    protected HashMap<String, Type> types;
    //public HashMap<String, register> entities = new HashMap<>();
    private Scope parentScope;


    public Scope(Scope parentScope) {
        members = new HashMap<>();
        funcs = new HashMap<>();
        types = new HashMap<>();
        this.parentScope = parentScope;
    }

    public Scope parentScope() {
        return parentScope;
    }

    public void defineVariable(String name, Type t, position pos) {
        if (members.containsKey(name) || funcs.containsKey(name))
            throw new semanticError("Semantic Error: variable redefine", pos);
        members.put(name, t);
    }

    public boolean containsVariable(String name, boolean lookUpon) {
        if (members.containsKey(name)) return true;
        else if (funcs.containsKey(name)) return false;     //variable and function cannot have duplicate name.
        else if (parentScope != null && lookUpon)
            return parentScope.containsVariable(name, true);
        else return false;
    }
    public Type getType(String name, position pos) {
        if (members.containsKey(name)) return members.get(name);
        else if (funcs.containsKey(name)) {
            throw new semanticError("Semantic error: funcion and variable cannot have duplicate name", pos);
            //function and class cannot have duplicate name.
        }
        else if (parentScope != null)
            return parentScope.getType(name, pos);
        throw new semanticError("Semantic error: variable not defined", pos);
    }



    public void addFunc(String name, Function f, position pos) {
        if (funcs.containsKey(name) || members.containsKey(name) || types.containsKey(name)) {
            throw new semanticError("multiple definition of " + name, pos);
        }
        funcs.put(name, f);
    }

    public Function getFuncFromName(String name, position pos) {
        if (funcs.containsKey(name)) return funcs.get(name);
        else if (members.containsKey(name)) throw new semanticError(name + " is defined as variable here.", pos);

        else if (parentScope != null) return parentScope.getFuncFromName(name, pos);
        throw new semanticError("no such function: " + name, pos);
    }
//    public register getEntity(String name, boolean lookUpon) {
//        if (entities.containsKey(name)) return entities.get(name);
//        else if (parentScope != null && lookUpon)
//            return parentScope.getEntity(name, true);
//        return null;
//    }
}