package Homework13.steps.steps;


import Homework13.steps.elements.*;
import Homework13.steps.models.Product;
import Homework13.steps.pages.*;
import Homework13.steps.CucumberHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
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


    @Then("I collect {} from search results")
    public void collectProducts(String whatToCollect) {
        System.out.println("Collecting: " + whatToCollect);
        listPage.collectProducts();
    }


    @Then("I save collected product parameters to database")
    public void saveToDb() throws SQLException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
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
