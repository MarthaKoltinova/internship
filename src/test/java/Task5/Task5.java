package Task5;

import BaseObjects.BaseTest;
import PageObject.Google.HomePage;
import PageObject.Google.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task5 extends BaseTest {

    @Parameters("searchValue")
    @Test(priority = 1)
    public void preconditions(String searchValue) {
        get(HomePage.class)
                .open(property.getProperty("url"))
                .sendString(searchValue)
                .enter();
    }

    @Parameters({"searchValue", "resultCount"})
    @Test(priority = 2)
    public void pageResults(String searchValue, String resultCount) {
        checkSearchResult(searchValue);
        int expectedResult = Integer.parseInt(resultCount);
        int actualResult = Integer.parseInt(get(SearchResultsPage.class).getResultCount());
        System.out.println("Check that actual " + actualResult + " less or equal than expected " + expectedResult);
        Assert.assertTrue(expectedResult <= actualResult);
        System.out.println(get(SearchResultsPage.class).getResultTime());
        get(SearchResultsPage.class)
                .clickOnPageNumber(2);
        checkSearchResult(searchValue);
    }

    private void checkSearchResult(String searchValue) {
        for (String searchResults : get(SearchResultsPage.class).getSearchResults()) {
            searchValue = searchValue.toLowerCase();
            searchResults = searchResults.toLowerCase();
            Assert.assertTrue(searchResults.contains(searchValue), "Check that " + searchValue + " contains in " + searchResults);
            System.out.println("Check that " + searchValue + " contains in " + searchResults);
        }
    }
}