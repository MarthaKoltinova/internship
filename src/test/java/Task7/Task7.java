package Task7;

import BaseObjects.BaseTest;
import PageObject.Onliner.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task7 extends BaseTest {

    @Parameters({"str"})
    @Test(priority = 1)
    public void searchInCatalog() {
        logger.info("Test searchInCatalog started");
        get(HomePage.class)
                .open(property.getProperty("url"))
                .clickCatalog();
        get(CatalogPage.class)
                .clickOnTabCatagory(Catagory.ELECTRONICS)
                .clickOnMobileTab()
                .clickOnIteam(Iteam.PHONES);
        get(MobilePhonesPage.class)
                .verifyTitle()
                .clickOnCheckbox(CheckboxIteams.HONOR)
                .sleep(10);
        get(MobilePhonesPage.class)
                .checkSearchResults("HONOR");
        logger.info("Test searchInCatalog finished");
    }

    @Test(priority = 2)
    public void calalogSearch() {
        logger.info("Test pageResults  started");
        get(MobilePhonesPage.class)
                .clickOnEntrance();
        get(LoginPage.class)
                .goToRegistration()
                .verifyTitle()
                .enterWrongEmail()
                .enterWrongPassword()
                .enterWrongRepeatPassword();
        logger.info("Test calalogSearch finished");
    }

    @Parameters({"subCatagoryName", "catagoryName", "iteamName"})
    @Test(priority = 3)
    public void addItemToCart() {
        logger.info("Test addItemToCart  started");
        get(HomePage.class)
                .open(property.getProperty("url"))
                .clickCatalog();
        get(CatalogPage.class)
                .clickOnTabCatagory(Catagory.ELECTRONICS)
                .clickOnTabSubCatagory(SubCatagory.VIDEO_GAMES)
                .clickOnIteam(Iteam.GAMING_CONSOLS);
        get(GamingConsolesPage.class)
                .verifyTitle()
                .AddToCard()
                .verifyText()
                .checkStatus()
                .goToCard();
        get(CardPage.class)
                .checkProduct();
        logger.info("Test addItemToCart finished");
    }
}

