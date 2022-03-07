package Task7;

import BaseObjects.BaseTest;
import PageObject.Onliner.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task7 extends BaseTest {

    @Parameters("str")
    @Test(priority = 1)
    public void searchInCatalog() {
        logger.info("Test searchInCatalog started");
        get(HomePage.class)
                .open(property.getProperty("url"))
                .clickCatalog();
        get(CatalogPage.class)
                .clickOnMobileTabs();
        get(MobilePhonesPage.class)
                .verifyTitle()
                .clickOnCheckbox();
        //   .checkSearchResults(str);
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

    @Test(priority = 3)
    public void addItemToCart() {
        logger.info("Test addItemToCart  started");
        get(HomePage.class)
                .open(property.getProperty("url"))
                .clickCatalog();
        get(CatalogPage.class)
                .clickOnGamesTabs();
        get(GamingConsolesPage.class)
                .verifyTitle()
                .openAndAddToCard()
                .verifyText()
                .checkStatus()
                .goToCard();
        get(CardPage.class)
                .checkIteam();
        logger.info("Test addItemToCart finished");
    }
}

