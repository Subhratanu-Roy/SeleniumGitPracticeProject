package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({utility.Listener2.class})
public class TestDemo {

	@BeforeTest
	void setup() {
		System.out.println("Before test");
	}
	
	@Test
	void tc() {
		System.out.println("TestDemo class");

	}
	@Test
	void tc2() {
		System.out.println("TestDemo class2");

	}
}
