package PageObject.Onliner;


import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CardPage extends BasePage {
    private By product = By.cssSelector(".cart-form__link.cart-form__link_primary.cart-form__link_base-alter");

    public CardPage(WebDriver driver) {
        super(driver);
    }

    public CardPage checkProduct() {
        logger.debug("Check that iteam is present in the page");
        Assert.assertTrue(driver.findElement(product).isDisplayed());
        return this;
    }
}
