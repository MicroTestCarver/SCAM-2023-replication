package trace_samples.example;

public abstract class HelloWorld extends HelloWorldBase {
    protected int field = 0;

    public static void main(String[] args) throws Exception {
        System.out.println("ready when you are ...");
        System.in.read();

        callA();
    }

    private static void callA() {
        HelloWorld instance = new HelloWorldExt();
        long x = System.nanoTime();
        instance.callA("hello", 13);
        System.out.println("dur = " + (System.nanoTime() - x));
    }

    private void callA(String a, int b) {
        field++;
        callB(callC(a, b));
        field--;
    }

    private void callB(String s) {
        field++;
        System.out.println("You want " + s);
        field--;
    }

    protected abstract String callC(String a, int b);
}

final class HelloWorldExt extends HelloWorld {
    @Override
    protected String callC(String a, int b) {
        try {
            field++;
            String s = a + "-" + b;
            for (int i = 0; i < 100; i++) {
                s = callD(s);
            }
            return s;
        } finally {
            field--;
        }
    }
}

abstract class HelloWorldBase {
    protected final String callD(String s) {
        return "# " + s;
    }
}