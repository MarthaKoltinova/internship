package PageObject.Google;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage {
    private By resultStatus = By.id("result-stats");
    private By searchResults = By.xpath("//div[contains(@class, g)]//div[@data-hveid]//a/h3");

    private By buttonPageNumber(Integer number) {
        return By.linkText(number.toString());
    }

    public List<String> getSearchResults() {
        logger.debug("Get search results ");
        List<String> results = new ArrayList<>();
        driver.findElements(searchResults).forEach(element -> {
            String result = element.getText().toLowerCase();
            results.add(result);
        });
        return results;
    }

    public String getResultCount() {
        logger.debug("Get Result Count ");
        List<String> results = Arrays.asList(driver.findElement(resultStatus).getText().split("\\(")[0].split(" "));
        String result = results.stream()
                .filter(val -> results.indexOf(val) != 0 && results.indexOf(val) != 1)
                .collect(Collectors.joining());
        return result;
    }

    public String getResultTime() {
        logger.debug("Get result time ");
        String result = driver.findElement(resultStatus).getText().split("\\(")[1].replace(")", " ");
        return result;
    }

    public SearchResultsPage clickOnPageNumber(Integer number) {
        logger.debug("Click on page number " + number);
        driver.findElement(buttonPageNumber(number));
        return this;
    }

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
}
