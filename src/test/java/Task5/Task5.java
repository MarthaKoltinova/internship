package Task5;

import BaseObjects.BaseTest;
import PageObject.Google.HomePage;
import PageObject.Google.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task5 extends BaseTest {

    @Parameters("searchValue")
    @Test(description = "enterValue", priority = 1)
    public void enterValue(String searchValue) {
        logger.info("Test enterValue  started");
        get(HomePage.class)
                .open(property.getProperty("url"))
                .sendString(searchValue)
                .enter();
        logger.info("Test enterValue finished");
    }

    @Parameters({"searchValue", "resultCount"})
    @Test(priority = 2)
    public void pageResults(String searchValue, String resultCount) {
        logger.info("Test pageResults  started");
        checkSearchResult(searchValue);
        int expectedResult = Integer.parseInt(resultCount);
        int actualResult = Integer.parseInt(get(SearchResultsPage.class).getResultCount());
        logger.info("Check that actual " + actualResult + " less or equal than expected " + expectedResult);
        Assert.assertTrue(expectedResult <= actualResult);
        logger.info(get(SearchResultsPage.class).getResultTime());
        get(SearchResultsPage.class)
                .clickOnPageNumber(2);
        checkSearchResult(searchValue);
        logger.info("Test pageResults finished");
    }

    private void checkSearchResult(String searchValue) {
        for (String searchResults : get(SearchResultsPage.class).getSearchResults()) {
            searchValue = searchValue.toLowerCase();
            searchResults = searchResults.toLowerCase();
            Assert.assertTrue(searchResults.contains(searchValue), "Check that " + searchValue + " contains in " + searchResults);
            logger.info("Check that " + searchValue + " contains in " + searchResults);
        }
    }
}