package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebdriverListener implements WebDriverListener {

	@Override
	public void beforeGet(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		System.out.println("Before moving to url "+ url);
	}

	@Override
	public void afterGet(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		System.out.println("After moving to url " + url);
	}

}
