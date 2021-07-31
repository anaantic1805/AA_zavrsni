package tests;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CartPage;
import pages.ProductsPage;

import java.io.IOException;


public class Firefox extends BaseTest {


    @BeforeMethod
    public void startTest() {
        init("FIREFOX", 30);
    }

    @AfterMethod
    public void quit() {
        tearDown();
    }

    @Test
    @TmsLink("FFl-123")
    @Issue("FFi-123")
    @Severity(SeverityLevel.MINOR)
    @Epic("FFe-011")
    @Feature("FFf-001")
    @Story("FFs-001")
    @Parameters({"subCategory1", "subCategory2", "subCategory3", "Sort", "Nacin", "Color", "Vrednost boje", "modalOfFilter", "addProduct"})
    public void ikeaTestiram(String subCategory1, String subCategory2, String subCategory3, String Sort, String odManjeKaVecoj, String Color, String VrednostBoje, String modalOfFilter, String addProduct) throws InterruptedException, IOException {
        driver.get("https://www.ikea.com/rs/sr");
        wdWait = new WebDriverWait(driver, 20);

        BasePage bp = new BasePage(driver, wdWait);
        ProductsPage productsPage = new ProductsPage(driver, wdWait);
        CartPage cartPage = new CartPage(driver, wdWait);

        bp.setCookiesAccept();
        bp.clickProductsMenu();
        Thread.sleep(3000);
        bp.selectSubCategory1(subCategory1);
        bp.selectSubCategory2(subCategory2);
        bp.selectSubCategory3(subCategory3);

        reportScreenshot("FF_Stolnjaci i nadstolnjaci1", "Pre filtracije");

        bp.selectFilter(modalOfFilter);

        productsPage.filterByName(Sort);
        productsPage.filterByRadioButtonValue(odManjeKaVecoj);
        Thread.sleep(2000);
        productsPage.filterByName(Color);
        productsPage.filterByColor(VrednostBoje);

        bp.choseViewFilterResults();

        reportScreenshot("FF_Stolnjaci i nadstolnjaci2", "Nakon filtracije");

        bp.selectAddToCart(addProduct);

        bp.clickMenu();
        bp.choseClickLogo();
        bp.choseViewCart();
        Thread.sleep(2000);

        reportScreenshot("FF_Korpa", "Provera korpe");

        Assert.assertTrue(cartPage.productDescription.get(0).getText().contains("Nadstolnjak"));
        Assert.assertTrue(cartPage.productDescription.get(1).getText().contains("crna"));

        String expectedValue = "1";
        String actualValue = cartPage.quantity.get(0).getText();
        Assert.assertEquals(actualValue, expectedValue);


    }
}

