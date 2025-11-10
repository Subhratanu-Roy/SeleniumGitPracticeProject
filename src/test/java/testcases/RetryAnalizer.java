package testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalizer implements IRetryAnalyzer {

	int retryNo = 0;
	int maxRetry = 2;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub

		while (retryNo < maxRetry) {
			retryNo++;
			System.out.println(retryNo);
			return true;
		}
		return false;
	}

}
