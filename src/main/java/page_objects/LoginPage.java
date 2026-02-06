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

    @FindBy(css = "input#userEmail")
    public WebElement userEmail;
    @FindBy(css = "input#userPassword")
    public WebElement userPassword;
    @FindBy(css = "input#login")
    public WebElement loginButton;
    @FindBy(css = "[class*='flyInOut']")
    public WebElement errorMessage;

    public void navigateTLoginPage(){
        driver.get("https://rahulshettyacademy.com/client");
    }

    public void loginToApplication(String username, String password){
        type(userEmail, username);
        type(userPassword, password);
        click(loginButton);
    }
    public String getErrorMessage(){
        return getText(errorMessage);
    }
}
