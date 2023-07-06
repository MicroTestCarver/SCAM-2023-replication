# SCAM 2023 - MicroTestCarver - Replication Package

This replication package contains the implementation, and evaluation results used in the study "Generating Understandable Unit Tests through End-to-End Test Scenario Carving", which is submitted for **[SCAM 2023](http://www.ieee-scam.org/2023/)**. The package is intended to allow other researchers to replicate the study's results and methods.

## Implementation
The implementation of _MicroTestCarver_ and _Modified-BTrace_ that are used in the study is included in the ```implementation``` folder.
They are written in ```java```.

**_MicroTestCarver_** is composed three phases ```Instrumentation```, ```Parsing```, and ```Test Generation```.
To make it easier to run these, we developed CLI. There are two commands: ```trace``` and ```parser``` (parse and generate tests).


```
implementation
    .
    |--- MicroTestCarver/             	The implementation of MicroTestCarver framework.
         |--- src/main/java/
         |    |--- trace/               The implementation of Trace phase.
         |    |--- parser/              The implementation of Parse phase.
         |    |--- test_generator/      The implementation of Test Generation phase.
         |    |--- commands/            CLI commands (parser and trace).
    |--- Modified-BTrace/             	As an instrumentation tool, we developed some additional functionality for BTrace.
```

### Instrumentation
#### prerequisite
In order to trace the application, it needs to use the modified btrace. If you are using _SDKMAN_, do these steps:

```shell
cd implementation/Modified-Btrace
source config_build.sh
./gradlew :btrace-dist:build
cp btrace-dist/build/resources/main/<Btrace-Version> ~/.sdkman/candidates/btrace/<Btrace-Version>
sdk default btrace <Btrace-Version>
```

#### Trace the desired application
```shell
trace -p <port> -cp <package-pattern> -m <method-pattern> -ti <traceignore-file> -tt <tracefile>
```

Optional subcommands:   
-l: the log will be displayed on Shell instead of writing on a file.
-ti: if you want to ignore specific classes, you can use traceignore file which accepts Wildcard Pattern Matching
-tt: if you want to use a specific trace file, instead of the default one

If you want to use ```XML``` serialization type (default is JSON), you need to set ```SERIALIZE_TYPE = "xml"``` in callTrace.java. Also, if you want to change the trace script, it is possible by changing this file.  
In addition, it is possible to use ```execution-trace.sh``` instead of the trace command.

```
MicroTestCarver/
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
Optional subcommands: 
-v: create call graphs visualization
-d: it allows duplication of test cases

Here is the structure of these two phases: 

```
MicroTestCarver/
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

## Evaluation

### Methodology
We gathered the projects from GitHub (200 projects) that have these criteria:
- The language of the project is Java. 
- It is a web application.
- The project is popular, active, and mature as measured in
terms of forks, stars, and commits.
- The project has a test suite.

The questionnaire questions can be found in the questionnaire folder.

You can find and reuse this from the following directory: 
````
methodology/
    .
    |--- projects-dataset-collection/            the implementation for collecting the projects.
    |   |--- selected_projects_sorted.csv        the results of the dataset, and that is ranked based on the score.
    |--- questionnaire                           the pdf of questionanaire questions
````

### Raw Data
We applied MicroTestCarver on three study subjects: Spring-Testing, Petclinic, LAB-Insurance, and Alfio.  
The trace information for each project can be found in the ```raw-trace-information``` folder.

### Recorded E2E Tests
We record E2E tests for each folder in the ```recorded-E2E-tests``` folder.

### Results
In our research questions, first, we consider feasibility. For RQ2 and RQ3, we compared the carved tests with the EvoSuite-generated tests and manually-written tests.
The results of RQ2 and RQ3 can be found in the ``survey-RQ2-RQ3`` folder. ``SCAM Survey Results`` is the results of the questionnaire. Comments pdfs showing the analysis of pariticapnts' comments in the criteria-based questions. Also, the chart of the criteria-based is located in ``SCAM-data-analysis``.

You can find the results in the following directories:
```
results/
    .
    |--- coverage/                          the coverage for each subject studies.
    |--- EvoSuite-generated-tests/          the tests that are generated by EvoSuite.
    |--- manually-written-tests/            the tests that are written manually.
    |--- MTC-generated-tests/               the tests that are generated by MicroTestCarver.
    |--- survey-RQ2-RQ3/                    the results and analysis of participants' opinions.
```
