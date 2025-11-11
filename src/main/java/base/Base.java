package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utility.ExcelUtility;
import utility.Log;

public class Base {

	public static Properties properties = null;
	public static WebDriver driver = null;
	public String browser = null;
	public Log log = new Log();
	public static ExcelUtility excelUtility;
	String mode = null;
	String testdatapath = null;

	@BeforeSuite
	public void init() throws IOException {

		FileInputStream fis = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\resources\\Globaldata.properties"));
		properties = new Properties();
		properties.load(fis);
		// System.out.println(properties.getProperty("testdatapath"));
		testdatapath = System.getProperty("user.dir")+"\\testdata.xlsx";
		excelUtility = new ExcelUtility(testdatapath);
		// browser = properties.getProperty("browser");
//			System.out.println("Browser: "+ browser);
//			log.info("current browser: "+ browser);

	}

	public void loadWebBrowser() {

		browser = properties.getProperty("browser");
		mode = properties.getProperty("mode");
		System.out.println("Browser: " + browser);
		System.out.println("Mode: " + mode);
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (mode.equalsIgnoreCase("headless")) {
				options.addArguments("--headless");
			}

			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		log.info("url loaded successfully");

	}

	@AfterSuite
	public void teardown() {
		driver.close();
	}

}
