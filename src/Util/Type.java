package Util;

import AST.functionNode;
import Util.error.semanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class Type {
    public boolean isInt = false;
    public boolean isBool = false;
    public boolean isString = false;
    //public boolean isConstString = false;
    public boolean isVoid = false;
    public boolean isCon = false;
    public boolean isArray = false;
    public boolean isThis = false;
    public boolean isNull = false;
    public Type arrayType = null;
    public int dimension = 0, size = 0;

    public ArrayList<Type> arrayElement = new ArrayList<>();
    public HashMap<String, Type> members = null;
    public HashMap<String, Function> funcs = null;
    public functionNode constructionFunc = null;

    public void addMember(String name, Type type, position pos) {
        assert (members != null);
        if (members.containsKey(name) || funcs.containsKey(name)) {
            throw new semanticError("redefinition of member " + name, pos);
        }
        members.put(name, type);
    }

    public void addFunction(String name, Function f, position pos) {
        assert (funcs != null);
        if (members.containsKey(name) || funcs.containsKey(name)) {
            throw new semanticError("redefinition of member " + name, pos);
        }
        funcs.put(name, f);
    }

    public Type getMember(String name, position pos) {
        if (members == null || !members.containsKey(name)) {
            throw new semanticError("Semantic error: class does not contain this member", pos);
        }
        return members.get(name);

    }

    public Function getFunction(String name, position pos) {
        if (isArray && name.equals("size")) {
            Type intType = new Type();
            intType.isInt = true;
            return new Function("this", new ArrayList<>(), intType, pos);
        }

        if (funcs == null || !funcs.containsKey(name)) {
            throw new semanticError("Semantic error: class does not contain this method", pos);
        }
        return funcs.get(name);
    }
    public boolean equal(Type other) {
        if (this == other) return true;

        if (isInt) {
            if (other.isInt) return true;
            else return false;
        }
        if (isBool) {
            if (other.isBool) return true;
            return false;
        }
        if (isString && other.isString) return true;
        if (isVoid && other.isVoid) return true;
        if (isThis && other.isThis) return true;

        if (isNull || other.isNull) return true;
        if (isArray && other.isArray) {
            if (this.arrayType.equal(other.arrayType) && this.dimension == other.dimension) {
                return true;
            }
            return false;
        }
        return false;
    }
}