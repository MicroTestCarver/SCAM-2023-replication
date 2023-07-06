package test_generator.unmarshaller.types;

public class StringUnmarshaller {

    public String unmarshalString(String object){
        if(object.length() >= 2){
            if(object.startsWith("\"") || object.startsWith("\'")){
                if(object.endsWith("\"") || object.endsWith("\'")){
                    return object;
                }
            }
        }
        return "\"" + object + "\"";
    }
}
