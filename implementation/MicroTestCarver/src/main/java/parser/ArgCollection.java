package parser;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ArgCollection extends HashSet<Arg>{
    private int findMaxIndex(){
        Iterator<Arg> it = this.iterator();
        int max = -1;
        while (it.hasNext()) {
            Arg arg = it.next();
            if(arg == null)
                continue;
            if(arg.index > max)
                max = arg.index;
        }
        return max;
    }

    public Collection<Arg> findUniqueBasedIndex(){
        HashMap<Integer, Arg> hashMap= new HashMap<Integer, Arg>();
        int expectedItems = findMaxIndex() + 1;
        for (Arg arg : this) {
            if(arg==null)
                continue;

            hashMap.put(arg.index, arg);
            if (hashMap.size() == expectedItems)
                break;
        }
        return (hashMap.values());
    }
}
