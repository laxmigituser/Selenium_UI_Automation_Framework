package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends BasePage{
    public ProductCatalogue(){
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.col-sm-10")
    public List<WebElement> products;

    By addToCartButton = By.xpath("//div[contains(@class,'col-sm-10')]//button[text() = ' Add To Cart']");
@FindBy(xpath = "(//button[contains(text(), 'Cart')])[1]")
public WebElement cartIcon;
    public void addProductToCart(String productName){
        for(WebElement product : products){
            if(getText(product.findElement(By.tagName("b"))).equalsIgnoreCase(productName)){
                clickElement(addToCartButton);
            }
        }
    }

    public void openCart(){
        click(cartIcon);
    }

}
