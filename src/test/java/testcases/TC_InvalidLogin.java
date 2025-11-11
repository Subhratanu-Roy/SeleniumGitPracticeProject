package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;

public class TC_InvalidLogin extends Base {

	LoginPage obj_loginPage = null;

	@Test
	void tc_invalidLogin() {

		loadWebBrowser();
		String username = "testinvalidlogin@mail.com";
		String password = "test122345";
		String actualErrMsg = "Incorrect email or password.";
		obj_loginPage = new LoginPage();
		obj_loginPage.login(username, password);
		System.out.println(obj_loginPage.getErrorMsg());
		Assert.assertEquals(obj_loginPage.getErrorMsg(), actualErrMsg);

	}

}
