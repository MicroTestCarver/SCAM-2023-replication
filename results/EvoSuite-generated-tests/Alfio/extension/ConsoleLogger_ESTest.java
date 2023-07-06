/*
 * This file was automatically generated by EvoSuite
 * Tue Jan 10 05:56:03 GMT 2023
 */

package alfio.extension;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import alfio.extension.ConsoleLogger;
import alfio.extension.ExtensionLogger;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class ConsoleLogger_ESTest extends ConsoleLogger_ESTest_scaffolding {

  @Test
  public void testWarn()  throws Throwable  {
      ExtensionLogger extensionLogger0 = mock(ExtensionLogger.class, new ViolatedAssumptionAnswer());
      ConsoleLogger consoleLogger0 = new ConsoleLogger(extensionLogger0);
      consoleLogger0.warn(consoleLogger0, (Object[]) null);
  }

//  @Test
//  public void testWarnThrowsNoClassDefFoundError()  throws Throwable  {
//      ConsoleLogger consoleLogger0 = new ConsoleLogger((ExtensionLogger) null);
//      Object[] objectArray0 = new Object[1];
//      // Undeclared exception!
//      try {
//        consoleLogger0.warn((Object) null, objectArray0);
//        fail("Expecting exception: NoClassDefFoundError");
//
//      } catch(NoClassDefFoundError e) {
//         //
//         // Could not initialize class alfio.extension.ExtensionUtils
//         //
//         verifyException("java.util.stream.ReferencePipeline$3$1", e);
//      }
//  }

  @Test
  public void testLogThrowsNullPointerException()  throws Throwable  {
      ConsoleLogger consoleLogger0 = new ConsoleLogger((ExtensionLogger) null);
      // Undeclared exception!
      try { 
        consoleLogger0.log((Object) null, (Object[]) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("alfio.extension.ConsoleLogger", e);
      }
  }

//  @Test
//  public void testLogThrowsNoClassDefFoundError()  throws Throwable  {
//      ConsoleLogger consoleLogger0 = new ConsoleLogger((ExtensionLogger) null);
//      Object[] objectArray0 = new Object[2];
//      // Undeclared exception!
//      try {
//        consoleLogger0.log(objectArray0[0], objectArray0);
//        fail("Expecting exception: NoClassDefFoundError");
//
//      } catch(NoClassDefFoundError e) {
//         //
//         // Could not initialize class alfio.extension.ExtensionUtils
//         //
//         verifyException("java.util.stream.ReferencePipeline$3$1", e);
//      }
//  }

  @Test
  public void testErrorThrowsNullPointerException()  throws Throwable  {
      ConsoleLogger consoleLogger0 = new ConsoleLogger((ExtensionLogger) null);
      // Undeclared exception!
      try { 
        consoleLogger0.error((Object) null, (Object[]) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("alfio.extension.ConsoleLogger", e);
      }
  }

//  @Test
//  public void testErrorThrowsNoClassDefFoundError()  throws Throwable  {
//      ConsoleLogger consoleLogger0 = new ConsoleLogger((ExtensionLogger) null);
//      Object[] objectArray0 = new Object[0];
//      // Undeclared exception!
//      try {
//        consoleLogger0.error((Object) null, objectArray0);
//        fail("Expecting exception: NoClassDefFoundError");
//
//      } catch(NoClassDefFoundError e) {
//         //
//         // Could not initialize class alfio.extension.ExtensionUtils
//         //
//         verifyException("java.util.stream.ReferencePipeline$3$1", e);
//      }
//  }

  @Test
  public void testError()  throws Throwable  {
      ExtensionLogger extensionLogger0 = mock(ExtensionLogger.class, new ViolatedAssumptionAnswer());
      ConsoleLogger consoleLogger0 = new ConsoleLogger(extensionLogger0);
      consoleLogger0.error(consoleLogger0, (Object[]) null);
  }

  @Test
  public void testLog()  throws Throwable  {
      ExtensionLogger extensionLogger0 = mock(ExtensionLogger.class, new ViolatedAssumptionAnswer());
      ConsoleLogger consoleLogger0 = new ConsoleLogger(extensionLogger0);
      consoleLogger0.log(consoleLogger0, (Object[]) null);
  }

  @Test
  public void testWarnThrowsNullPointerException()  throws Throwable  {
      ConsoleLogger consoleLogger0 = new ConsoleLogger((ExtensionLogger) null);
      // Undeclared exception!
      try { 
        consoleLogger0.warn((Object) null, (Object[]) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("alfio.extension.ConsoleLogger", e);
      }
  }
}