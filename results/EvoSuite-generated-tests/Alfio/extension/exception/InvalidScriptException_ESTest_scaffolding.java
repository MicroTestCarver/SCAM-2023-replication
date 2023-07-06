/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Mon Jan 09 23:16:01 GMT 2023
 */

package alfio.extension.exception;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class InvalidScriptException_ESTest_scaffolding {

  @org.junit.Rule
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) System.getProperties().clone();

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "alfio.extension.exception.InvalidScriptException"; 
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
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(InvalidScriptException_ESTest_scaffolding.class.getClassLoader() ,
      "alfio.extension.exception.AlfioScriptingException",
      "alfio.extension.exception.InvalidScriptException"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(InvalidScriptException_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "alfio.extension.exception.AlfioScriptingException",
      "alfio.extension.exception.InvalidScriptException",
      "org.springframework.transaction.annotation.Isolation",
      "org.springframework.transaction.annotation.Propagation",
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
      "org.postgresql.util.SharedTimer",
      "org.postgresql.Driver",
      "org.postgresql.ds.common.BaseDataSource",
      "org.postgresql.ds.PGConnectionPoolDataSource",
      "org.eclipse.jetty.http.BadMessageException",
      "org.postgresql.util.HostSpec",
      "org.postgresql.jdbc.PgConnection",
      "org.postgresql.PGProperty",
      "org.postgresql.jdbc.PgConnection$ReadOnlyBehavior",
      "org.postgresql.core.ConnectionFactory",
      "org.postgresql.core.v3.ConnectionFactoryImpl",
      "org.postgresql.jdbc.SslMode",
      "org.postgresql.jdbc.GSSEncMode",
      "org.postgresql.util.internal.Nullness",
      "org.postgresql.hostchooser.HostRequirement",
      "org.postgresql.core.SocketFactoryFactory",
      "org.postgresql.hostchooser.HostChooserFactory",
      "org.postgresql.hostchooser.MultiHostChooser",
      "org.postgresql.hostchooser.GlobalHostStatusTracker",
      "org.postgresql.hostchooser.MultiHostChooser$1",
      "org.postgresql.hostchooser.CandidateHost",
      "org.postgresql.core.PGStream",
      "org.springframework.validation.BindingResult",
      "org.springframework.validation.BindException",
      "org.springframework.util.Assert",
      "org.springframework.validation.AbstractErrors",
      "org.springframework.validation.AbstractBindingResult",
      "org.springframework.validation.AbstractPropertyBindingResult",
      "org.springframework.validation.BeanPropertyBindingResult",
      "org.springframework.validation.DefaultMessageCodesResolver$Format",
      "org.springframework.validation.DefaultMessageCodesResolver",
      "org.postgresql.ds.PGSimpleDataSource"
    );
  }
}