package PageObject.Onliner;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public By registration = By.linkText("Зарегистрироваться на Onlíner");
    private By title = By.cssSelector(".auth-form__title.auth-form__title_big.auth-form__title_condensed-default");
    private By email = By.xpath("//input[@type='email']");
    private By wrongEmail = By.xpath("//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']");
    private By password = By.xpath("//input[@type='password']");
    private By wrongPassword = By.xpath("//div[@class='auth-form__description auth-form__description_primary auth-form__description_tiny auth-form__description_condensed-other']");
    private By passwordRepeat = By.xpath("//*[@autocomplete='repeatPassword']//input");
    private By wrongRepeatPassword = By.xpath("//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToRegistration() {
        logger.debug("go to registration");
        click(registration);
        return this;
    }

    public LoginPage verifyTitle() {
        logger.debug("Verify title name");
        Assert.assertEquals(driver.findElement(title).getText(), "Регистрация");
        return this;
    }

    public LoginPage enterWrongEmail() {
        logger.debug("enter wrong email");
        click(email);
        driver.findElement(email).sendKeys("12345");
        logger.debug("hint incorrect email");
        Assert.assertTrue((driver.findElement(wrongEmail).isDisplayed()));
        return this;
    }

    public LoginPage enterWrongPassword() {
        logger.debug("enter wrong password");
        click(password);
        driver.findElement(password).sendKeys("1234");
        logger.debug("hint incorrect password");
        Assert.assertTrue((driver.findElement(wrongPassword).isDisplayed()));
        return this;
    }

    public LoginPage enterWrongRepeatPassword() {
        logger.debug("enter wrong repeat password");
        click(password);
        driver.findElement(password).sendKeys("123456789123");
        click(passwordRepeat);
        driver.findElement(passwordRepeat).sendKeys("113456789123");
        logger.debug("hint incorrect repeat password");
        Assert.assertTrue((driver.findElement(wrongRepeatPassword).isDisplayed()));
        return this;
    }
}
