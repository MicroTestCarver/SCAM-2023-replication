/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Sat Jan 14 17:25:59 GMT 2023
 */

package alfio.model.subscription;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class SubscriptionUsageExceededForEvent_ESTest_scaffolding {

  @org.junit.Rule
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) System.getProperties().clone();

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "alfio.model.subscription.SubscriptionUsageExceededForEvent"; 
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
    System.setProperty("strategy", "MOSuite");
    System.setProperty("sun.java.launcher", "SUN_STANDARD");
    System.setProperty("sun.management.compiler", "HotSpot 64-Bit Tiered Compilers");
    System.setProperty("test_naming_strategy", "coverage");
    System.setProperty("process_communication_port", "11143");
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
    System.setProperty("inheritance_file", "/var/folders/yc/kykqf2wd0tgdw_85fbvlyj680000gn/T/ES_inheritancetree300423776396367549.xml.gz");
    System.setProperty("logback.configurationFile", "logback-evosuite.xml");
    System.setProperty("sun.io.unicode.encoding", "UnicodeBig");
    System.setProperty("socksNonProxyHosts", "local|*.local|169.254/16|*.169.254/16");
    System.setProperty("ftp.nonProxyHosts", "local|*.local|169.254/16|*.169.254/16");
    System.setProperty("user.home", "/Users/amir");
    System.setProperty("java.version.date", "2022-04-19");
    System.setProperty("gopherProxySet", "false");
    System.setProperty("master_log_port", "60119");
    System.setProperty("sun.java.command", "org.evosuite.ClientProcess Client-0");
    System.setProperty("jdk.debug", "release");
    System.setProperty("sun.cpu.endian", "little");
    System.setProperty("sun.os.patch.level", "unknown");
    System.setProperty("java.awt.headless", "true");
    System.setProperty("java.io.tmpdir", "/var/folders/yc/kykqf2wd0tgdw_85fbvlyj680000gn/T/");
    System.setProperty("java.vendor.url.bug", "https://github.com/adoptium/adoptium-support/issues");
    System.setProperty("java.rmi.server.hostname", "127.0.0.1");
    System.setProperty("CP_file_path", "/var/folders/yc/kykqf2wd0tgdw_85fbvlyj680000gn/T/EvoSuite_classpathFile17492324769604298147.txt");
    System.setProperty("inline", "true");
    System.setProperty("TARGET_CLASS", "alfio.model.subscription.SubscriptionUsageExceededForEvent");
    System.setProperty("selection_function", "RANK_CROWD_DISTANCE_TOURNAMENT");
    System.setProperty("evosuite.log.appender", "CLIENT");
    System.setProperty("file.encoding", "US-ASCII");
    System.setProperty("algorithm", "DYNAMOSA");
    System.setProperty("java.vendor.version", "Temurin-11.0.15+10");
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(SubscriptionUsageExceededForEvent_ESTest_scaffolding.class.getClassLoader() ,
      "alfio.model.subscription.SubscriptionUsageExceededForEvent"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(SubscriptionUsageExceededForEvent_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "alfio.model.subscription.SubscriptionUsageExceededForEvent",
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
      "org.postgresql.util.HostSpec",
      "org.postgresql.core.PGStream",
      "org.eclipse.jetty.util.log.Log$1",
      "org.eclipse.jetty.util.Loader",
      "org.eclipse.jetty.util.log.Log",
      "org.eclipse.jetty.util.log.AbstractLogger",
      "org.eclipse.jetty.util.log.Slf4jLog",
      "org.eclipse.jetty.util.log.JettyAwareLogger",
      "org.eclipse.jetty.util.Uptime$DefaultImpl",
      "org.eclipse.jetty.util.Uptime",
      "org.eclipse.jetty.util.Jetty",
      "org.eclipse.jetty.server.HttpConfiguration",
      "org.eclipse.jetty.util.AbstractTrie",
      "org.eclipse.jetty.util.TreeTrie",
      "org.eclipse.jetty.util.BufferUtil",
      "org.eclipse.jetty.util.ArrayTrie",
      "org.eclipse.jetty.util.MathUtils",
      "org.eclipse.jetty.http.HttpScheme",
      "org.eclipse.jetty.http.CookieCompliance",
      "org.eclipse.jetty.server.MultiPartFormDataCompliance",
      "org.eclipse.jetty.http.HttpMethod$Type",
      "org.eclipse.jetty.util.StringUtil",
      "org.eclipse.jetty.util.ArrayTernaryTrie",
      "org.eclipse.jetty.http.HttpMethod",
      "org.eclipse.jetty.util.component.AbstractLifeCycle",
      "org.eclipse.jetty.util.component.ContainerLifeCycle",
      "org.eclipse.jetty.server.handler.AbstractHandler",
      "org.eclipse.jetty.server.handler.AbstractHandlerContainer",
      "org.eclipse.jetty.server.handler.HandlerWrapper",
      "org.eclipse.jetty.server.Server",
      "org.eclipse.jetty.util.component.AttributeContainerMap",
      "org.eclipse.jetty.util.thread.Locker",
      "org.eclipse.jetty.util.thread.Locker$Lock",
      "org.eclipse.jetty.util.thread.TryExecutor$1",
      "org.eclipse.jetty.util.thread.TryExecutor",
      "org.eclipse.jetty.util.thread.QueuedThreadPool",
      "org.eclipse.jetty.util.AtomicBiInteger",
      "org.eclipse.jetty.util.thread.QueuedThreadPool$Runner",
      "org.eclipse.jetty.util.MemoryUtils$1",
      "org.eclipse.jetty.util.MemoryUtils",
      "org.eclipse.jetty.util.BlockingArrayQueue",
      "org.eclipse.jetty.util.thread.ThreadPoolBudget$1",
      "org.eclipse.jetty.util.thread.ThreadPoolBudget",
      "org.eclipse.jetty.util.component.ContainerLifeCycle$Managed",
      "org.eclipse.jetty.util.component.ContainerLifeCycle$Bean",
      "org.eclipse.jetty.util.component.ContainerLifeCycle$1",
      "org.eclipse.jetty.server.AbstractConnectionFactory",
      "org.eclipse.jetty.server.DetectorConnectionFactory",
      "org.eclipse.jetty.server.ProxyConnectionFactory",
      "org.eclipse.jetty.server.ProxyConnectionFactory$ProxyV1ConnectionFactory",
      "org.eclipse.jetty.server.ProxyConnectionFactory$ProxyV2ConnectionFactory",
      "org.eclipse.jetty.server.AbstractConnector",
      "org.eclipse.jetty.server.AbstractNetworkConnector",
      "org.eclipse.jetty.server.ServerConnector",
      "org.eclipse.jetty.server.NetworkTrafficServerConnector",
      "org.eclipse.jetty.util.component.Graceful$Shutdown",
      "org.eclipse.jetty.server.HttpChannel$1",
      "org.eclipse.jetty.server.HttpChannel",
      "org.eclipse.jetty.util.thread.ScheduledExecutorScheduler",
      "org.eclipse.jetty.io.AbstractByteBufferPool",
      "org.eclipse.jetty.io.ArrayByteBufferPool",
      "org.eclipse.jetty.io.ByteBufferPool$Bucket",
      "org.eclipse.jetty.server.AbstractConnector$1",
      "org.eclipse.jetty.util.ProcessorUtils",
      "org.eclipse.jetty.io.SelectorManager",
      "org.eclipse.jetty.server.ServerConnector$ServerConnectorManager",
      "org.eclipse.jetty.io.IdleTimeout",
      "org.eclipse.jetty.io.AbstractEndPoint",
      "org.eclipse.jetty.io.ByteArrayEndPoint",
      "org.eclipse.jetty.io.AbstractEndPoint$State",
      "org.eclipse.jetty.io.FillInterest",
      "org.eclipse.jetty.io.AbstractEndPoint$1",
      "org.eclipse.jetty.io.WriteFlusher$StateType",
      "org.eclipse.jetty.io.WriteFlusher$State",
      "org.eclipse.jetty.io.WriteFlusher$IdleState",
      "org.eclipse.jetty.io.WriteFlusher$WritingState",
      "org.eclipse.jetty.io.WriteFlusher$CompletingState",
      "org.eclipse.jetty.io.WriteFlusher",
      "org.eclipse.jetty.io.AbstractEndPoint$2",
      "org.eclipse.jetty.io.ByteArrayEndPoint$1",
      "org.eclipse.jetty.io.AbstractEndPoint$3",
      "org.eclipse.jetty.io.AbstractConnection",
      "org.eclipse.jetty.http.HttpField",
      "org.eclipse.jetty.http.Http1FieldPreEncoder",
      "org.eclipse.jetty.http.HttpVersion",
      "org.eclipse.jetty.http.PreEncodedHttpField$1",
      "org.eclipse.jetty.http.PreEncodedHttpField",
      "org.eclipse.jetty.http.HttpHeader",
      "org.eclipse.jetty.http.HttpHeaderValue",
      "org.eclipse.jetty.server.HttpConnection",
      "org.eclipse.jetty.util.thread.Invocable",
      "org.eclipse.jetty.util.Callback$1",
      "org.eclipse.jetty.util.Callback",
      "org.eclipse.jetty.io.AbstractConnection$ReadCallback",
      "org.eclipse.jetty.server.HttpConnection$BlockingReadCallback",
      "org.eclipse.jetty.server.HttpConnection$AsyncReadCallback",
      "org.eclipse.jetty.util.IteratingCallback",
      "org.eclipse.jetty.server.HttpConnection$SendCallback",
      "org.eclipse.jetty.util.IteratingCallback$State",
      "org.eclipse.jetty.http.MetaData",
      "org.eclipse.jetty.http.MetaData$Response",
      "org.eclipse.jetty.http.HttpFields",
      "org.eclipse.jetty.http.HttpGenerator$1",
      "org.eclipse.jetty.http.HttpStatus$Code",
      "org.eclipse.jetty.http.HttpStatus",
      "org.eclipse.jetty.http.HttpGenerator$PreparedResponse",
      "org.eclipse.jetty.http.HttpGenerator",
      "org.eclipse.jetty.http.HttpGenerator$State",
      "org.eclipse.jetty.http.HttpTokens$EndOfContent",
      "org.eclipse.jetty.server.HttpChannelOverHttp",
      "org.eclipse.jetty.server.HttpChannelState",
      "org.eclipse.jetty.server.HttpChannelState$State",
      "org.eclipse.jetty.server.HttpChannelState$RequestState",
      "org.eclipse.jetty.server.HttpChannelState$OutputState",
      "org.eclipse.jetty.server.HttpChannelState$InputState",
      "org.eclipse.jetty.util.MultiMap",
      "org.eclipse.jetty.server.Request",
      "org.eclipse.jetty.server.HttpInput$Content",
      "org.eclipse.jetty.server.HttpInput$SentinelContent",
      "org.eclipse.jetty.server.HttpInput$EofContent",
      "org.eclipse.jetty.server.HttpInput$State",
      "org.eclipse.jetty.server.HttpInput$1",
      "org.eclipse.jetty.server.HttpInput$2",
      "org.eclipse.jetty.server.HttpInput$EOFState",
      "org.eclipse.jetty.server.HttpInput$3",
      "org.eclipse.jetty.server.HttpInput$4",
      "org.eclipse.jetty.server.HttpInput$5",
      "org.eclipse.jetty.server.HttpInput",
      "org.eclipse.jetty.server.HttpInputOverHTTP",
      "org.eclipse.jetty.http.DateGenerator$1",
      "org.eclipse.jetty.http.DateGenerator",
      "org.eclipse.jetty.server.Response$EncodingFrom",
      "org.eclipse.jetty.server.Response",
      "org.eclipse.jetty.server.HttpOutput",
      "org.eclipse.jetty.server.HttpOutput$ApiState",
      "org.eclipse.jetty.server.HttpOutput$State",
      "org.eclipse.jetty.util.ConstantThrowable",
      "org.eclipse.jetty.util.SharedBlockingCallback",
      "org.eclipse.jetty.server.HttpOutput$WriteBlocker",
      "org.eclipse.jetty.util.SharedBlockingCallback$Blocker",
      "org.eclipse.jetty.server.Response$OutputType",
      "org.eclipse.jetty.http.MetaData$Request",
      "org.eclipse.jetty.http.HttpURI",
      "org.eclipse.jetty.util.Trie$1",
      "org.eclipse.jetty.http.HttpParser$State",
      "org.eclipse.jetty.http.HttpParser",
      "org.eclipse.jetty.util.Utf8Appendable",
      "org.eclipse.jetty.util.Utf8StringBuilder",
      "org.eclipse.jetty.http.HttpParser$FieldState",
      "org.eclipse.jetty.http.MimeTypes$Type",
      "org.eclipse.jetty.http.MimeTypes",
      "org.eclipse.jetty.server.HttpChannelState$3",
      "org.eclipse.jetty.server.ResponseWriter",
      "org.eclipse.jetty.server.HttpWriter",
      "org.eclipse.jetty.server.Iso88591HttpWriter",
      "org.eclipse.jetty.util.ByteArrayOutputStream2",
      "org.postgresql.jdbc.PgSQLXML",
      "org.postgresql.util.SharedTimer",
      "org.postgresql.Driver",
      "org.postgresql.ds.common.BaseDataSource",
      "org.postgresql.ds.PGSimpleDataSource",
      "org.postgresql.PGProperty"
    );
  }
}
