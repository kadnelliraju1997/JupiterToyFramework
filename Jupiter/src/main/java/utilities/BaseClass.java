package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public static WebDriver sessionDriver=null;
	public WebDriver driver;
	

	@BeforeClass
	public void openBrowser() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		FileUtility fLib = new FileUtility();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		String url = fLib.getDataFromPropertyFile("url");
		driver.get(url);
		sessionDriver=driver;
		UtilityObjectClass.setDriver(driver);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
