package Task5;

import BaseObjects.BaseTest;
import PageObject.Google.HomePage;
import PageObject.Google.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;

public class Task5 extends BaseTest {
   /* static Logger LOGGER;
    private static final java.util.logging.LogManager LogManager = ;

    static {
        try (FileInputStream ins = new FileInputStream("src/main/resources/log4j.properties")) {
            LogManager.getLogManager().readConfiguration(ins);
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }
    System.setErr(new PrintStream(new File("log.txt")));

    */

    @Parameters("searchValue")
    @Test(description = "enterValue", priority = 1)
    public void enterValue(String searchValue) {
        //LOGGER.info("Начало теста enterValue,открываем сайт и вводим ITechart");
        get(HomePage.class)
                .open(property.getProperty("url"))
                .sendString(searchValue)
                .enter();
       // LOGGER.info("Конец теста enterValue");
    }

    @Parameters({"searchValue", "resultCount"})
    @Test(priority = 2)
    public void pageResults(String searchValue, String resultCount) {
       // LOGGER.info("Начало теста pageResults,получаем результаты поиска и сравниваем их со словом ITechart");
        checkSearchResult(searchValue);
        int expectedResult = Integer.parseInt(resultCount);
        int actualResult = Integer.parseInt(get(SearchResultsPage.class).getResultCount());
        System.out.println("Check that actual " + actualResult + " less or equal than expected " + expectedResult);
        Assert.assertTrue(expectedResult <= actualResult);
        System.out.println(get(SearchResultsPage.class).getResultTime());
        get(SearchResultsPage.class)
                .clickOnPageNumber(2);
        checkSearchResult(searchValue);
       // LOGGER.info("Конец теста pageResults");
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