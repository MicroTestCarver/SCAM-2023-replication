/*
 * This file was automatically generated by EvoSuite
 * Tue Jan 10 05:32:54 GMT 2023
 */

package alfio.manager.payment.saferpay;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import alfio.manager.payment.PaymentSpecification;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class PaymentPageInitializeRequestBuilder_ESTest extends PaymentPageInitializeRequestBuilder_ESTest_scaffolding {

  @Test
  public void testFailsToCreatePaymentPageInitializeRequestBuilderThrowsNullPointerException()  throws Throwable  {
      PaymentPageInitializeRequestBuilder paymentPageInitializeRequestBuilder0 = null;
      try {
        paymentPageInitializeRequestBuilder0 = new PaymentPageInitializeRequestBuilder("D)VaFrcXE1^ap", (PaymentSpecification) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("alfio.manager.payment.saferpay.PaymentPageInitializeRequestBuilder", e);
      }
  }
}
