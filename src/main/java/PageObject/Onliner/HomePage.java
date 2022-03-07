package PageObject.Onliner;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public By catalog = By.linkText("Каталог");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(String url) {
        logger.debug("Open page " + url);
        driver.get(url);
        return this;
    }

    public HomePage clickCatalog() {
        logger.debug("Open catalog ");
        click(catalog);
        return this;
    }
}
