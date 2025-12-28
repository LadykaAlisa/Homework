package Homework15;


import homework15.DBConnectionFactory;
import homework15.WebDriverFactory;
import homework_pom.MainPage;
import homework_pom.SearchResultsPage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;



@CucumberOptions(
        features = "src/test/resources/features13",
        glue = "Homework13.steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber15.html",
                "json:target/cucumber-reports/cucumber15.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class CucumberRunner15 extends AbstractTestNGCucumberTests {
    private final static WebDriverFactory driverFactory = new WebDriverFactory();
    private  final static DBConnectionFactory connectionFactory = new DBConnectionFactory();
    private WebDriver driver;
    private Connection conn;

    private MainPage page;
    private SearchResultsPage searchResultsPage;

    @BeforeSuite
    public void beforeSuite() throws SQLException, MalformedURLException {
        // WebDriver будет инициализирован в CucumberHooks
        // Эти переменные могут быть инициализированы позже, когда WebDriver будет готов
        driver = WebDriverFactory.getDriver();
        page = null;
        searchResultsPage = null;
        conn = connectionFactory.getConnection();


//        conn = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=UTF-8",
//                "root",
//                "11111111"
//        );
//        stmt = conn.createStatement();
    }

    @AfterSuite
    public void tearDown() {
        // WebDriver управляется CucumberHooks, поэтому здесь ничего не делаем
        // CucumberHooks.@After закроет браузер
    }
}


