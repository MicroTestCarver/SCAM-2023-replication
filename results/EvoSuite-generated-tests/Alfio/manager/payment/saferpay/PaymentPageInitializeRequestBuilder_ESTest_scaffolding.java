/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Tue Jan 10 05:32:54 GMT 2023
 */

package alfio.manager.payment.saferpay;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class PaymentPageInitializeRequestBuilder_ESTest_scaffolding {

  @org.junit.Rule
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) System.getProperties().clone();

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "alfio.manager.payment.saferpay.PaymentPageInitializeRequestBuilder"; 
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
    System.setProperty("sun.boot.library.path", "/Users/.sdkman/candidates/java/11.0.15-tem/lib");
    System.setProperty("gopherProxySet", "false");
    System.setProperty("search_budget", "30");
    System.setProperty("sun.os.patch.level", "unknown");
    System.setProperty("user.country", "NL");
    System.setProperty("sun.java.launcher", "SUN_STANDARD");
    System.setProperty("user.dir", "/Users/Software Development/Web Development/Clonned Projects/alf.io-2.0.4");
    System.setProperty("java.vm.compressedOopsMode", "Zero based");
    System.setProperty("java.io.tmpdir", "/var/folders/yc/kykqf2wd0tgdw_85fbvlyj680000gn/T/");
    System.setProperty("inline", "true");
    System.setProperty("master_log_port", "65445");
    System.setProperty("log4j.configuration", "SUT.log4j.properties");
    System.setProperty("sun.jnu.encoding", "UTF-8");
    System.setProperty("selection_function", "RANK_CROWD_DISTANCE_TOURNAMENT");
    System.setProperty("jdk.debug", "release");
    System.setProperty("sun.management.compiler", "HotSpot 64-Bit Tiered Compilers");
    System.setProperty("user.home", "/Users/amir");
    System.setProperty("user.timezone", "Europe/Amsterdam");
    System.setProperty("file.encoding", "US-ASCII");
    System.setProperty("strategy", "MOSuite");
    System.setProperty("CP_file_path", "/var/folders/yc/kykqf2wd0tgdw_85fbvlyj680000gn/T/EvoSuite_classpathFile16631566359684734974.txt");
    System.setProperty("user.name", "amir");
    System.setProperty("num_parallel_clients", "1");
    System.setProperty("PROJECT_PREFIX", "");
    System.setProperty("algorithm", "DYNAMOSA");
    System.setProperty("sun.arch.data.model", "64");
    System.setProperty("sun.java.command", "org.evosuite.ClientProcess Client-0");
    System.setProperty("user.language", "en");
    System.setProperty("process_communication_port", "6271");
    System.setProperty("logback.configurationFile", "logback-evosuite.xml");
    System.setProperty("java.awt.headless", "true");
    System.setProperty("java.version.date", "2022-04-19");
    System.setProperty("java.vendor.url.bug", "https://github.com/adoptium/adoptium-support/issues");
    System.setProperty("sun.io.unicode.encoding", "UnicodeBig");
    System.setProperty("sun.cpu.endian", "little");
    System.setProperty("inheritance_file", "/var/folders/yc/kykqf2wd0tgdw_85fbvlyj680000gn/T/ES_inheritancetree4864283005723658169.xml.gz");
    System.setProperty("java.rmi.server.hostname", "127.0.0.1");
    System.setProperty("java.vendor.version", "Temurin-11.0.15+10");
    System.setProperty("TARGET_CLASS", "alfio.manager.payment.saferpay.PaymentPageInitializeRequestBuilder");
    System.setProperty("evosuite.log.appender", "CLIENT");
    System.setProperty("test_naming_strategy", "coverage");
    System.setProperty("sun.cpu.isalist", "");
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(PaymentPageInitializeRequestBuilder_ESTest_scaffolding.class.getClassLoader() ,
      "alfio.manager.payment.saferpay.PaymentPageInitializeRequestBuilder",
      "alfio.manager.payment.PaymentSpecification",
      "alfio.model.transaction.PaymentMethod",
      "org.apache.commons.lang3.StringUtils",
      "com.google.gson.stream.JsonWriter"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(PaymentPageInitializeRequestBuilder_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "alfio.model.transaction.PaymentMethod",
      "alfio.manager.payment.saferpay.PaymentPageInitializeRequestBuilder",
      "com.fasterxml.jackson.annotation.JsonCreator$Mode",
      "org.springframework.transaction.annotation.Isolation",
      "org.springframework.transaction.annotation.Propagation",
      "com.fasterxml.jackson.databind.annotation.JsonSerialize$Inclusion",
      "com.fasterxml.jackson.databind.annotation.JsonSerialize$Typing",
      "org.springframework.context.annotation.ScopedProxyMode",
      "org.springframework.context.annotation.FilterType",
      "org.checkerframework.framework.qual.TypeUseLocation",
      "org.checkerframework.checker.units.qual.Prefix",
      "org.checkerframework.framework.qual.LiteralKind",
      "org.checkerframework.framework.qual.TypeKind",
      "org.springframework.web.bind.annotation.RequestMethod",
      "org.springframework.boot.autoconfigure.condition.SearchStrategy",
      "alfio.model.transaction.token.StripeSCACreditCardToken",
      "org.eclipse.jetty.util.log.Log$1",
      "org.eclipse.jetty.util.Loader",
      "org.eclipse.jetty.util.log.Log",
      "org.eclipse.jetty.util.log.AbstractLogger",
      "org.eclipse.jetty.util.log.Slf4jLog",
      "org.eclipse.jetty.util.log.JettyAwareLogger",
      "org.eclipse.jetty.util.Uptime$DefaultImpl",
      "org.eclipse.jetty.util.Uptime",
      "org.eclipse.jetty.util.component.AbstractLifeCycle",
      "org.eclipse.jetty.util.component.ContainerLifeCycle",
      "org.eclipse.jetty.server.handler.AbstractHandler",
      "org.eclipse.jetty.server.handler.AbstractHandlerContainer",
      "org.eclipse.jetty.server.handler.HandlerWrapper",
      "org.eclipse.jetty.server.handler.ScopedHandler",
      "org.eclipse.jetty.server.session.SessionHandler$1",
      "org.eclipse.jetty.server.session.SessionHandler",
      "alfio.model.EventAndOrganizationId",
      "org.apache.logging.log4j.MarkerManager",
      "org.apache.logging.log4j.MarkerManager$Log4jMarker",
      "org.apache.logging.log4j.util.PropertiesUtil$Environment",
      "org.apache.logging.log4j.util.PropertiesPropertySource",
      "org.apache.logging.log4j.util.PropertyFilePropertySource",
      "org.apache.logging.log4j.util.LoaderUtil$ThreadContextClassLoaderGetter",
      "org.apache.logging.log4j.util.LoaderUtil",
      "org.apache.logging.log4j.util.PropertySource$Comparator",
      "org.apache.logging.log4j.util.EnvironmentPropertySource",
      "org.apache.logging.log4j.util.SystemPropertiesPropertySource",
      "org.apache.logging.log4j.util.PropertySource$Util",
      "org.apache.logging.log4j.util.PropertiesUtil",
      "org.apache.logging.log4j.util.Constants",
      "org.apache.logging.log4j.spi.AbstractLogger",
      "org.apache.logging.log4j.message.AbstractMessageFactory",
      "org.apache.logging.log4j.message.ParameterizedNoReferenceMessageFactory",
      "org.apache.logging.log4j.message.DefaultFlowMessageFactory",
      "org.apache.logging.log4j.spi.AbstractLogger$LocalLogBuilder",
      "org.apache.logging.log4j.status.StatusLogger$BoundedQueue",
      "org.apache.logging.log4j.util.Strings",
      "org.apache.logging.log4j.simple.SimpleLogger",
      "org.apache.logging.log4j.spi.StandardLevel",
      "org.apache.logging.log4j.Level",
      "org.apache.logging.log4j.status.StatusLogger",
      "org.apache.logging.log4j.util.ProviderUtil",
      "org.apache.logging.log4j.spi.Provider",
      "org.apache.logging.log4j.core.impl.Log4jProvider",
      "org.apache.logging.log4j.core.util.Constants",
      "org.apache.logging.log4j.core.impl.Log4jContextFactory",
      "org.apache.logging.log4j.core.util.Loader",
      "org.apache.logging.log4j.core.selector.ClassLoaderContextSelector",
      "org.apache.logging.log4j.core.util.DefaultShutdownCallbackRegistry",
      "org.apache.logging.log4j.core.LifeCycle$State",
      "org.apache.logging.log4j.internal.LogManagerStatus",
      "org.apache.logging.log4j.LogManager",
      "org.apache.logging.log4j.core.AbstractLifeCycle",
      "org.apache.logging.log4j.core.filter.AbstractFilterable",
      "org.apache.logging.log4j.core.config.AbstractConfiguration",
      "org.apache.logging.log4j.core.config.NullConfiguration",
      "org.apache.logging.log4j.core.config.ConfigurationSource",
      "org.apache.logging.log4j.core.config.Property",
      "org.apache.logging.log4j.core.config.DefaultAdvertiser",
      "org.apache.logging.log4j.core.lookup.AbstractLookup",
      "org.apache.logging.log4j.core.lookup.AbstractConfigurationAwareLookup",
      "org.apache.logging.log4j.core.lookup.Interpolator",
      "org.apache.logging.log4j.core.lookup.PropertiesLookup",
      "org.apache.logging.log4j.core.lookup.Log4jLookup",
      "org.apache.logging.log4j.core.lookup.SystemPropertiesLookup",
      "org.apache.logging.log4j.core.lookup.EnvironmentLookup",
      "org.apache.logging.log4j.core.lookup.MapLookup",
      "org.apache.logging.log4j.core.lookup.MainMapLookup",
      "org.apache.logging.log4j.core.lookup.MarkerLookup",
      "org.apache.logging.log4j.core.lookup.JavaLookup",
      "org.apache.logging.log4j.core.lookup.LowerLookup",
      "org.apache.logging.log4j.core.lookup.UpperLookup",
      "org.apache.logging.log4j.core.appender.AbstractManager",
      "org.apache.logging.log4j.core.net.JndiManager$JndiManagerFactory",
      "org.apache.logging.log4j.core.net.JndiManager",
      "org.apache.logging.log4j.core.lookup.JmxRuntimeInputArgumentsLookup",
      "org.apache.logging.log4j.core.lookup.DateLookup",
      "org.apache.logging.log4j.core.lookup.StrMatcher$CharMatcher",
      "org.apache.logging.log4j.core.lookup.StrMatcher$CharSetMatcher",
      "org.apache.logging.log4j.core.lookup.StrMatcher$TrimMatcher",
      "org.apache.logging.log4j.core.lookup.StrMatcher$NoMatcher",
      "org.apache.logging.log4j.core.lookup.StrMatcher",
      "org.apache.logging.log4j.core.lookup.StrMatcher$StringMatcher",
      "org.apache.logging.log4j.core.lookup.StrSubstitutor",
      "org.apache.logging.log4j.core.lookup.RuntimeStrSubstitutor",
      "org.apache.logging.log4j.core.lookup.ConfigurationStrSubstitutor",
      "org.apache.logging.log4j.core.impl.DefaultLogEventFactory",
      "org.apache.logging.log4j.core.config.LoggerConfig",
      "org.apache.logging.log4j.core.config.AppenderControlArraySet",
      "org.apache.logging.log4j.core.config.AppenderControl",
      "org.apache.logging.log4j.core.config.DefaultReliabilityStrategy",
      "org.apache.logging.log4j.core.config.ConfigurationScheduler",
      "org.apache.logging.log4j.core.util.WatchManager",
      "org.apache.logging.log4j.core.util.WatchManager$LocalUUID",
      "org.apache.logging.log4j.core.LoggerContext",
      "alfio.model.Event",
      "alfio.model.transaction.token.MollieToken",
      "alfio.model.transaction.token.PayPalToken",
      "alfio.model.CustomerName",
      "org.apache.commons.lang3.StringUtils",
      "org.apache.commons.lang3.Validate",
      "alfio.model.transaction.token.SaferpayToken",
      "alfio.model.transaction.token.StripeCreditCardToken",
      "alfio.model.TicketReservation",
      "alfio.model.TotalPrice",
      "alfio.model.OrderSummary",
      "alfio.manager.payment.PaymentSpecification",
      "com.zaxxer.hikari.HikariConfig",
      "com.zaxxer.hikari.HikariDataSource",
      "org.springframework.core.SpringProperties",
      "org.springframework.jdbc.support.JdbcAccessor",
      "org.springframework.jdbc.core.JdbcTemplate",
      "org.springframework.jdbc.core.ArgumentPreparedStatementSetter",
      "org.springframework.jdbc.core.BeanPropertyRowMapper",
      "org.springframework.jdbc.core.DataClassRowMapper",
      "org.springframework.core.convert.support.GenericConversionService$NoOpConverter",
      "org.springframework.core.convert.support.GenericConversionService",
      "org.springframework.core.convert.support.DefaultConversionService",
      "org.springframework.core.convert.support.GenericConversionService$Converters",
      "org.springframework.util.ConcurrentReferenceHashMap$ReferenceType",
      "org.springframework.util.ConcurrentReferenceHashMap",
      "org.springframework.util.Assert",
      "org.springframework.util.ConcurrentReferenceHashMap$Segment",
      "org.springframework.util.ConcurrentReferenceHashMap$ReferenceManager",
      "org.springframework.core.convert.support.NumberToNumberConverterFactory",
      "org.springframework.core.ResolvableType$EmptyType",
      "org.springframework.core.ResolvableType",
      "org.springframework.core.ResolvableType$DefaultVariableResolver",
      "org.springframework.util.ObjectUtils",
      "org.springframework.util.ConcurrentReferenceHashMap$Restructure",
      "org.springframework.util.ConcurrentReferenceHashMap$Task",
      "org.springframework.util.ConcurrentReferenceHashMap$1",
      "org.springframework.util.ConcurrentReferenceHashMap$TaskOption",
      "org.springframework.util.ConcurrentReferenceHashMap$Entry",
      "org.springframework.util.ConcurrentReferenceHashMap$SoftEntryReference",
      "org.springframework.core.convert.support.GenericConversionService$ConverterFactoryAdapter",
      "org.springframework.core.convert.converter.GenericConverter$ConvertiblePair",
      "org.springframework.core.convert.support.GenericConversionService$ConvertersForPair",
      "org.springframework.core.convert.support.StringToNumberConverterFactory",
      "org.springframework.core.convert.support.ObjectToStringConverter",
      "org.springframework.core.convert.support.GenericConversionService$ConverterAdapter",
      "org.springframework.core.convert.support.StringToCharacterConverter",
      "org.springframework.core.convert.support.NumberToCharacterConverter",
      "org.springframework.core.convert.support.CharacterToNumberFactory",
      "org.springframework.core.convert.support.StringToBooleanConverter",
      "org.springframework.core.convert.support.StringToEnumConverterFactory",
      "org.springframework.core.convert.support.AbstractConditionalEnumConverter",
      "org.springframework.core.convert.support.EnumToStringConverter",
      "org.springframework.core.convert.support.IntegerToEnumConverterFactory",
      "org.springframework.core.convert.support.EnumToIntegerConverter",
      "org.springframework.core.convert.support.StringToLocaleConverter",
      "org.springframework.core.convert.support.StringToCharsetConverter",
      "org.springframework.core.convert.support.StringToCurrencyConverter",
      "org.springframework.core.convert.support.StringToPropertiesConverter",
      "org.springframework.core.convert.support.PropertiesToStringConverter",
      "org.springframework.core.convert.support.StringToUUIDConverter",
      "org.springframework.core.convert.support.ArrayToCollectionConverter",
      "org.springframework.core.convert.support.CollectionToArrayConverter",
      "org.springframework.core.convert.support.ArrayToArrayConverter",
      "org.springframework.core.convert.support.CollectionToCollectionConverter",
      "org.springframework.core.convert.support.MapToMapConverter",
      "org.springframework.core.convert.support.ArrayToStringConverter",
      "org.springframework.core.convert.support.CollectionToStringConverter",
      "org.springframework.core.convert.support.StringToArrayConverter",
      "org.springframework.core.convert.support.ArrayToObjectConverter",
      "org.springframework.core.convert.support.ObjectToArrayConverter",
      "org.springframework.core.convert.support.StringToCollectionConverter",
      "org.springframework.core.convert.support.CollectionToObjectConverter",
      "org.springframework.core.convert.support.ObjectToCollectionConverter",
      "org.springframework.core.convert.TypeDescriptor$AnnotatedElementAdapter",
      "org.springframework.core.convert.TypeDescriptor",
      "org.springframework.core.convert.support.StreamConverter",
      "org.springframework.core.convert.support.ByteBufferConverter",
      "org.springframework.core.convert.support.StringToTimeZoneConverter",
      "org.springframework.core.convert.support.ZoneIdToTimeZoneConverter",
      "org.springframework.core.convert.support.ZonedDateTimeToCalendarConverter",
      "org.springframework.core.convert.support.ObjectToObjectConverter",
      "org.springframework.core.convert.support.IdToEntityConverter",
      "org.springframework.core.convert.support.FallbackObjectToStringConverter",
      "org.springframework.core.convert.support.ObjectToOptionalConverter",
      "org.springframework.jdbc.core.RowMapperResultSetExtractor",
      "org.springframework.jdbc.core.JdbcTemplate$SimplePreparedStatementCreator",
      "org.springframework.jdbc.core.JdbcTemplate$1",
      "org.springframework.jdbc.datasource.DataSourceUtils",
      "org.springframework.core.NamedThreadLocal",
      "org.springframework.util.StringUtils",
      "org.springframework.transaction.support.TransactionSynchronizationManager",
      "org.springframework.util.ClassUtils",
      "org.springframework.transaction.support.TransactionSynchronizationUtils",
      "org.springframework.transaction.support.TransactionSynchronizationUtils$ScopedProxyUnwrapper",
      "com.zaxxer.hikari.util.UtilityElf",
      "alfio.util.LocaleUtil",
      "alfio.util.MonetaryUtil",
      "org.springframework.jdbc.core.SingleColumnRowMapper",
      "org.springframework.jdbc.core.JdbcTemplate$1QueryStatementCallback",
      "alfio.util.ClockProvider",
      "org.postgresql.util.SharedTimer",
      "org.postgresql.Driver",
      "org.postgresql.ds.common.BaseDataSource",
      "org.postgresql.ds.PGSimpleDataSource",
      "org.springframework.jdbc.core.ArgumentTypePreparedStatementSetter",
      "org.springframework.core.NestedRuntimeException",
      "org.springframework.dao.DataAccessException",
      "org.springframework.dao.NonTransientDataAccessException",
      "org.springframework.dao.InvalidDataAccessApiUsageException",
      "org.springframework.core.PrioritizedParameterNameDiscoverer",
      "org.springframework.core.DefaultParameterNameDiscoverer",
      "org.springframework.core.KotlinDetector",
      "org.springframework.core.StandardReflectionParameterNameDiscoverer",
      "org.springframework.core.LocalVariableTableParameterNameDiscoverer",
      "org.springframework.beans.BeanUtils",
      "org.springframework.core.io.support.SpringFactoriesLoader",
      "org.springframework.core.io.AbstractResource",
      "org.springframework.core.io.AbstractFileResolvingResource",
      "org.springframework.core.io.UrlResource",
      "org.springframework.core.io.support.PropertiesLoaderUtils",
      "org.springframework.util.ResourceUtils",
      "org.springframework.util.CollectionUtils",
      "org.springframework.core.OrderComparator",
      "org.springframework.core.annotation.AnnotationAwareOrderComparator",
      "org.springframework.beans.CachedIntrospectionResults",
      "org.springframework.beans.GenericTypeAwarePropertyDescriptor",
      "org.springframework.core.BridgeMethodResolver",
      "org.springframework.core.GenericTypeResolver",
      "org.springframework.core.MethodParameter",
      "org.springframework.core.SerializableTypeWrapper$MethodParameterTypeProvider",
      "org.springframework.core.SerializableTypeWrapper",
      "org.springframework.core.NativeDetector",
      "org.springframework.core.SerializableTypeWrapper$TypeProxyInvocationHandler",
      "org.springframework.core.SerializableTypeWrapper$MethodInvokeTypeProvider",
      "org.springframework.util.ReflectionUtils",
      "alfio.model.metadata.AlfioMetadata",
      "alfio.model.checkin.EventWithCheckInInfo",
      "org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate",
      "org.springframework.util.ConcurrentLruCache",
      "org.springframework.jdbc.core.namedparam.EmptySqlParameterSource",
      "org.springframework.jdbc.core.namedparam.NamedParameterUtils",
      "org.springframework.jdbc.core.namedparam.ParsedSql",
      "org.springframework.jdbc.core.PreparedStatementCreatorFactory",
      "org.springframework.jdbc.core.PreparedStatementCreatorFactory$PreparedStatementCreatorImpl",
      "org.eclipse.jetty.util.AbstractTrie",
      "org.eclipse.jetty.util.ArrayTrie",
      "org.eclipse.jetty.util.BufferUtil",
      "org.eclipse.jetty.http.HttpField",
      "org.eclipse.jetty.http.Http1FieldPreEncoder",
      "org.eclipse.jetty.util.MathUtils",
      "org.eclipse.jetty.util.StringUtil",
      "org.eclipse.jetty.http.HttpVersion",
      "org.eclipse.jetty.http.PreEncodedHttpField$1",
      "org.eclipse.jetty.http.PreEncodedHttpField",
      "org.eclipse.jetty.http.HttpHeader",
      "org.eclipse.jetty.http.MimeTypes$Type",
      "org.eclipse.jetty.http.MimeTypes",
      "alfio.model.SummaryRow",
      "org.springframework.jdbc.core.namedparam.AbstractSqlParameterSource",
      "org.springframework.jdbc.core.namedparam.MapSqlParameterSource",
      "org.postgresql.util.URLCoder",
      "org.postgresql.Driver$1",
      "org.postgresql.jdbc.PgConnection",
      "org.postgresql.util.internal.Nullness",
      "org.postgresql.util.HostSpec",
      "org.postgresql.jdbc.PgConnection$ReadOnlyBehavior",
      "org.postgresql.core.ConnectionFactory",
      "org.postgresql.core.v3.ConnectionFactoryImpl",
      "org.postgresql.jdbc.SslMode",
      "org.postgresql.jdbc.GSSEncMode",
      "org.postgresql.hostchooser.HostRequirement",
      "org.postgresql.core.SocketFactoryFactory",
      "org.postgresql.hostchooser.HostChooserFactory",
      "org.postgresql.hostchooser.SingleHostChooser",
      "org.postgresql.hostchooser.CandidateHost",
      "org.postgresql.core.PGStream",
      "org.postgresql.util.PSQLException",
      "org.postgresql.util.GT",
      "org.postgresql.util.PSQLState",
      "org.springframework.dao.NonTransientDataAccessResourceException",
      "org.springframework.dao.DataAccessResourceFailureException",
      "org.springframework.jdbc.CannotGetJdbcConnectionException",
      "org.springframework.jdbc.core.namedparam.NamedParameterUtils$ParameterHolder",
      "org.springframework.jdbc.core.SqlParameter",
      "alfio.model.transaction.PaymentContext",
      "org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource",
      "org.springframework.beans.PropertyAccessorFactory",
      "org.springframework.beans.PropertyEditorRegistrySupport",
      "org.springframework.beans.TypeConverterSupport",
      "org.springframework.beans.AbstractPropertyAccessor",
      "org.springframework.beans.AbstractNestablePropertyAccessor",
      "org.springframework.beans.BeanWrapperImpl",
      "org.springframework.beans.TypeConverterDelegate",
      "org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator",
      "org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator",
      "org.springframework.jdbc.support.SQLExceptionSubclassTranslator",
      "org.springframework.jdbc.support.SQLStateSQLExceptionTranslator",
      "org.springframework.util.function.SingletonSupplier",
      "org.springframework.core.SimpleAliasRegistry",
      "org.springframework.beans.factory.support.DefaultSingletonBeanRegistry",
      "org.springframework.beans.factory.support.FactoryBeanRegistrySupport",
      "org.springframework.beans.factory.support.AbstractBeanFactory",
      "org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory",
      "org.springframework.beans.factory.support.DefaultListableBeanFactory",
      "org.springframework.beans.factory.support.AbstractBeanFactory$BeanPostProcessorCacheAwareList",
      "org.springframework.core.metrics.DefaultApplicationStartup$DefaultStartupStep",
      "org.springframework.core.metrics.DefaultApplicationStartup$DefaultStartupStep$DefaultTags",
      "org.springframework.core.metrics.DefaultApplicationStartup",
      "org.springframework.core.metrics.ApplicationStartup",
      "org.springframework.beans.factory.support.SimpleInstantiationStrategy",
      "org.springframework.beans.factory.support.CglibSubclassingInstantiationStrategy",
      "org.springframework.beans.factory.support.SimpleAutowireCandidateResolver",
      "org.springframework.beans.factory.support.AbstractBeanDefinitionReader",
      "org.springframework.core.Constants",
      "org.springframework.beans.factory.xml.XmlBeanDefinitionReader",
      "org.springframework.beans.factory.support.DefaultBeanNameGenerator",
      "org.springframework.core.io.support.PathMatchingResourcePatternResolver",
      "org.springframework.util.AntPathMatcher",
      "org.springframework.util.AntPathMatcher$PathSeparatorPatternCache",
      "org.springframework.core.io.DefaultResourceLoader",
      "org.springframework.core.env.AbstractEnvironment",
      "org.springframework.core.env.StandardEnvironment",
      "org.springframework.core.env.MutablePropertySources",
      "org.springframework.core.env.AbstractPropertyResolver",
      "org.springframework.core.env.PropertySourcesPropertyResolver",
      "org.springframework.core.env.PropertySource",
      "org.springframework.core.env.EnumerablePropertySource",
      "org.springframework.core.env.MapPropertySource",
      "org.springframework.core.env.PropertiesPropertySource",
      "org.springframework.core.env.SystemEnvironmentPropertySource",
      "org.springframework.beans.factory.parsing.FailFastProblemReporter",
      "org.springframework.beans.factory.parsing.EmptyReaderEventListener",
      "org.springframework.beans.factory.parsing.NullSourceExtractor",
      "org.springframework.beans.factory.xml.DefaultDocumentLoader",
      "org.springframework.util.xml.SimpleSaxErrorHandler",
      "org.springframework.util.xml.XmlValidationModeDetector",
      "org.springframework.beans.factory.xml.XmlBeanDefinitionReader$1",
      "org.springframework.core.io.ClassPathResource",
      "org.springframework.core.io.support.EncodedResource",
      "org.springframework.beans.factory.xml.DelegatingEntityResolver",
      "org.springframework.beans.factory.xml.ResourceEntityResolver",
      "org.springframework.beans.factory.xml.BeansDtdResolver",
      "org.springframework.beans.factory.xml.PluggableSchemaResolver",
      "org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader",
      "org.springframework.beans.factory.parsing.ReaderContext",
      "org.springframework.beans.factory.xml.XmlReaderContext",
      "org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver",
      "org.springframework.beans.factory.xml.BeanDefinitionParserDelegate",
      "org.springframework.beans.factory.xml.DocumentDefaultsDefinition",
      "org.springframework.beans.factory.parsing.ParseState",
      "org.springframework.beans.factory.parsing.BeanEntry",
      "org.springframework.beans.factory.support.BeanDefinitionReaderUtils",
      "org.springframework.core.AttributeAccessorSupport",
      "org.springframework.beans.BeanMetadataAttributeAccessor",
      "org.springframework.beans.factory.support.AbstractBeanDefinition",
      "org.springframework.beans.factory.support.GenericBeanDefinition",
      "org.springframework.beans.factory.support.MethodOverrides",
      "org.springframework.util.xml.DomUtils",
      "org.springframework.beans.factory.parsing.PropertyEntry",
      "org.springframework.beans.MutablePropertyValues",
      "org.springframework.beans.factory.config.TypedStringValue",
      "org.springframework.beans.PropertyValue",
      "org.springframework.beans.factory.config.BeanDefinitionHolder",
      "org.springframework.beans.factory.parsing.BeanComponentDefinition",
      "org.springframework.beans.factory.support.ManagedList",
      "org.springframework.core.ResolvableType$1",
      "org.springframework.beans.factory.support.RootBeanDefinition",
      "org.springframework.beans.factory.support.AbstractBeanFactory$BeanPostProcessorCache",
      "org.springframework.beans.factory.BeanFactoryUtils",
      "org.springframework.jdbc.support.SQLErrorCodes",
      "org.springframework.beans.factory.support.BeanDefinitionValueResolver",
      "org.springframework.beans.factory.config.AutowiredPropertyMarker",
      "org.springframework.beans.PropertyAccessorUtils",
      "org.springframework.beans.AbstractNestablePropertyAccessor$PropertyHandler",
      "org.springframework.beans.BeanWrapperImpl$BeanPropertyHandler",
      "org.springframework.core.convert.Property",
      "org.springframework.beans.propertyeditors.CharsetEditor",
      "org.springframework.beans.propertyeditors.ClassEditor",
      "org.springframework.beans.propertyeditors.ClassArrayEditor",
      "org.springframework.beans.propertyeditors.CurrencyEditor",
      "org.springframework.beans.propertyeditors.FileEditor",
      "org.springframework.core.io.ResourceEditor",
      "org.springframework.beans.propertyeditors.InputStreamEditor",
      "org.springframework.beans.propertyeditors.InputSourceEditor",
      "org.springframework.beans.propertyeditors.LocaleEditor",
      "org.springframework.beans.propertyeditors.PathEditor",
      "org.springframework.beans.propertyeditors.PatternEditor",
      "org.springframework.beans.propertyeditors.PropertiesEditor",
      "org.springframework.beans.propertyeditors.ReaderEditor",
      "org.springframework.core.io.support.ResourceArrayPropertyEditor",
      "org.springframework.beans.propertyeditors.TimeZoneEditor",
      "org.springframework.beans.propertyeditors.URIEditor",
      "org.springframework.beans.propertyeditors.URLEditor",
      "org.springframework.beans.propertyeditors.UUIDEditor",
      "org.springframework.beans.propertyeditors.ZoneIdEditor",
      "org.springframework.beans.propertyeditors.CustomCollectionEditor",
      "org.springframework.beans.propertyeditors.CustomMapEditor",
      "org.springframework.beans.propertyeditors.ByteArrayPropertyEditor",
      "org.springframework.beans.propertyeditors.CharArrayPropertyEditor",
      "org.springframework.beans.propertyeditors.CharacterEditor",
      "org.springframework.beans.propertyeditors.CustomBooleanEditor",
      "org.springframework.beans.propertyeditors.CustomNumberEditor",
      "org.springframework.beans.propertyeditors.StringArrayPropertyEditor",
      "org.springframework.beans.AbstractNestablePropertyAccessor$PropertyTokenHolder",
      "org.springframework.beans.factory.support.DisposableBeanAdapter",
      "org.springframework.beans.factory.support.BeanDefinitionValueResolver$KeyedArgName",
      "org.springframework.jdbc.support.SQLErrorCodesFactory",
      "org.springframework.jdbc.support.JdbcUtils",
      "org.springframework.core.NestedCheckedException",
      "org.springframework.jdbc.support.MetaDataAccessException",
      "org.eclipse.jetty.security.DefaultAuthenticatorFactory",
      "org.eclipse.jetty.security.SecurityHandler$1",
      "org.eclipse.jetty.security.SecurityHandler$2",
      "org.eclipse.jetty.security.SecurityHandler",
      "org.eclipse.jetty.security.ConstraintSecurityHandler",
      "org.eclipse.jetty.util.component.DumpableCollection",
      "org.eclipse.jetty.util.component.ContainerLifeCycle$Managed",
      "org.eclipse.jetty.util.component.ContainerLifeCycle$Bean",
      "org.eclipse.jetty.util.component.ContainerLifeCycle$1",
      "org.eclipse.jetty.http.PathMap",
      "org.eclipse.jetty.util.ArrayTernaryTrie",
      "com.fasterxml.jackson.databind.JsonSerializable$Base",
      "com.fasterxml.jackson.databind.JsonNode",
      "com.fasterxml.jackson.databind.node.BaseJsonNode",
      "com.fasterxml.jackson.databind.node.ValueNode",
      "com.fasterxml.jackson.databind.node.NumericNode",
      "com.fasterxml.jackson.databind.node.FloatNode",
      "com.fasterxml.jackson.databind.node.DoubleNode"
    );
  }
}
