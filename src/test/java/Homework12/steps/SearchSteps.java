package Homework12.steps;

import homework_pom.MainPage;
import homework_pom.SearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SearchSteps {
    private MainPage page;
    private SearchResultsPage searchResultsPage;
    private Connection conn;

    @Given("I open Allo website")
    public void iOpenAlloWebsite() throws SQLException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "11111111"
        );
        page = new MainPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        page.load();
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
        page.cookies();
    }

    @When("I search for {string}")
    public void iSearchFor(String text) {
        page.search(text);  // використовується параметр з feature
    }

    @Then("search results should be visible")
    public void searchResultsBeVisible() {
        searchResultsPage.waitForResults();
    }

    @And("I save top 3 products to database")
    public void iSaveTop3ProductsToDatabase() {
        List<SearchResultsPage.Product> results = searchResultsPage.getProducts(1, 3);

        try (PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO devices (Name, Price, Screen) VALUES (?,?,?)"
        )) {
            for (SearchResultsPage.Product p : results) {
                preparedStatement.setString(1, p.getName());
                preparedStatement.setString(2, p.getPrice());
                preparedStatement.setString(3, p.getScreen());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

























//
//        public void testSqlWrite() throws SQLException {
//            page.load();
//            page.cookies();
//            page.search("IPhone");
//            searchResultsPage.waitForResults();
//            List<Product> results = searchResultsPage.getProducts(1, 3);
//            PreparedStatement preparedStatement = conn.prepareStatement(
//                    "INSERT INTO devices (Name, Price, Screen) VALUES (?,?,?)"
//            );
//
//            for (Product p : results) {
//                preparedStatement.setString(1, p.getName());
//                preparedStatement.setString(2, p.getPrice());
//                preparedStatement.setString(3, p.getScreen());
//                try {
//                    preparedStatement.execute();
//                } catch (SQLException e) {
//                    System.out.println("Failed to save in DB: " + p + " | Error: " + e.getMessage());
//                }
//            }
//        }


