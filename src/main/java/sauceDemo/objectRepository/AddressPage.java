package sauceDemo.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {

	@FindBy(id = "first-name")
	private WebElement firstNameTF;

	@FindBy(id = "last-name")
	private WebElement lastNameTF;

	@FindBy(id = "postal-code")
	private WebElement postalCodeTF;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	@FindBy(id = "cancel")
	private WebElement cancelBtn;

	public WebElement getFirstNameTF() {
		return firstNameTF;
	}

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getPostalCodeTF() {
		return postalCodeTF;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void fillAddress(String fName, String lName, String postalCode) {
		firstNameTF.sendKeys(fName);
		lastNameTF.sendKeys(lName);
		postalCodeTF.sendKeys(postalCode);
		continueBtn.click();
	}

}
