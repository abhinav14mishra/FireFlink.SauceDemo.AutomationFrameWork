package sauceDemo.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {

	@FindBy(xpath = "//a[@data-test='shopping-cart-link']")
	private WebElement cartIcon;

	@FindBy(id = "back-to-products")
	private WebElement backToProductsIcon;

	@FindBy(id = "remove")
	private WebElement removeBtn;

	public WebElement getBackToProductsIcon() {
		return backToProductsIcon;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}

	@FindBy(xpath = "//button[contains(.,'Add to cart')]")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//div[@data-test='inventory-item-name']")
	private WebElement productTitle;

	public WebElement getCartIcon() {
		return cartIcon;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getProductTitle() {
		return productTitle;
	}

	public InventoryItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void addToCart() {
		addToCartBtn.click();
	}

}
