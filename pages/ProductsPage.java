package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductsPage extends CommonMethods {
    WebDriver driver;
    WebDriverWait wdWait;


    public ProductsPage(WebDriver driver, WebDriverWait wdWait) {
        super(driver, wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    public void filterByName(String filterName){
        driver.findElement(By.xpath("//span[@class=\"plp-accordion-item-header__title\" and contains(text(), '" + filterName + "')]")).click();

    }

    public void filterByValue(String filterValue) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//span[@class=\"plp-checkbox__label\"  and contains(text(), '"+filterValue+"')]")));
    }

    public void filterByRadioButtonValue(String sortValue) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//span[@class=\"plp-radio-button__text\"  and contains(text(), '"+sortValue+"')]")));
    }

    public void filterByColor (String colorValue){
        driver.findElement(By.cssSelector("[name='"+colorValue+"']")).click();

    }

}

