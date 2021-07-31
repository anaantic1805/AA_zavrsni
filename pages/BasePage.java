package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage extends CommonMethods{
    WebDriver driver;
    WebDriverWait wdWait;


    public BasePage(WebDriver driver, WebDriverWait wdWait) {
        super(driver, wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".banner-actions-container #onetrust-accept-btn-handler")
    WebElement cookiesAccept;
    @FindBy(xpath = "//div[@class = \"hnf-header__container hnf-page-container__main\"]//a[@href = \"https://www.ikea.com/rs/sr/cat/proizvodi-products/\" and @class = \"hnf-link\" and @data-index=\"0\"]")
    WebElement products;
    @FindBy (css = ".hnf-menu--more")
    WebElement more;
    @FindBy (xpath = "//div/nav[@class = \"hnf-menu__nav2\"]")
    List<WebElement> subCategory1;
    @FindBy (xpath = "//nav[@class=\"hnf-menu__nav3\"]")
    List<WebElement> subCategory2;
    @FindBy (xpath = "//span[@class=\"vn__nav__title\"]")
    List <WebElement>  subCategory3;
    @FindBy (xpath = "//span[@class=\"vn__nav__title\"]")
    List<WebElement> getSubCategory3a;
    @FindBy (css = ".plp-toggle-button.plp-toggle-button--transparent-active.plp-toggle-button--transparent.plp-filter-information__button")
    WebElement viewAsProduct;
    @FindBy (xpath = "//div[@class = \"plp-overflow-carousel__content\"]/button/span")
    WebElement choseFilter;
    @FindBy (css = ".plp-btn.plp-btn--small.plp-btn--primary")
    WebElement viewFilterResults;
    @FindBy (xpath = "//button[@class=\"range-revamp-btn range-revamp-btn--small range-revamp-btn--icon-emphasised range-revamp-product-compact__add-to-cart-button\"]")
    WebElement addToCart;
    @FindBy (xpath = "//div[@class=\"hnf-page-container__aside\"]//button[@title=\"Meni\"]")
    WebElement menu;
    @FindBy (xpath = "//div[@class=\"hnf-menu__logo\"]/a")
    WebElement clickLogo;
    @FindBy (xpath = "//span[@class=\"hnf-btn__inner js-shopping-cart-icon\"]")
    WebElement viewCart;

    public void setCookiesAccept() throws InterruptedException {
        clickElement(cookiesAccept);
    }

    public void clickProductsMenu() throws InterruptedException {
        clickElement(products);

    }

    public void clickMore() throws InterruptedException {
        clickElement(more);
    }

    public void selectSubCategory1 (String subNameCategory1) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//ul[@class = \"hnf-menu__nav2__main\"]/li/a[contains(text(),'"+subNameCategory1+"')]")));
    }

    public void selectSubCategory2 (String subNameCategory2) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//nav[@class=\"hnf-menu__nav3\"]/ul/li/a[contains(text(), '"+subNameCategory2+"')]")));
    }

    public void selectSubCategory3 (String subNameCategory3) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//span[@class=\"vn__nav__title\" and contains(text(), '"+subNameCategory3+"')]")));
    }

    public void selectViewAsProduct () throws InterruptedException {
        clickElement(viewAsProduct);
    }

    public void selectFilter(String modalOfFilter) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//div[@class = \"plp-overflow-carousel__content\"]/button/span[contains(text(), '"+modalOfFilter+"')]")));
    }

    public  void choseViewFilterResults () throws InterruptedException {
        clickElement(viewFilterResults);
    }

    public void selectAddToCart (String productName) throws InterruptedException {
        driver.findElement(By.xpath("//div[@class=\"range-revamp-product-compact__bottom-wrapper\"]//a[contains(@href, '"+productName+"')]/..//button[@class=\"range-revamp-btn range-revamp-btn--small range-revamp-btn--icon-emphasised range-revamp-product-compact__add-to-cart-button\"]")).click();

    }

    public void clickMenu () {
        menu.click();
    }

    public void choseClickLogo(){
        clickLogo.click();
    }
    public void choseViewCart(){
        viewCart.click();
    }

}
