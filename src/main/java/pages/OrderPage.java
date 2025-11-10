package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import utility.PageFunction;

public class OrderPage extends Base {

	@FindBy(css = "[placeholder *= Country]")
	private WebElement selectCountry;

	@FindBy(css = "button.ng-star-inserted span")
	private List<WebElement> countryList;

	public OrderPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectCountry(String country) {
		PageFunction.sendKeys(selectCountry,country);
		PageFunction.simplewait(1000);
		System.out.println("Size: " + countryList.size());
		for (WebElement cont : countryList) {
			if (cont.getText().contains(country)) {
				cont.click();
				System.out.println("Country true");
				log.info("country selected");
				break;
			}
		}

	}

}
