package homework_pom;

//TODO: Make allo.ua page object:
//TODO: - go to store page
//TODO: - execute search
//TODO: - print device name, price and screen type (use hover to see it)
// by index in search results index 1-3

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class WebTests {

    private WebDriver driver;
    private MainPage page;
    private SearchResultsPage searchResultsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        page = new MainPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void Search () {
        page.load();
        page.cookies();
        page.search("Xiaomi 15T");
        searchResultsPage.waitForResults();
        searchResultsPage.printProducts(1, 3);



    }
}




