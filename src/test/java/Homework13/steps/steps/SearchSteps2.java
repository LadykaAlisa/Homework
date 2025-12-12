package Homework13.steps.steps;


import Homework13.steps.elements.*;
import Homework13.steps.models.Product;
import Homework13.steps.pages.*;
import Homework13.steps.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;


public class SearchSteps2 {


    WebDriver driver = CucumberHooks.driver;
    SearchPage searchPage = new SearchPage();
    ProductListPage listPage = new ProductListPage();
    List<Product> collected = new ArrayList<>();
    private Connection conn;


    @Given("I open website")
    public void openWebsite() {
        driver.get("https://allo.ua/");
    }

    @Given("I open Allo website")
    public void openAlloWebsite() {
        driver.get("https://allo.ua/");
    }


    @Given("I click {word} if present")
    public void clickIfPresent(String elementName) {
        AlloPageElements element = AlloPageElements.valueOf(elementName);
        if (searchPage.isPresent(element)) searchPage.click(element);
    }


    @Given("I click element {word}")
    public void clickElement(String elementName) {
        AlloPageElements element = AlloPageElements.valueOf(elementName);
        searchPage.click(element);
    }


    @Given("I set element {word} value to {string}")
    public void setElementValue(String elementName, String value) {
        AlloPageElements element = AlloPageElements.valueOf(elementName);
        searchPage.write(element, value);
    }

    @Given("I accept cookies")
    public void acceptCookies() {
        AlloPageElements element = AlloPageElements.ACCEPT_COOKIES;
        if (searchPage.isPresent(element)) searchPage.click(element);
    }

    @When("I search for {string}")
    public void searchFor(String searchTerm) {
        searchPage.searchFor(searchTerm);
    }

    @Then("search results should be visible")
    public void searchResultsVisible() {
        List<WebElement> cards = driver.findElements(ProductElements.PRODUCT_CARD.getLocator());
        if (cards.isEmpty()) {
            throw new RuntimeException("No search results found");
        }
    }

    @And("I save top {int} products to database")
    public void saveTopProductsToDatabase(int count) throws SQLException {
        List<Product> products = listPage.collectProducts();
        collected.addAll(products.subList(0, Math.min(count, products.size())));
        saveToDb();
    }


    @Then("I collect {} from search results")
    public void collectProducts(String whatToCollect) {
        System.out.println("Collecting: " + whatToCollect);
        collected = listPage.collectProducts();
    }


    @Given("I extract PRODUCT_CARD parameters {string}")
    public void i_extract_product_card_parameters(String parameters) {
        System.out.println("Extracting parameters: " + parameters);
        // Parameters are already extracted during collectProducts()
        // This step is for logging/documentation purposes
    }


    @Given("I save collected PRODUCT_CARD parameters {string} to database")
    public void i_save_collected_product_card_parameters_to_database(String parameters) throws SQLException {
        System.out.println("Saving parameters to database: " + parameters);
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "11111111");
        
        // Save the collected products to database
        for (Product product : collected) {
            try {
                var stmt = conn.prepareStatement(
                    "INSERT INTO devices (Name, Price, Screen) VALUES (?,?,?)"
                );
                stmt.setString(1, product.getName());
                stmt.setString(2, product.getPrice());
                stmt.setString(3, product.getScreen());
                stmt.execute();
            } catch (SQLException e) {
                System.out.println("Failed to save in DB: " + product + " | Error: " + e.getMessage());
            }
        }
    }


    @Then("I save collected product parameters to database")
    public void saveToDb() throws SQLException {
        // Используем уже существующий WebDriver из CucumberHooks
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "11111111");
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
