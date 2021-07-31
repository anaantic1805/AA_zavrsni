package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends CommonMethods {
    WebDriver driver;
    WebDriverWait wdWait;

    public CartPage(WebDriver driver, WebDriverWait wdWait) {
        super(driver, wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//li[@itemprop=\"description\"]//span")
    public List<WebElement> productDescription;
    @FindBy(xpath = "//div[@class=\"cart-ingka-quantity-dropdown\"]//option")
    public List<WebElement> quantity;
}
