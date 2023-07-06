import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.Factory;
import test_generator.unmarshaller.UnmarshalledVariable;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GenerationTests {

    private CtType root;
    @BeforeEach
    public void setUp() throws Exception {
        final Launcher launcher = new Launcher();
        System.out.println(System.getProperty("user.dir"));
        launcher.addInputResource(System.getProperty("user.dir") + "/src/test/java");
        launcher.buildModel();
        launcher.getEnvironment().setComplianceLevel(11);
        Factory spoon = launcher.getFactory();
        CtModel model = spoon.getModel();
        root = spoon.Type().get(ATest.class.getName());
    }

    @Test
    public void shouldUnmarshallConstructor() throws IllegalAccessException {
        ATest aTest = new ATest("Clouds", "few clouds");
//        ATest aTest = new ATest("Clouds", "few clouds");
        Optional optional = Optional.of(aTest);
        System.out.println(aTest);
        UnmarshalledVariable uv = new UnmarshalledVariable(optional, root);
        assertThat(uv.getInlineOrVariable(), is("Optional.of(new ATest(\"Clouds\", \"few clouds\"))"));
    }

    @Test
    public void shouldUnmarshallEmptyArrayList() throws IllegalAccessException {
        ArrayList<ATest> aTests = new ArrayList<>();
        UnmarshalledVariable uv = new UnmarshalledVariable(aTests, root);
        assertThat(uv.getInlineOrVariable(), is("new ArrayList<>()"));
    }

    @Test
    public void shouldUnmarshallArrayList() throws IllegalAccessException {
        ArrayList<ATest> aTests = new ArrayList<>();
        ATest aTest = new ATest("Clouds", "few clouds");
        aTests.add(aTest);
//        ATest aTest = new ATest("Clouds", "few clouds");
        StringBuilder buffer = new StringBuilder();
        HashSet variables = new HashSet<>();
        System.out.println(aTest);
        UnmarshalledVariable uv = new UnmarshalledVariable(aTests, root);
        String unmarshalledString = uv.getInlineOrVariable(buffer, variables);
        System.out.println("unmarshal: " + unmarshalledString);
        assertThat(buffer.toString(), is("ArrayList<ATest> aTests = new ArrayList<>();\naTests.add(new ATest(\"Clouds\", \"few clouds\"));\n"));
    }

    @Test
    public void shouldUnmarshallMap() throws IllegalAccessException {
        HashMap<ATest, BTest> map = new HashMap<>();
        ATest aTest = new ATest("Clouds", "few clouds");
        BTest bTest = new BTest("Rainy", "heavy rain");
        map.put(aTest, bTest);
        System.out.println(map);
        StringBuilder buffer = new StringBuilder();
        HashSet variables = new HashSet<>();
        UnmarshalledVariable uv = new UnmarshalledVariable(map, root);
        String unmarshalledString = uv.getInlineOrVariable(buffer, variables);
        System.out.println("unmarshal: " + unmarshalledString);
        System.out.println("buffer: " + buffer);

        StringBuilder expectedBuffer = new StringBuilder();
        expectedBuffer.append("HashMap<ATest, BTest> aTestMappedBTest = new HashMap<>();\n");
        expectedBuffer.append("aTestMappedBTest.put(new ATest(\"Clouds\", \"few clouds\"), new BTest(\"Rainy\", \"heavy rain\"));\n");

        assertThat(unmarshalledString, is("aTestMappedBTest"));
        assertThat(buffer.toString(), is(expectedBuffer.toString()));
    }


    public static class ATest {
        private List<BTest> bTest;

        ATest() {
        }

        ATest(String a, String b) {
            this.bTest = Collections.singletonList(new BTest(a, b));
        }

//        ATest(BTest btest) {
//            this.bTest = btest;
//        }

        @Override
        public String toString() {
            return "ATest{" + "bTest=" + bTest + '}';
        }
    }

    public static class BTest {
        public String a;
        public String b;

        BTest(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "BTest{" + "a='" + a + '\'' + ", b='" + b + '\'' + '}';
        }
    }
}
