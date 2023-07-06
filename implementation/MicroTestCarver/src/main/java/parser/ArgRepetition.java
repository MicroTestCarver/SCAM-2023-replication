package parser;

import java.util.Objects;

public class ArgRepetition implements Comparable<ArgRepetition> {

    private Arg arg;
    private int repetition;

    ArgRepetition(Arg arg){
        this.arg = arg;
        this.repetition = 1;
    }

    public int increaseRepetition(){
        return this.repetition++;
    }

    public Arg getArg() {
        return arg;
    }

    public int getRepetition() {
        return repetition;
    }

    @Override
    public int compareTo(ArgRepetition other) {
        return - Integer.compare(repetition, other.repetition);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArgRepetition argObj = (ArgRepetition) obj;
        return Objects.equals(arg, argObj.arg);
    }
}
