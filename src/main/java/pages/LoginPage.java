package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import utility.PageFunction;

public class LoginPage extends Base {

	@FindBy(id = "userEmail")
	private WebElement userEmail;

	@FindBy(id = "userPassword")
	private WebElement userPassword;

	@FindBy(id = "login")
	private WebElement login;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String username, String password) {
		PageFunction.sendKeys(userEmail, username);
		PageFunction.sendKeys(userPassword, password);
		PageFunction.click(driver, login);
		return new HomePage();

	}

}
