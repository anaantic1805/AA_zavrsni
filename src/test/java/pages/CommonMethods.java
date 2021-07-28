package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
    WebDriver driver;
    WebDriverWait wdWait;

    public CommonMethods(WebDriver driver,WebDriverWait wdWait ){
        this.driver = driver;
        this.wdWait = wdWait;
    }


    public void setAttributeValue(WebElement element, String attribute, String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",
                element, attribute, value
        );
    }
    public void clickElement(WebElement element) throws InterruptedException {
        //wdWait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
      try {
          element.click();
      } catch (StaleElementReferenceException e){
          Thread.sleep(2000);
        element.click();
     }
    }
    public void typeText(WebElement element, String value){
        // wdWait.until(ExpectedConditions.visibilityOf(element));
        // wdWait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(value);
    }
    public String getTextFromElement(WebElement element){
        wdWait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public String getTextFromElementIfTextPresent(WebElement element, String value){
        wdWait.until(ExpectedConditions.visibilityOf(element));
        wdWait.until(ExpectedConditions.textToBePresentInElement(element, value));
        return element.getText();
    }
    public void selectElement(WebElement element, String text){
        // wdWait.until(ExpectedConditions.elementToBeClickable(element));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    public void selectElement(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    public void selectElementByValue(WebElement element, String text){
        Select select = new Select(element);
        select.selectByValue(text);
    }





}
