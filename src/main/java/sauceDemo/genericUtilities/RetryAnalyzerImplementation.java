package sauceDemo.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This method provide implementation to IRetryAnalyzer
 * 
 * @author Abhinav Mishra
 */
public class RetryAnalyzerImplementation implements IRetryAnalyzer{

	int count = 0;
	int retryCount = 3;

	public boolean retry(ITestResult result) {
		while (count < retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
