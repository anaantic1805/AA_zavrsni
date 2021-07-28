package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ProductsPage;

public class Chrome extends BaseTest {
    @BeforeMethod
    public void startTest() {
        init("CHROME", 30);
    }

    @AfterMethod
    public void quit() {
        tearDown();
    }

    @Test
    @Parameters({"subCategory1", "subCategory2", "subCategory3", "Sort", "Nacin", "Color", "Vrednost boje", "modalOfFilter"})
    public void ikeaTestiram(String subCategory1, String subCategory2, String subCategory3, String Sort, String odManjeKaVecoj, String Color, String VrednostBoje, String modalOfFilter) throws InterruptedException {
        driver.get("https://www.ikea.com/rs/sr");
        wdWait = new WebDriverWait(driver, 20);

        BasePage bp = new BasePage(driver, wdWait);
        ProductsPage productsPage = new ProductsPage(driver, wdWait);

        bp.setCookiesAccept();
        bp.clickProductsMenu();
        bp.selectSubCategory1(subCategory1);
        bp.selectSubCategory2(subCategory2);
        bp.selectSubCategory3(subCategory3);
        bp.selectFilter(modalOfFilter);

        productsPage.filterByName(Sort);
        productsPage.filterByRadioButtonValue(odManjeKaVecoj);
        productsPage.filterByName(Color);
        productsPage.filterByColor(VrednostBoje);

        bp.choseViewFilterResults();


 }
}


