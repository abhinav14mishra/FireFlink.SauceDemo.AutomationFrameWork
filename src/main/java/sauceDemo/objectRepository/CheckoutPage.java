package sauceDemo.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	@FindBy(id = "finish")
	private WebElement finishBtn;

	@FindBy(id = "cancel")
	private WebElement cancelBtn;
	
	public WebElement getFinishBtn() {
		return finishBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
