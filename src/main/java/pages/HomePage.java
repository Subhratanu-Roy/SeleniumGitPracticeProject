package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import utility.Log;
import utility.PageFunction;

public class HomePage extends Base {

	@FindBy(css = "#products .card")
	private List<WebElement> products;

	@FindBy(xpath = "//li //button[contains(text(),'Cart')]")
	private WebElement cartBtn;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public CartPage addToCart(String productname) {
		System.out.println("Enter into add to cart");
		for (WebElement product : products) {
			String pname = product.findElement(By.cssSelector("b")).getText();
			System.out.println("Pname: " + pname);
			if (pname.equalsIgnoreCase(productname)) {
				log.info("Product found");
				product.findElement(By.cssSelector(".card-body button:nth-child(4)")).click();
				
				break;
			}
		}
		PageFunction.click(driver, cartBtn);
		return new CartPage();
		// log.warn("product not found!!");

	}

}
