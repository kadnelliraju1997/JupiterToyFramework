package objectRepository;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.BaseClass;

public class ContactPage extends BaseClass{

	@FindBy(xpath = "//input[@id='forename']") private WebElement forenameTf;
	
	@FindBy(xpath = "//input[@id='surname']") private WebElement forenameTF;
	
	@FindBy(xpath = "//input[@id='surname']") private WebElement surnameTF;
	
	@FindBy(xpath = "//input[@id='email']") private WebElement emailTF;
	
	@FindBy(xpath = "//textarea[@id='message']") private WebElement messageTF;
	
	@FindBy(xpath = "//a[@class='btn-contact btn btn-primary']") private WebElement submitBtn;
	
	@FindBy(xpath = "//span[@id='forename-err']") private WebElement actErrorFormname;
	
	@FindBy(xpath = "//span[@id='email-err']") private WebElement actErrorEmail;
	
	@FindBy(xpath = "//span[@id='message-err']") private WebElement actErrorMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-success']") private WebElement actSuccessMsg;
	
	@FindBy(xpath = "//a[normalize-space()='« Back']") private WebElement backBtn;
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getForename() {
		return forenameTf;
	}

	public WebElement getForenameTF() {
		return forenameTF;
	}

	public WebElement getSurnameTF() {
		return surnameTF;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getMessageTF() {
		return messageTF;
	}
	
	
	public WebElement getForenameTf() {
		return forenameTf;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void submit() {
		
	}

	public WebElement getActErrorFormname() {
		return actErrorFormname;
	}

	public WebElement getActErrorEmail() {
		return actErrorEmail;
	}

	public WebElement getActErrorMessage() {
		return actErrorMessage;
	}

	public WebElement getActSuccessMsg() {
		return actSuccessMsg;
	}
	public WebElement getBackBtn() {
		return backBtn;
	}
	
	public void clickOnSubmitButton(HomePage hp) {
		hp.getContactTab().click();
		getSubmitBtn().click();
	}
	public void verifyErrorMsg(String expErrorFormname,String expErrorEmail,String  expErrorMessage) {
		String actErrorFormname = getActErrorFormname().getText().trim();
		String actErrorEmail = getActErrorEmail().getText().trim();
		String actErrorMessage = getActErrorMessage().getText().trim();
		Assert.assertEquals(actErrorFormname, expErrorFormname);
		Assert.assertEquals(actErrorEmail, expErrorEmail);
		Assert.assertEquals(actErrorMessage, expErrorMessage);
	}

	public void submitContact(HomePage hp,String formname,String email,String message,String actSuccessMsg) {
		hp.getContactTab().click();
		getForename().sendKeys(formname);
		getEmailTF().sendKeys(email);
		getMessageTF().sendKeys(message);
		getSubmitBtn().click();
		String expSuccessMsg = getActSuccessMsg().getText().trim();
		Assert.assertEquals(actSuccessMsg, expSuccessMsg);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(getBackBtn()));
		getBackBtn().click();
		
	}
	public void verifySuccessMsg(String actSuccessMsg) {
		
	}
}
