package PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(BasePage.class);

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected BasePage click(By element) {
        logger.debug("Click on " + element);
        driver.findElement(element).click();
        return this;
    }

    protected void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}