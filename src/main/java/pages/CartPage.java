package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import utility.PageFunction;

public class CartPage extends Base{
	
	@FindBy(xpath = "//button[text()='Checkout']")
	private WebElement checkOutbtn;

	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderPage clickOnCheckout() {
		PageFunction.simplewait(2000);
		checkOutbtn.click();
		return new OrderPage();
	}
	
}
