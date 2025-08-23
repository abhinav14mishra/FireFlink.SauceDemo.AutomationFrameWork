package sauceDemo.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;

	@FindBy(id = "react-burger-cross-btn")
	private WebElement menuCrossBtn;

	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutBtn;

	@FindBy(id = "reset_sidebar_link")
	private WebElement resetBtn;

	@FindBy(xpath = "//a[@data-test='shopping-cart-link']")
	private WebElement cartIcon;

	@FindBy(xpath = "//select[@data-test='product-sort-container']")
	private WebElement filterBtn;

	@FindBy(xpath = "//button[contains(.,'Add to cart')]")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//div[@data-test='inventory-item-name' and contains(.,'Back')]")
	private WebElement backPackLink;

	@FindBy(xpath = "//div[@data-test='inventory-item-name' and contains(.,'Bike Light')]")
	private WebElement bikeLightLink;

	@FindBy(xpath = "//div[@data-test='inventory-item-name' and contains(.,'Bolt T-Shirt')]")
	private WebElement tshirtLink;

	@FindBy(xpath = "//div[@data-test='inventory-item-name' and contains(.,'Jacket')]")
	private WebElement jacketLink;

	@FindBy(xpath = "//div[@data-test='inventory-item-name' and contains(.,'One Sie')]")
	private WebElement oneSieLink;

	@FindBy(xpath = "//div[@data-test='inventory-item-name' and contains(.,'T-Shirt (Red)')]")
	private WebElement redTshirtLink;

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getMenuCrossBtn() {
		return menuCrossBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getResetBtn() {
		return resetBtn;
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}

	public WebElement getFilterBtn() {
		return filterBtn;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getBackPackLink() {
		return backPackLink;
	}

	public WebElement getBikeLightLink() {
		return bikeLightLink;
	}

	public WebElement getTshirtLink() {
		return tshirtLink;
	}

	public WebElement getJacketLink() {
		return jacketLink;
	}

	public WebElement getOneSieLink() {
		return oneSieLink;
	}

	public WebElement getRedTshirtLink() {
		return redTshirtLink;
	}

	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void logout() {
		menuBtn.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logoutBtn.click();
	}
}
