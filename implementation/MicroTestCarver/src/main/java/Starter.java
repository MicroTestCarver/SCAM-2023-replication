import commands.ParserCommand;
import commands.TraceCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "carving", subcommands = {
        TraceCommand.class, ParserCommand.class
})
public class Starter implements Runnable  {

    public static void main(String[] args) throws Exception {
        CommandLine.run(new Starter(), args);
    }

    @Override
    public void run() {
        System.out.println("Run carving --help");
    }
}
