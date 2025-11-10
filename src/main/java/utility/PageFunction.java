package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFunction {

	public static void sendKeys(WebElement ele, String s) {
		ele.sendKeys(s);
	}

	public static void click(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

	}

	public static void simplewait(int duration) {
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void waitForElement(WebDriver driver, WebElement ele, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public static String takeScreenshot(WebDriver driver, String testcasename) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			String directory = System.getProperty("user.dir") + "\\test_screenshots";
			new File(directory).mkdir();
			SimpleDateFormat sdf = new SimpleDateFormat("ddmmyyyyhhMMss");
			String val = sdf.format(new Date());

			String filename = directory +"\\"+ testcasename + "_" + val + ".png";

			FileUtils.copyFile(file, new File(filename));
			return filename;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
