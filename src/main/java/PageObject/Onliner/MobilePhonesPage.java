package PageObject.Onliner;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MobilePhonesPage extends BasePage {
    private By title = By.tagName("h1");
    private By results = By.xpath("//div[contains(@class, g)]//a[@class='js-product-title-link']");
    private By entrance = By.cssSelector(".auth-bar__item.auth-bar__item--text");

    public MobilePhonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void sleep(long seconds) {
        super.sleep(seconds);
    }

    public MobilePhonesPage verifyTitle() {
        logger.debug("Verify title name");
        Assert.assertEquals(driver.findElement(title).getText(), "Мобильные телефоны");
        return this;
    }

    public MobilePhonesPage clickOnCheckbox(CheckboxIteams checkboxIteams) {
        logger.debug("Click on checkbox");
        driver.findElement(By.xpath(checkboxIteams.getCheckboxIteams())).click();
        return this;
    }

    public MobilePhonesPage clickOnEntrance() {
        logger.debug("Click on tab entrance ");
        driver.findElement(entrance).click();
        return this;
    }

    public MobilePhonesPage checkSearchResults(String str) {
        driver.findElements(results).forEach(element -> {
            String actual = element.getText();
            String expected = str;
            logger.info("Check that " + expected + " contains in " + actual);
            Assert.assertTrue(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
        return this;
    }

}