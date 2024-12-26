package jupiter;

import org.testng.annotations.Test;

import objectRepository.CartPage;
import objectRepository.HomePage;
import objectRepository.ShopPage;
import utilities.BaseClass;
import utilities.ExecelUtility;

public class JupiterContactTest3 extends BaseClass {

	@Test
	public void orderTheToysAndVerify() throws Throwable {

		HomePage hp = new HomePage(driver);
		ShopPage sp = new ShopPage(driver);
		CartPage cp = new CartPage(driver);

		ExecelUtility eLib = new ExecelUtility();

		String stuffedFrogQty = eLib.readDataFromExcel("Project", 2, 0);
		String fluffyBunnyQty = eLib.readDataFromExcel("Project", 2, 1);
		String valentineBearQty = eLib.readDataFromExcel("Project", 2, 2);

		cp.buyTheProductsAndVerify(hp, sp, stuffedFrogQty, fluffyBunnyQty, valentineBearQty);

	}
}
