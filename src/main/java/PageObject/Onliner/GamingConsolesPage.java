package PageObject.Onliner;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GamingConsolesPage extends BasePage {
    private By title = By.tagName("h1");
    private By firstIteam = By.cssSelector(".schema-product__title");
    private By addToCard = By.cssSelector(".button-style.button-style_base-alter.button-style_primary.product-aside__button.product-aside__button_narrow.product-aside__button_cart.button-style_expletive");
    private By inCard = By.cssSelector(".button-style.button-style_base-alter.button-style_primary.product-aside__button.product-aside__button_narrow.product-aside__button_cart.button-style_primary");
    private By continueShopping = By.cssSelector(".button-style.button-style_auxiliary.button-style_base-alter.product-recommended__button.helpers_hide_tablet");
    private By goToCard = By.cssSelector(".button-style.button-style_another.button-style_base-alter.product-recommended__button");
    private By card = By.cssSelector(".auth-bar__item.auth-bar__item--cart");

    public GamingConsolesPage(WebDriver driver) {
        super(driver);
    }

    public GamingConsolesPage verifyTitle() {
        logger.debug("Verify title name");
        Assert.assertEquals(driver.findElement(title).getText(), "Игровые приставки");
        return this;
    }

    public GamingConsolesPage AddToCard() {
        logger.debug("Click on the first iteam");
        click(firstIteam);
        logger.debug("add to card iteam");
        click(addToCard);
        return this;
    }

    public GamingConsolesPage verifyText() {
        logger.debug("Verify text name");
        Assert.assertEquals(driver.findElement(continueShopping).getText(), "Продолжить покупки");
        Assert.assertEquals(driver.findElement(goToCard).getText(), "Перейти в корзину");
        return this;
    }

    public GamingConsolesPage checkStatus() {
        logger.debug("Check that status of the button is changed");
        click(continueShopping);
        Assert.assertEquals(driver.findElement(inCard).getText(), "В корзине");
        return this;
    }

    public GamingConsolesPage goToCard() {
        logger.debug("go to card");
        click(card);
        return this;
    }

}
