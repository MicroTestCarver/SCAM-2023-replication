package test_generator;

import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtFieldReference;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpoonMapper {

    CtType root;

    public SpoonMapper(CtType root){
        this.root = root;
    }

    public List<CtFieldReference> getFields(List<Field> runtimeFields){
        ArrayList<CtFieldReference> fields = new ArrayList<CtFieldReference>();

        for(Field runtimeField: runtimeFields){
            CtFieldReference field = root.getDeclaredOrInheritedField(runtimeField.getName());
            fields.add(field);
        }

        return fields;
    }

    public HashMap<CtFieldReference, Field> mapFields(List<Field> runtimeFields){
        HashMap<CtFieldReference, Field> fields = new HashMap<>();

        for(Field runtimeField: runtimeFields){
            CtFieldReference field = root.getDeclaredOrInheritedField(runtimeField.getName());
            fields.put(field, runtimeField);

        }

        return fields;
    }

    public CtFieldReference mapField(Field runtimeField){
        return root.getDeclaredOrInheritedField(runtimeField.getName());
    }
}
