package parser;

import java.util.*;

public class NodeMethod extends LeafMethod {

    public LeafMethod reference;
    public ArrayList<NodeMethod> childrenClazz;
    public ArrayList<LeafMethod> callee;

    public Boolean isInitMethod = false;

    public NodeMethod(Clazz clazz, String methodName, boolean duplication) {
        super(clazz, methodName, duplication);
        childrenClazz = new ArrayList<>();
        callee = new ArrayList<>();
    }

    public void addChildren(NodeMethod clazz){
        this.childrenClazz.add(clazz);
    }

    public void addMethodCallee(LeafMethod callee){
        this.callee.add(callee);
    }

    public Map<LeafMethod, Arg> methodsBasedOnFields(){
        Map<LeafMethod, Arg> map = new HashMap<>();
        Collection<LeafMethod> calleeSet = calleeAndChildren().values();
        for (Arg param: this.clazz.fields){
            for(LeafMethod ce : calleeSet){
                if(param.value.isEmpty())
                    continue;
                if(param.hash.equals(ce.hashObject)){
                    map.put(ce, param);
                }
            }
        }
        return map;
    }

    public Map<String, LeafMethod> calleeAndChildren(){
        HashMap<String, LeafMethod> calleeSet = new HashMap<>();
        for(NodeMethod nm: childrenClazz){
            calleeSet.put(nm.fullName(), nm);
        }

        for(LeafMethod lm: callee){
            LeafMethod item = calleeSet.get(lm.fullName());
            if (item == null){
                calleeSet.put(lm.fullName(), lm);
            } else {
                if (item.argTypes == null)
                    item.argTypes = lm.argTypes;
                if (item.hashObject == null)
                    item.hashObject = lm.hashObject;
                if (item.returnField == null) {
                    item.returnType = lm.returnType;
                    item.returnField = lm.returnField;
                }
                calleeSet.put(item.fullName(), item);
            }
        }

        return calleeSet;
    }
    public ArrayList<NodeMethod> getChildrenClazz() {
        return childrenClazz;
    }

    public ArrayList<LeafMethod> getCallee() {
        return callee;
    }

    public LeafMethod getReference() {
        return reference;
    }

    public void setReference(LeafMethod reference) {
        this.reference = reference;
    }

    @Override
    public String visualise(int indentation){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<indentation;i++)
            sb.append("  ");

        sb.append("[\"" + this.getFullNameWithTypes());
        if(this.hasReturn()){
            sb.append("</br>{"+ this.getReturnField().getValue().replace("\"", "") +"}\"]\n");
        } else {
            sb.append("\"]\n");
        }

        indentation++;

        for(NodeMethod nm: this.getChildrenClazz()){
            sb.append(nm.visualise(indentation));
        }

        for(LeafMethod lm: this.getCallee()){
            if(!lm.isInArrayList(this.getChildrenClazz())){
                sb.append(lm.visualise(indentation));
            }
        }
        return sb.toString();
    }
}
