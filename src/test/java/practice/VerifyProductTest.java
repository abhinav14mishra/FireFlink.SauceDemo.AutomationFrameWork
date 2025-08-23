package practice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import sauceDemo.genericUtilities.BaseClass;
import sauceDemo.genericUtilities.FileUtility;
import sauceDemo.objectRepository.CartPage;
import sauceDemo.objectRepository.InventoryItemPage;
import sauceDemo.objectRepository.InventoryPage;

public class VerifyProductTest extends BaseClass {

	@Test
	public void TC002() throws IOException {

		FileUtility fU = new FileUtility();

		InventoryPage iP = new InventoryPage(driver);
		iP.getBackPackLink().click();

		InventoryItemPage iIP = new InventoryItemPage(driver);
		iIP.addToCart();
		iIP.getCartIcon().click();

		CartPage cP = new CartPage(driver);
		String actual = cP.getProductTitle().getText();

		String expected = fU.readDataFromExcelFile("TC002", 4, 1);

		Assert.assertTrue(expected.contains(actual));
	}
}
