package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends BasePage{
    public DashboardPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//nav[@aria-label='Sidepanel']")
    public WebElement sidePanel;
    @FindBy(xpath = "//li[contains(@class,'userdropdown')]")
    public WebElement userDropdown;
    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu')]//li//a[text() = 'Logout']")
    public WebElement logoutButton;

    public boolean verifySidePanelOpened(){
        return elementVisible(sidePanel);
    }
    public boolean verifySidePanelMenuSelection(String menuItem){
        return driver.findElement(By.xpath("//span[text()='"+menuItem+"']/parent :: a"))
                .getDomAttribute("class").contains("active");
    }
    public void logout(){
        click(userDropdown);
        click(logoutButton);
        waitForPageLoad();
    }

}
