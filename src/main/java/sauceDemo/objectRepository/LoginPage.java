package sauceDemo.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "user-name")
	private WebElement usernameTF;

	@FindBy(id = "password")
	private WebElement passwordTF;

	@FindBy(id = "login-button")
	private WebElement loginBtn;

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginSauceDemo(String username, String password) {
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginBtn.click();
	}

}
