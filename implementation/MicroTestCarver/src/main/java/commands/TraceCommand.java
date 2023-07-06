package commands;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Iterator;

import static picocli.CommandLine.Command;
import static picocli.CommandLine.Option;

@Command(name = "trace")
public class TraceCommand implements Runnable {
    @Option(names = {"-v", "--verbose"}, description = "print verbose output.")
    boolean verbose;

    @Option(names = {"-cp", "--package"}, description = "Class path, Required", required = true)
    String classPath;

    @Option(names = {"-p", "--port"}, description = "Port, Required", required = true)
    String port;

    @Option(names = {"-l", "--log"}, description = "The log that is displayed on Shell, Default: false")
    boolean log = false;

    @Option(names = {"-m", "--method"}, description = "Method Name, Default: *")
    String method = "^(?!lambda\\$*|getContentLanguages|getSrcPriceCts)(.*)";

    @Option(names = {"-ti", "--traceignore"}, description = "trace ignore file.")
    String traceIgnoreDirectory;

    @Option(names = {"-tt", "--tracetype"}, description = "trace type.")
    String traceType = "";


    @Override
    public void run() {
        try {
//            String traceClassPath = this.getClass().getClassLoader().getResource("trace/CallTrace.class").getPath();
//            System.out.println(traceClassPath);
            String directory = "./src/main/resources";
            String filename;
            if(traceType.isEmpty())
                filename = String.format("%s-%s.btrace", classPath, java.time.LocalDate.now());
            else
                filename = String.format("%s-%s-%s.btrace", classPath, java.time.LocalDate.now(), traceType);
            String traceScopeExcluded = "";
            String traceClassPath = "../java/trace/CallTrace" + traceType + ".java";
            if(traceIgnoreDirectory != null && !traceIgnoreDirectory.isEmpty()) {
                traceIgnoreDirectory = "/config/" + traceIgnoreDirectory;
                traceScopeExcluded = parseTraceIgnore();
                System.out.printf("traceScopeExcluded: " + traceScopeExcluded);
            }
            String classScope = "^(?!" + traceScopeExcluded + ")" + "(" + classPath + ")" + "(\\..*)";
            URL resource = getClass().getClassLoader().getResource("trace-execution.sh");
            String extPath = Paths.get(resource.toURI()).toFile().toString();
            System.out.println(extPath);
            String[] commandOptions = new String[]{extPath, port, classScope, method, String.valueOf(log), filename, traceClassPath};
            runProcess(commandOptions, directory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String parseTraceIgnore(){
        InputStream inputStream = this.getClass().getResourceAsStream(traceIgnoreDirectory);
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder traceScopeExcluded = new StringBuilder();
        Iterator<String> iterator = in.lines().iterator();
        while (iterator.hasNext()) {
            String line = iterator.next();
            traceScopeExcluded.append(line);
            if(iterator.hasNext())
                traceScopeExcluded.append("|");
        }
        return traceScopeExcluded.toString();
    }

    private void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
    }

    private void runProcess(String[] commands, String directory) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(commands);
        pb.directory(new File(directory));
        Process pro = pb.start();
        printLines(String.join(" ", commands) + " stdout:", pro.getInputStream());
        printLines(String.join(" ", commands) + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(String.join(" ", commands) + " exitValue() " + pro.exitValue());
    }
}