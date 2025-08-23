package sauceDemo.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(xpath = "//button[contains(.,'Remove')]")
	private WebElement removeBtn;

	@FindBy(id = "continue-shopping")
	private WebElement continueShoppingBtn;
	
	@FindBy(xpath = "//div[@data-test='inventory-item-name']")
	private WebElement productTitle;

	public WebElement getProductTitle() {
		return productTitle;
	}

	@FindBy(id = "checkout")
	private WebElement checkoutBtn;

	public WebElement getRemoveBtn() {
		return removeBtn;
	}

	public WebElement getContinueShoppingBtn() {
		return continueShoppingBtn;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
