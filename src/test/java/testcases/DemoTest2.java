package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

class DemoTest2 {

	@BeforeClass
	void setup() {
		System.out.println("Before class");
	}

	@Test
	void tc1() {
		System.out.println("Demotest2 class");

	}

}
