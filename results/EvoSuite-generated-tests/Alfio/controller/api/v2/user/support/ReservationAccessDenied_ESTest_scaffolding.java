/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Tue Jan 10 08:55:01 GMT 2023
 */

package alfio.controller.api.v2.user.support;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class ReservationAccessDenied_ESTest_scaffolding {

  @org.junit.Rule
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) System.getProperties().clone();

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "alfio.controller.api.v2.user.support.ReservationAccessDenied"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    System.setProperties((java.util.Properties) defaultProperties.clone());
  } 

  @Before
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    System.setProperties((java.util.Properties) defaultProperties.clone());
    System.setProperty("user.dir", "/Users/Software Development/Web Development/Clonned Projects/alf.io-2.0.4");
    System.setProperty("java.io.tmpdir", "/var/folders/yc/kykqf2wd0tgdw_85fbvlyj680000gn/T/");
    System.setProperty("strategy", "MOSuite");
    System.setProperty("sun.java.launcher", "SUN_STANDARD");
    System.setProperty("sun.management.compiler", "HotSpot 64-Bit Tiered Compilers");
    System.setProperty("test_naming_strategy", "coverage");
    System.setProperty("process_communication_port", "14860");
    System.setProperty("user.name", "amir");
    System.setProperty("log4j.configuration", "SUT.log4j.properties");
    System.setProperty("user.language", "en");
    System.setProperty("sun.boot.library.path", "/Users/.sdkman/candidates/java/11.0.15-tem/lib");
    System.setProperty("java.vm.compressedOopsMode", "Zero based");
    System.setProperty("user.timezone", "Europe/Amsterdam");
    System.setProperty("sun.arch.data.model", "64");
    System.setProperty("http.nonProxyHosts", "local|*.local|169.254/16|*.169.254/16");
    System.setProperty("sun.cpu.isalist", "");
    System.setProperty("sun.jnu.encoding", "UTF-8");
    System.setProperty("num_parallel_clients", "1");
    System.setProperty("PROJECT_PREFIX", "");
    System.setProperty("user.country", "NL");
    System.setProperty("inheritance_file", "/var/folders/yc/kykqf2wd0tgdw_85fbvlyj680000gn/T/ES_inheritancetree4864283005723658169.xml.gz");
    System.setProperty("logback.configurationFile", "logback-evosuite.xml");
    System.setProperty("sun.io.unicode.encoding", "UnicodeBig");
    System.setProperty("socksNonProxyHosts", "local|*.local|169.254/16|*.169.254/16");
    System.setProperty("ftp.nonProxyHosts", "local|*.local|169.254/16|*.169.254/16");
    System.setProperty("user.home", "/Users/amir");
    System.setProperty("java.version.date", "2022-04-19");
    System.setProperty("gopherProxySet", "false");
    System.setProperty("master_log_port", "50229");
    System.setProperty("sun.java.command", "org.evosuite.ClientProcess Client-0");
    System.setProperty("jdk.debug", "release");
    System.setProperty("sun.cpu.endian", "little");
    System.setProperty("sun.os.patch.level", "unknown");
    System.setProperty("java.awt.headless", "true");
    System.setProperty("java.vendor.url.bug", "https://github.com/adoptium/adoptium-support/issues");
    System.setProperty("java.rmi.server.hostname", "127.0.0.1");
    System.setProperty("CP_file_path", "/var/folders/yc/kykqf2wd0tgdw_85fbvlyj680000gn/T/EvoSuite_classpathFile13299459382964050861.txt");
    System.setProperty("inline", "true");
    System.setProperty("TARGET_CLASS", "alfio.controller.api.v2.user.support.ReservationAccessDenied");
    System.setProperty("selection_function", "RANK_CROWD_DISTANCE_TOURNAMENT");
    System.setProperty("evosuite.log.appender", "CLIENT");
    System.setProperty("search_budget", "30");
    System.setProperty("file.encoding", "US-ASCII");
    System.setProperty("algorithm", "DYNAMOSA");
    System.setProperty("java.vendor.version", "Temurin-11.0.15+10");
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(ReservationAccessDenied_ESTest_scaffolding.class.getClassLoader() ,
      "alfio.controller.api.v2.user.support.ReservationAccessDenied"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(ReservationAccessDenied_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "alfio.controller.api.v2.user.support.ReservationAccessDenied",
      "org.springframework.transaction.annotation.Propagation",
      "org.springframework.transaction.annotation.Isolation",
      "com.fasterxml.jackson.databind.annotation.JsonSerialize$Inclusion",
      "com.fasterxml.jackson.databind.annotation.JsonSerialize$Typing",
      "com.fasterxml.jackson.annotation.JsonCreator$Mode",
      "org.springframework.context.annotation.ScopedProxyMode",
      "org.springframework.context.annotation.FilterType",
      "org.checkerframework.framework.qual.TypeUseLocation",
      "org.checkerframework.checker.units.qual.Prefix",
      "org.checkerframework.framework.qual.LiteralKind",
      "org.checkerframework.framework.qual.TypeKind",
      "org.springframework.web.bind.annotation.RequestMethod",
      "org.springframework.boot.autoconfigure.condition.SearchStrategy",
      "com.zaxxer.hikari.HikariConfig",
      "com.zaxxer.hikari.HikariDataSource",
      "org.eclipse.jetty.http.BadMessageException",
      "org.eclipse.jetty.util.log.Log$1",
      "org.eclipse.jetty.util.Loader",
      "org.eclipse.jetty.util.log.Log",
      "org.eclipse.jetty.util.log.AbstractLogger",
      "org.eclipse.jetty.util.log.Slf4jLog",
      "org.eclipse.jetty.util.log.JettyAwareLogger",
      "org.eclipse.jetty.util.Uptime$DefaultImpl",
      "org.eclipse.jetty.util.Uptime",
      "org.eclipse.jetty.http.HttpField",
      "org.eclipse.jetty.http.Http1FieldPreEncoder",
      "org.eclipse.jetty.util.AbstractTrie",
      "org.eclipse.jetty.util.ArrayTrie",
      "org.eclipse.jetty.util.MathUtils",
      "org.eclipse.jetty.util.StringUtil",
      "org.eclipse.jetty.http.HttpVersion",
      "org.eclipse.jetty.http.PreEncodedHttpField$1",
      "org.eclipse.jetty.http.PreEncodedHttpField",
      "org.eclipse.jetty.http.HttpHeader",
      "org.eclipse.jetty.http.DateGenerator$1",
      "org.eclipse.jetty.http.DateGenerator",
      "org.eclipse.jetty.server.Response$EncodingFrom",
      "org.eclipse.jetty.server.Response"
    );
  }
}
