package PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(BasePage.class);

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }


}