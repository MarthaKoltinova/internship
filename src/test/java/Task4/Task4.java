package Task4;

import BaseObjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task4 extends BaseTest {
    @BeforeTest
    public void setUp() {
        driver.get(context.getSuite().getParameter("url"));
    }

    @Test
    public void google() {
        String str = "iTechArt";
        driver.findElement(By.name("q")).sendKeys(str);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        checkSearchResults(str);
        System.out.println("Количество результатов и время поиска: ");
        System.out.println(driver.findElement(By.id("result-stats")).getText());
        driver.findElement(By.linkText("2")).click();
        checkSearchResults(str);
    }

    public void checkSearchResults(String str) {
        driver.findElements(By.xpath("//div[contains(@class, g)]//div[@data-hveid]//a/h3")).forEach(element -> {
            String actual = element.getText().toLowerCase();
            String expected = str.toLowerCase();
            System.out.println("Check that " + expected + " contains in " + actual);
            Assert.assertTrue(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
