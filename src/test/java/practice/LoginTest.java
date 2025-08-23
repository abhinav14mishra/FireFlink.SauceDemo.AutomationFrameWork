package practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import sauceDemo.genericUtilities.BaseClass;
import sauceDemo.genericUtilities.ListenersImplementation;

@Listeners(ListenersImplementation.class)
public class LoginTest extends BaseClass{

	@Test
	public void loginToApp() {
		System.out.println("==========This is TC_ID_001==========");
	}

}
