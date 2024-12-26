package jupiter;

import org.testng.annotations.Test;

import objectRepository.ContactPage;
import objectRepository.HomePage;
import utilities.BaseClass;
import utilities.ExecelUtility;

public class JupiterContactTest1 extends BaseClass {

	@Test(invocationCount = 5)
	public void createContactTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		ExecelUtility eLib = new ExecelUtility();
		ContactPage cp = new ContactPage(driver);
		
		String formname = eLib.readDataFromExcel("Project", 0, 0);
		String email = eLib.readDataFromExcel("Project", 0, 1);
		String message = eLib.readDataFromExcel("Project", 0, 2);
		String actSuccessMsg = eLib.readDataFromExcel("Project", 0, 3);
		
		cp.submitContact(hp, formname, email, message, actSuccessMsg);
	}
}
