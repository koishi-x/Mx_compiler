package Util;

import java.util.ArrayList;

public class Function {
    public Type rtType;
    public String name;
    public ArrayList<Type> argType;
//    public Function(position pos) {
//        this.pos = pos;
//        argType = new ArrayList<>();
//        rtType = new Type();
//    }

    public Function(String name, ArrayList<Type> argType, Type rtType, position pos) {
        this.name = name;
        this.rtType = rtType;
        this.argType = argType;
        if (argType == null) this.argType = new ArrayList<>();
    }
}