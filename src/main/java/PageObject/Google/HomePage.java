package PageObject.Google;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By search = By.name("q");

    public HomePage open(String url) {
        driver.get(url);
        return this;
    }

    public HomePage sendString(String str) {
        driver.findElement(search).sendKeys(str);
        return this;
    }

    public HomePage enter() {
        driver.findElement(search).sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}

