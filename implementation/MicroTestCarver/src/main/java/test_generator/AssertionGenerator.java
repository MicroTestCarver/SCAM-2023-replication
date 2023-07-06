package test_generator;

import parser.NodeMethod;

import java.util.Set;

public class AssertionGenerator {

    CombineClazz clazz;
    String actualVariableName;
    String expectedResult;

    AssertionGenerator(CombineClazz clazz) {
        this.clazz = clazz;
    }

    public String assertion(NodeMethod nodeMethod, Set<String> variableNames){
        this.actualVariableName = nodeMethod.methodName;

        StringBuilder assertionBuf = new StringBuilder();
        StringBuilder populationBuf = new StringBuilder();
        this.expectedResult = clazz.revealObject(nodeMethod.getReturnField(), populationBuf, 0, variableNames);

        if(!populationBuf.toString().isEmpty()){
            String[] lines = populationBuf.toString().split("\\n");
            for(String s: lines){
                assertionBuf.append("\t\t" + s);
                assertionBuf.append("\n");
            }
            assertionBuf.append("\n");
        }
        assertionBuf.append("\t\t" + this);

        return assertionBuf.toString();
    }

    @Override
    public String toString() {
        return "assertThat(" + actualVariableName + ", is(" + expectedResult + "));";
    }
}
