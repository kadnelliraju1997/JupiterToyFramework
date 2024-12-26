package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

    @FindBy(xpath = "//tbody/tr[1]/td[3]/input[1]")private WebElement stuffedFrogQtyTf;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]")private WebElement stuffedFrogPriceInCart;
	
	@FindBy(xpath = "//tbody/tr[2]/td[2]")private WebElement fluffyBunnyPriceInCart;
	
	@FindBy(xpath = "//tbody/tr[2]/td[3]/input[1]")private WebElement fluffyBunnyQtyTf;
	
	@FindBy(xpath = "//tbody/tr[3]/td[2]")private WebElement valentineBearPriceInCart;
	
	@FindBy(xpath = "//tbody/tr[3]/td[3]/input[1]")private WebElement valentineBearQtyTf;

	@FindBy(xpath = "//a[normalize-space()='Check Out']")private WebElement checkOutBtn;
	
	@FindBy(xpath = "//strong[contains(@class,'total ng-binding')]")private WebElement totalPriceText;
	
	@FindBy(xpath = "//td[.='$21.98']")private WebElement stuffedFrogrSubTotal;

	@FindBy(xpath = "//td[.='$49.95']")private WebElement fluffyBunnySubTotal;
	
	@FindBy(xpath = "//td[.='$44.97']")private WebElement valentineBearSubTotal;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getStuffedFrogQtyTf() {
		return stuffedFrogQtyTf;
	}

	public WebElement getStuffedFrogPriceInCart() {
		return stuffedFrogPriceInCart;
	}

	public WebElement getFluffyBunnyPriceInCart() {
		return fluffyBunnyPriceInCart;
	}

	public WebElement getFluffyBunnyQtyTf() {
		return fluffyBunnyQtyTf;
	}

	public WebElement getValentineBearPriceInCart() {
		return valentineBearPriceInCart;
	}

	public WebElement getValentineBearQtyTf() {
		return valentineBearQtyTf;
	}

	public WebElement getCheckOutBtn() {
		return checkOutBtn;
	}

	public WebElement getTotalPriceText() {
		return totalPriceText;
	}

	public WebElement getStuffedFrogrSubTotal() {
		return stuffedFrogrSubTotal;
	}

	public WebElement getFluffyBunnySubTotal() {
		return fluffyBunnySubTotal;
	}

	public WebElement getValentineBearSubTotal() {
		return valentineBearSubTotal;
	}
	public void buyTheProductsAndVerify(HomePage hp,ShopPage sp,String stuffedFrogQty,String fluffyBunnyQty,String valentineBearQty  ){
		hp.getShopTab().click();
		sp.getStuffedFrogBtn().click();
		sp.getFluffyBunnyBtn().click();
		sp.getValentineBearBtn().click();
		String stuffedFrogPrice = sp.getStuffedFrogPrice().getText().trim();
		String fluffyBunnyPrice = sp.getFluffyBunnyPrice().getText().trim();
		String valentineBearPrice = sp.getValentineBearPrice().getText().trim();
		sp.getCartBtn().click();
		String stuffedFrogPriceInCart = getStuffedFrogPriceInCart().getText().trim();
		String fluffyBunnyPriceInCart = getFluffyBunnyPriceInCart().getText().trim();
		String valentineBearPriceInCart = getValentineBearPriceInCart().getText().trim();
		getStuffedFrogQtyTf().clear();
		getFluffyBunnyQtyTf().clear();
		getValentineBearQtyTf().clear();
		getStuffedFrogQtyTf().sendKeys(stuffedFrogQty);
		getFluffyBunnyQtyTf().sendKeys(fluffyBunnyQty);
		getValentineBearQtyTf().sendKeys(valentineBearQty);
		String stuffedFrogrSubTotal = getStuffedFrogrSubTotal().getText().trim();
		String fluffyBunnySubTotal = getFluffyBunnySubTotal().getText().trim();
		String valentineBearSubTotal = getValentineBearSubTotal().getText().trim();
		String totalPrice = getTotalPriceText().getText().trim();
		Assert.assertEquals(stuffedFrogPrice, stuffedFrogPriceInCart);
		Assert.assertEquals(fluffyBunnyPrice, fluffyBunnyPriceInCart);
		Assert.assertEquals(valentineBearPrice, valentineBearPriceInCart);
		Assert.assertEquals(stuffedFrogrSubTotal, "$21.98");
		Assert.assertEquals(fluffyBunnySubTotal, "$49.95");
		Assert.assertEquals(valentineBearSubTotal, "$44.97");
		Assert.assertEquals(totalPrice, "Total: 116.9");
		getCheckOutBtn().click();
	}
	
}
