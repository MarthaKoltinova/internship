package PageObject.Onliner;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends BasePage {
    private By mobilePhones = By.className("catalog-navigation-list__aside-title");

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public CatalogPage clickOnTabCatagory(Catagory catagory) {
        logger.debug("Click on catagory tab");
        driver.findElement(By.xpath(catagory.getCatagory())).click();
        return this;
    }

    public CatalogPage clickOnTabSubCatagory(SubCatagory subCatagory) {
        logger.debug("Click on sub catagory tab");
        driver.findElement(By.xpath(subCatagory.getSubCatagory())).click();
        return this;
    }

    public CatalogPage clickOnMobileTab() {
        logger.debug("Click on tab mobile phones");
        click(mobilePhones);
        return this;
    }

    public CatalogPage clickOnIteam(Iteam iteam) {
        logger.debug("Click on iteam");
        driver.findElement(By.xpath(iteam.getIteam())).click();
        return this;
    }


}

