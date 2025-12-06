package Homework13;

import homework_pom.MainPage;
import homework_pom.SearchResultsPage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Homework13.steps",
        plugin = {"pretty"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    private MainPage page;
    private SearchResultsPage searchResultsPage;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new MainPage(driver);
        searchResultsPage = new SearchResultsPage(driver);

//        conn = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=UTF-8",
//                "root",
//                "11111111"
//        );
//        stmt = conn.createStatement();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}


