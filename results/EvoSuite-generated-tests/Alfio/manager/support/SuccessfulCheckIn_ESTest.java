/*
 * This file was automatically generated by EvoSuite
 * Mon Jan 09 23:13:28 GMT 2023
 */

package alfio.manager.support;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import alfio.manager.support.AdditionalServiceInfo;
import alfio.manager.support.SuccessfulCheckIn;
import alfio.model.TicketFieldValueForAdditionalService;
import alfio.model.TicketWithCategory;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class SuccessfulCheckIn_ESTest extends SuccessfulCheckIn_ESTest_scaffolding {

  @Test
  public void testGetBoxColorReturningNull()  throws Throwable  {
      LinkedList<AdditionalServiceInfo> linkedList0 = new LinkedList<AdditionalServiceInfo>();
      SuccessfulCheckIn successfulCheckIn0 = new SuccessfulCheckIn((TicketWithCategory) null, linkedList0, (String) null);
      String string0 = successfulCheckIn0.getBoxColor();
      assertNull(string0);
  }

  @Test
  public void testGetBoxColorReturningEmptyString()  throws Throwable  {
      SuccessfulCheckIn successfulCheckIn0 = new SuccessfulCheckIn((TicketWithCategory) null, (List<AdditionalServiceInfo>) null, "");
      String string0 = successfulCheckIn0.getBoxColor();
      assertEquals("", string0);
  }

  @Test
  public void testGetAdditionalServicesReturningNull()  throws Throwable  {
      SuccessfulCheckIn successfulCheckIn0 = new SuccessfulCheckIn((TicketWithCategory) null, (List<AdditionalServiceInfo>) null, "F*N>D7^.!]J");
      List<AdditionalServiceInfo> list0 = successfulCheckIn0.getAdditionalServices();
      assertNull(list0);
  }

  @Test
  public void testGetAdditionalServicesReturningListWhereIsEmptyIsFalse()  throws Throwable  {
      Vector<AdditionalServiceInfo> vector0 = new Vector<AdditionalServiceInfo>(663);
      SuccessfulCheckIn successfulCheckIn0 = new SuccessfulCheckIn((TicketWithCategory) null, vector0, "");
      TicketFieldValueForAdditionalService ticketFieldValueForAdditionalService0 = mock(TicketFieldValueForAdditionalService.class, new ViolatedAssumptionAnswer());
      TicketFieldValueForAdditionalService ticketFieldValueForAdditionalService1 = mock(TicketFieldValueForAdditionalService.class, new ViolatedAssumptionAnswer());
      List<TicketFieldValueForAdditionalService> list0 = List.of(ticketFieldValueForAdditionalService0, ticketFieldValueForAdditionalService0, ticketFieldValueForAdditionalService0, ticketFieldValueForAdditionalService0, ticketFieldValueForAdditionalService0, ticketFieldValueForAdditionalService1, ticketFieldValueForAdditionalService0, ticketFieldValueForAdditionalService1);
      AdditionalServiceInfo additionalServiceInfo0 = new AdditionalServiceInfo((String) null, (-1112), list0);
      vector0.add(additionalServiceInfo0);
      List<AdditionalServiceInfo> list1 = successfulCheckIn0.getAdditionalServices();
      assertFalse(list1.isEmpty());
  }

  @Test
  public void testGetBoxColorReturningNonEmptyString()  throws Throwable  {
      SuccessfulCheckIn successfulCheckIn0 = new SuccessfulCheckIn((TicketWithCategory) null, (List<AdditionalServiceInfo>) null, "bVW");
      String string0 = successfulCheckIn0.getBoxColor();
      assertEquals("bVW", string0);
  }

  @Test
  public void testGetAdditionalServicesReturningListWhereIsEmptyIsTrue()  throws Throwable  {
      Vector<AdditionalServiceInfo> vector0 = new Vector<AdditionalServiceInfo>(663);
      SuccessfulCheckIn successfulCheckIn0 = new SuccessfulCheckIn((TicketWithCategory) null, vector0, "");
      List<AdditionalServiceInfo> list0 = successfulCheckIn0.getAdditionalServices();
      assertEquals(0, list0.size());
  }
}
