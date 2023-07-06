# MicroTestCarver

**_MicroTestCarver_** is composed three phases ```Instrumentation```, ```Parsing```, and ```Test Generation```.
To make it easier to run these, we developed CLI. There are two commands: ```trace``` and ```parser``` (parse and generate tests).

```
  src/main/java/
  |--- trace/               The implementation of Trace phase.
  |--- parser/              The implementation of Parse phase.
  |--- test_generator/      The implementation of Test Generation phase.
  |--- commands/            CLI commands (parser and trace).
```

### Instrumentation
#### prerequisite
In order to trace the application, it needs to use the modified btrace. If you are using _SDKMAN_, do these steps:

```shell
cd btrace
source config_build.sh
./gradlew :btrace-dist:build
cp btrace-dist/build/resources/main/<Btrace-Version> ~/.sdkman/candidates/btrace/<Btrace-Version>
sdk default btrace <Btrace-Version>
```

#### Trace the desired application
```shell
trace -p <port> -cp <package-pattern> -m <method-pattern> 
```

Optional subcommands:   
-l: the log will be displayed on Shell instead of writing on a file.

If you want to use ```XML``` serialization type (default is JSON), you need to set ```SERIALIZE_TYPE = "xml"``` in callTrace.java. Also, if you want to change the trace script, it is possible by changing this file.  
In addition, it is possible to use ```execution-trace.sh``` instead of the trace command.

```
src/main
    |--- java/
    |    |--- trace/
    |    |    |--- CallTrace.java
    |--- resources
    |    |--- trace-execution.sh
```

### Parsing and Test Generation
In order to parse the trace information and generate tests, you can run this command:
```shell
parse -f <output-trace-log-file> -i <app-directory> -p <pool-directory> -t <serialization-type> parse
```

Here is the structure of these two phases:

```
src/main
    |--- java/
    |    |--- parser/
    |    |    |--- (Arg, ArgRepetition, Clazz, LeafMethod, NodeMethod)  fundamental classes that represent the information that gathered from the trace informations.
    |    |    |--- Parser.java             	the main class to parse the trace information. 
    |    |--- test_generator/
    |    |    |--- VelocityRunner.java          run the velocity templates and generate tests. 
    |    |    |--- CombineClazz.java            combine the dynamic class with static class.
    |    |    |--- TestMethodGenerator.java     generate the body of a test.
    |    |    |--- AssertionGenerator.java      generate an assertion
    |    |    |--- unmarshaller/                reproduce (unmarshal) the objects.
    |--- resources
    |    |--- vtemplates/                       the velocity templates.     
```