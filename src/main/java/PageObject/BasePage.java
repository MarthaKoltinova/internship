package PageObject;
import java.util.logging.Logger;

import org.apache.log4j.Level;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    //protected static Logger log = Logger.getLogger(BasePage.class.getName());
    protected BasePage(WebDriver driver) {
       // log.log(Level.DEBUG"");
        this.driver = driver;
    }


}