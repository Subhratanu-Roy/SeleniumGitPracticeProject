package testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderPage;
import utility.DataProviders;
import utility.Listener;
import utility.PageFunction;

@Listeners(Listener.class)
public class TC_Login extends Base {

	LoginPage loginPage = null;
	HomePage homePage = null;
	CartPage cartPage = null;
	OrderPage orderPage = null;
	String username = null;
	String password = null;
	SoftAssert s = null;
	static int dataset = 0;
	boolean testfail = true;

//	@BeforeClass
//	public void setup() throws IOException {
//
//		loadWebBrowser();
//	
//	}

	@Test(dataProvider = "allData", dataProviderClass = DataProviders.class)
	public void login(String product_name, String country, String result) {
		try {
			System.out.println("Test case no: " + dataset + 1);
			loadWebBrowser();
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			s = new SoftAssert();
			loginPage = new LoginPage();
			homePage = loginPage.login(username, password);
			PageFunction.simplewait(3000);

			cartPage = homePage.addToCart(product_name);
			orderPage = cartPage.clickOnCheckout();
			orderPage.selectCountry(country);

			s.assertAll();
			testfail = false;
			log.info("Test is passed");
		} catch (Exception e) {
			log.warn("Test failed due to some exception");
			s.assertTrue(false);
			testfail = true;
			s.assertAll();
		}

	}

	@AfterMethod
	void writeInExcel() {
		if (testfail) {
			System.out.println("Test failed");
			excelUtility.setCellData("Data", dataset + 1, 2, "FAIL");
		} else {
			System.out.println("Test passed");
			excelUtility.setCellData("Data", dataset + 1, 2, "PASS");
		}
		dataset++;
		driver.close();
	}

	// @AfterClass
	void teardown2() {
		driver.quit();
	}

}
