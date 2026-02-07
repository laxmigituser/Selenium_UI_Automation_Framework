package ui_tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.DashboardPage;
import page_objects.LoginPage;

public class UserLoginLogOutTest extends TestBase {

    @Test
    public void loginLogoutFlow() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        loginPage.navigateTLoginPage();
        loginPage.loginToApplication("Admin", "admin123");
        String pageUrl = loginPage.getCurrentPageUrl();
        Assert.assertTrue(pageUrl.contains("/dashboard/index"), "page url does not include dashboard");
        dashboardPage.verifySidePanelOpened();
        dashboardPage.verifySidePanelMenuSelection("Dashboard");
        dashboardPage.logout();
        Assert.assertTrue(dashboardPage.getCurrentPageUrl().contains("/auth/login"), "page url does not include login");
    }

    @Test
    public void invalidUserLogin(){
        LoginPage loginPage = new LoginPage();
        loginPage.navigateTLoginPage();
        loginPage.loginToApplication("Admin", "admin1234");
        Assert.assertTrue(loginPage.isErrorVisible(), "Error message is not visible on page");
        Assert.assertTrue(loginPage.getCurrentPageUrl().contains("/auth/login"), "page url does not include login");
    }
}
