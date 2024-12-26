package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class WebDriverUtility {
	public String getScreenShot(WebDriver driver, String screenShotName)  {
		JavaUtility javaUtility = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/" + screenShotName + "+" +javaUtility.getSystemDateYYYYMMDD() + ".png");
		String path = ts.getScreenshotAs(OutputType.BASE64);
			try {
				FileHandler.copy(src, dst);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return path;
	}
}
