package Task3;

import BaseObjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static javax.swing.UIManager.put;

public class Task3 extends BaseTest {

    @BeforeTest
    public void setUp() {
        driver.get(context.getSuite().getParameter("url"));


    }

    @Test
    public void onliner() {
        driver.findElement(By.linkText("Автобарахолка")).click();
        driver.findElement(By.cssSelector("._u.js-currency-amount")).click();
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        System.out.println(driver.findElement(By.partialLinkText("Клевер")).getText());
        driver.findElement(By.name("amount-in")).sendKeys("0");
        WebElement currency = driver.findElement(By.id("currency-in"));
        Select selectCurrency = new Select(currency);
        selectCurrency.selectByIndex(2);
        driver.findElement(By.className("state-2")).click();
        List<String> headers = new ArrayList<String>() {{
            driver.findElements(By.xpath("//*[@class='b-currency-table']/thead/tr/th[not(@class = 'th-last')]")).forEach(data -> add(data.getText()));
        }};
        Map<String, List<String>> mapData = new HashMap<String, List<String>>() {{
            for (int index = 0; index < headers.size(); index++) {
                put(headers.get(index), driver.findElements(By.xpath("//tbody//td//table//tbody//td[" + (index + 1) + "]/p[1]")).stream().map(WebElement::getText).collect(Collectors.toList()));
            }
        }};
        System.out.println(mapData);

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
