package Task5;

import BaseObjects.BaseTest;
import PageObject.Google.HomePage;
import PageObject.Google.SearchResultsPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task5 extends BaseTest {
    @BeforeTest
    public void preconditions() {
        get(HomePage.class)
                .open(context.getSuite().getParameter("url"))
                .sendString("iTechArt").enter();
    }

    @Test(priority = 2)
    public void pageResults() {
        get(SearchResultsPage.class)
                .checkSearchResults("iTechArt")
                .countAndTime()
                .clickOnPageNumber(2)
                .checkSearchResults("iTechArt");
    }
}
