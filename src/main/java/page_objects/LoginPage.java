package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name = 'username']")
    public WebElement userName;
    @FindBy(xpath = "//input[@name = 'password']")
    public WebElement userPassword;
    @FindBy(xpath = "//div[@role='alert']//p[text()='Invalid credentials']")
    public WebElement invalidCredensErrorText;
    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement loginButton;

    public void navigateTLoginPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        waitForPageLoad();
    }

    public void loginToApplication(String username, String password){
        type(userName, username);
        type(userPassword, password);
        click(loginButton);
        waitForPageLoad();
    }
    public boolean isErrorVisible(){
       return elementVisible(invalidCredensErrorText);
    }
}
