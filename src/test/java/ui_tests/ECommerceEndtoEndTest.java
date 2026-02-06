package ui_tests;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LoginPage;
import page_objects.ProductCatalogue;

import java.util.List;

public class ECommerceEndtoEndTest extends TestBase {

    @Test
    public void testPurchaseFlow() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateTLoginPage();
        loginPage.loginToApplication("mopuri123@gmail.com", "Dummy@123");
        ProductCatalogue cataloge = new ProductCatalogue();
//        List<WebElement> prodList = cataloge.getProductDetails();
        cataloge.addProductToCart("ADIDAS ORIGINAL");
        cataloge.openCart();
Thread.sleep(4000);
//        CartPage cartPage = new CartPage(driver);
//        boolean itemFound = cartPage.verifyProductInCart("ADIDAS ORIGINAL");
//        Assert.assertTrue(itemFound, "Product not found in cart");
//        cartPage.navigateToCheckout();
//
//        CheckoutPage checkoutPage = new CheckoutPage(driver);
//        checkoutPage.selectCountry("india");
//        checkoutPage.waitForElementToBeVisible(checkoutPage.successMessage);
//        Assert.assertEquals(driver.findElement(checkoutPage.successMessage).getText(), "THANKYOU FOR THE ORDER.", "Success message not matching");
//        Thread.sleep(4000);

    }
}
