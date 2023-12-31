/*
 * This file was automatically generated by EvoSuite
 * Tue Jan 10 07:54:42 GMT 2023
 */

package alfio.manager.payment.saferpay;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class PaymentPageAssertRequestBuilder_ESTest extends PaymentPageAssertRequestBuilder_ESTest_scaffolding {

  @Test
  public void testBuild()  throws Throwable  {
      PaymentPageAssertRequestBuilder paymentPageAssertRequestBuilder0 = new PaymentPageAssertRequestBuilder((String) null, 0);
      String string0 = paymentPageAssertRequestBuilder0.build();
      assertNotNull(string0);
  }

  @Test
  public void testAddAuthentication()  throws Throwable  {
      PaymentPageAssertRequestBuilder paymentPageAssertRequestBuilder0 = new PaymentPageAssertRequestBuilder((String) null, 0);
      PaymentPageAssertRequestBuilder paymentPageAssertRequestBuilder1 = paymentPageAssertRequestBuilder0.addAuthentication((String) null, "%%");
      assertSame(paymentPageAssertRequestBuilder1, paymentPageAssertRequestBuilder0);
  }
}
