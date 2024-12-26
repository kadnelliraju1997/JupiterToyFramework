package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//a[normalize-space()='Contact']") private WebElement contactTab;
	
	@FindBy(xpath = "//a[normalize-space()='Shop']")private WebElement shopTab;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactTab() {
		return contactTab;
	}

	public WebElement getShopTab() {
		return shopTab;
	}
 
}
