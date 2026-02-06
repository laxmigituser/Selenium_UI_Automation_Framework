//package ui_tests;
//
//import base.TestBase;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import page_objects.LoginPage;
//
//import java.util.List;
//
//public class ErrorValidationTest extends TestBase {
//    @Test
//    public void invaliduserLogin(){
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.loginToApplication("mopuri123@gmail.com", "Dummy@1234");
//        String errorMessage = loginPage.getErrorMessage();
//        Assert.assertEquals(errorMessage, "Incorrect email or password.");
//    }
//
//    @Test
//    public void invalidProductValidation(){
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.loginToApplication("mopuri123@gmail.com", "Dummy@123");
//
//        ProductCatalogue cataloge = new ProductCatalogue(driver);
//        List<WebElement> prodList = cataloge.getProductDetails();
//        cataloge.addProductToCart("ADIDAS ORIGINAL");
//        cataloge.openCart();
//
//        CartPage cartPage = new CartPage(driver);
//        boolean itemFound = cartPage.verifyProductInCart("ADIDAS ORIGINAL123");
//        Assert.assertFalse(itemFound, "Product  found in cart");
//    }
//}
