package test_generator.unmarshaller.utils;

import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.reference.CtFieldReference;
import test_generator.unmarshaller.UnmarshalledVariable;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ResolvedConstructor {
    public CtConstructor constructor;
    public List<ResolvedParameter> parameters;

    public HashMap<CtFieldReference, Field> unresolvedFields;
    public ResolvedConstructor(CtConstructor constructor, List<ResolvedParameter> parameters){
        this.constructor = constructor;
        this.parameters = parameters;
        unresolvedFields = new HashMap<>();
    }

    public String paramsToString(){
        StringBuilder string = new StringBuilder();
        for(ResolvedParameter param : parameters){
            string.append(param.parameter + " <" + param.value + ">" + ", ");
        }
        return string.toString();
    }

    public String paramsToUnmarshal(){
        StringBuilder string = new StringBuilder();
        Iterator it = parameters.iterator();
        while (it.hasNext()) {
            ResolvedParameter param = (ResolvedParameter) it.next();
            UnmarshalledVariable uv = new UnmarshalledVariable(param.value, param.parameter.getType().getTypeDeclaration());
            String s = uv.getInlineOrVariable();
            string.append(s);

            if (it.hasNext()) {
                string.append(", ");
            }
        }
        return string.toString();
    }

    @Override
    public String toString() {
        return "Constructor: " + constructor + "\n" +
                "Params: " + paramsToString();
    }

    public String toUnmarshal() {
        return "new " + constructor.getType().getSimpleName() + "(" + paramsToUnmarshal()+ ")";
    }
}
