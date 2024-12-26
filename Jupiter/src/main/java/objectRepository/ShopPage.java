package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShopPage {
	
	@FindBy(xpath = "//li[@id='product-2']//a[contains(@class,'btn btn-success')][normalize-space()='Buy']")private WebElement stuffedFrogBtn;
	
	@FindBy(xpath = "//li[@id='product-2']//span[@class='product-price ng-binding'][normalize-space()='$10.99']")private WebElement stuffedFrogPrice;
	
	@FindBy(xpath = "//li[@id='product-4']/descendant::a[@class='btn btn-success'][normalize-space()='Buy']")private WebElement fluffyBunnyBtn;
	
	@FindBy(xpath = "//li[@id='product-4']//span[@class='product-price ng-binding'][normalize-space()='$9.99']")private WebElement fluffyBunnyPrice;
	
	@FindBy(xpath = "//li[@id='product-7']/descendant::a[@class='btn btn-success'][normalize-space()='Buy']")private WebElement valentineBearBtn;
	
	@FindBy(xpath = "//li[@id='product-7']//span[@class='product-price ng-binding'][normalize-space()='$14.99']")private WebElement valentineBearPrice;
	
	@FindBy(xpath = "//a[@href='#/cart']")private WebElement cartBtn;
	
	public ShopPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getStuffedFrogBtn() {
		return stuffedFrogBtn;
	}

	public WebElement getStuffedFrogPrice() {
		return stuffedFrogPrice;
	}

	public WebElement getFluffyBunnyBtn() {
		return fluffyBunnyBtn;
	}

	public WebElement getFluffyBunnyPrice() {
		return fluffyBunnyPrice;
	}

	public WebElement getValentineBearBtn() {
		return valentineBearBtn;
	}

	public WebElement getValentineBearPrice() {
		return valentineBearPrice;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}

	
	public void verifyProductPrice(String stuffedFrogPriceInCart,String fluffyBunnyPriceInCart,String valentineBearPriceInCart ) {
		String stuffedFrogPrice = getStuffedFrogPrice().getText().trim();
		String fluffyBunnyPrice = getFluffyBunnyPrice().getText().trim();
		String valentineBearPrice = getValentineBearPrice().getText().trim();
		Assert.assertEquals(stuffedFrogPrice, stuffedFrogPriceInCart);
		Assert.assertEquals(fluffyBunnyPrice, fluffyBunnyPriceInCart);
		Assert.assertEquals(valentineBearPrice, valentineBearPriceInCart);
	}

}
