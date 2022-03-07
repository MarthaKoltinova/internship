package PageObject.Onliner;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends BasePage {
    private By electronics = By.xpath("//*[@class='catalog-navigation-classifier__item-title']//*[text()='Электроника']");
    private By videoGames = By.xpath("//*[@class='catalog-navigation-list__aside-item']//*[text()=' Видеоигры ']");
    private By mobilePhones = By.className("catalog-navigation-list__aside-title");
    private By phones = By.className("catalog-navigation-list__dropdown-title");
    private By gamingConsoles = By.xpath("//*[@class='catalog-navigation-list__dropdown-data']//*[text()=' Игровые приставки ']");

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public CatalogPage clickOnMobileTabs() {
        logger.debug("Click on tab electronics");
        click(electronics);
        logger.debug("Click on tab mobile phones");
        click(mobilePhones);
        logger.debug("Click on tab phones");
        click(phones);
        return this;
    }

    public CatalogPage clickOnGamesTabs() {
        logger.debug("Click on tab electronics");
        click(electronics);
        logger.debug("Click on tab video games");
        click(videoGames);
        logger.debug("Click on tab gaming consoles");
        click(gamingConsoles);
        return this;
    }
}

