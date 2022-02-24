package PageObject.Google;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage {
    private By resultStatus = By.id("result-stats");

    private By buttonPageNumber(Integer number) {
        return By.linkText(number.toString());
    }

    public SearchResultsPage checkSearchResults(String str) {
        driver.findElements(By.xpath("//div[contains(@class, g)]//div[@data-hveid]//a/h3")).forEach(element -> {
            String actual = element.getText().toLowerCase();
            String expected = str.toLowerCase();
            System.out.println("Check that " + expected + " contains in " + actual);
            Assert.assertTrue(actual.contains(expected), "Check that " + expected + " contains in " + actual);
        });
        return this;
    }

    public SearchResultsPage countAndTime() {
        System.out.println("Количество результатов поиска: ");
        List<String> results = Arrays.asList(driver.findElement(resultStatus).getText().split("\\(")[0].split(" "));
        String data = results.stream()
                .filter(val -> results.indexOf(val) != 0 && results.indexOf(val) != 1)
                .collect(Collectors.joining(" "));
        System.out.println(data);
        System.out.println("Время поиска результатов: ");
        System.out.println(driver.findElement(resultStatus).getText().split("\\(")[1].replace(")", " "));
        return this;
    }

    public SearchResultsPage clickOnPageNumber(Integer number) {
        driver.findElement(buttonPageNumber(number));
        return this;
    }

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
}
