package parser;

public class ParserUtils {

    public ParserUtils(){}

    public boolean containsAll(String line, String [] words){
        for (String word : words){
            if(!line.contains(word)){
                return false;
            }
        }
        return true;
    }

    public boolean isPrimitiveType(String type) {
        if (type == null || type == "" || type == "null")
            return true;
        if (type.equals("java.lang.String"))
            return true;
        if (type.equals("java.lang.Integer"))
            return true;
        if (type.equals("java.lang.Long"))
            return true;
        if (type.equals("java.lang.Short"))
            return true;
        if (type.equals("java.lang.Float"))
            return true;
        if (type.equals("java.lang.Double"))
            return true;
        if (type.equals("java.lang.Byte"))
            return true;
        if (type.equals("java.lang.AtomicLong"))
            return true;
        if (type.equals("java.lang.AtomicInteger"))
            return true;
        return false;
    }
}
