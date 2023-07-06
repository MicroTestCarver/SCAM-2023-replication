package commands;

import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.Factory;

@Command(name = "analysis")
public class AnalysisCommand {
    @Option(names = {"-c", "--class"}, description = "Class Name")
    String clazz;

    @Option(names = {"-i", "--input"}, description = "Source Directory")
    String input;

    @Command
    void elaborate(){
        final Launcher launcher = new Launcher();
        launcher.addInputResource(input);
        launcher.buildModel();
        launcher.getEnvironment().setComplianceLevel(11);
        Factory spoon = launcher.getFactory();
        CtModel model = spoon.getModel();
        CtType<?> mainClass = spoon.Type().get(clazz);
        System.out.println(mainClass.getAllMethods());

        for(CtPackage p : model.getAllPackages()) {
            System.out.println("package: " + p.getQualifiedName());
        }
        // list all classes of the model
        for(CtType<?> s : model.getAllTypes()) {
            System.out.println("class: " + s.getQualifiedName());
        }
    }
}
