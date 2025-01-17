package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class InvoicePractice extends BaseClass {
@Test
public void createInvoiceTest() {
	System.out.println(" execute Invoice test");
	String actTitle= driver.getTitle();
	Assert.assertEquals(actTitle, "Login");
	System.out.println("step 1");
	System.out.println("step 2");
	System.out.println("step 3");
	System.out.println("step 4");
}
}
