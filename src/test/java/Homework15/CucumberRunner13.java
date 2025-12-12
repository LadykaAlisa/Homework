package Homework15;


import homework_pom.MainPage;
import homework_pom.SearchResultsPage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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
public class CucumberRunner13 extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    private MainPage page;
    private SearchResultsPage searchResultsPage;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        // WebDriver будет инициализирован в CucumberHooks
        // Эти переменные могут быть инициализированы позже, когда WebDriver будет готов
        page = null;
        searchResultsPage = null;


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


