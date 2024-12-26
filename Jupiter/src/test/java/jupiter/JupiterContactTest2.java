package jupiter;

import org.testng.annotations.Test;

import objectRepository.ContactPage;
import objectRepository.HomePage;
import utilities.BaseClass;
import utilities.ExecelUtility;

public class JupiterContactTest2 extends BaseClass {
	@Test
	public void createContactWithoutMandatoryFields() throws Throwable {
		HomePage hp = new HomePage(driver);
		ExecelUtility eLib = new ExecelUtility();
		ContactPage cp = new ContactPage(driver);
		String expErrorFormname = eLib.readDataFromExcel("Project", 1, 0);
		String expErrorEmail = eLib.readDataFromExcel("Project", 1, 1);
		String expErrorMessage = eLib.readDataFromExcel("Project", 1, 2);

		cp.clickOnSubmitButton(hp);
		cp.verifyErrorMsg(expErrorFormname, expErrorEmail, expErrorMessage);
	}
}
