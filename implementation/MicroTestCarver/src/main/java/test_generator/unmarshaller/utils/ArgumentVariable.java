package test_generator.unmarshaller.utils;

import spoon.reflect.reference.CtVariableReference;

public class ArgumentVariable {

    public CtVariableReference variable;
    public int order;

    ArgumentVariable(CtVariableReference variable, int order){
        this.variable = variable;
        this.order = order;
    }

}
