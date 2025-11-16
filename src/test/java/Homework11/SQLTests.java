package Homework11;

//TODO: Use session 8 code as is, and make it save
// DeviceName, DevicePrice and DeviceScreenSize to DB

import homework_pom.MainPage;
import homework_pom.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import homework_pom.SearchResultsPage.Product;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

public class SQLTests {
    private WebDriver driver;
    private MainPage page;
    private SearchResultsPage searchResultsPage;
    private Connection conn;
    private Statement stmt;

    @BeforeSuite
    public void setUp() throws SQLException {
        driver = new ChromeDriver();
        page = new MainPage(driver);
        driver.manage().window().maximize();
        searchResultsPage = new SearchResultsPage(driver);
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=UTF-8", "root", "11111111");
        stmt = conn.createStatement();

    }

    @AfterSuite
    public void tearDown() throws SQLException {
        conn.close();
        driver.quit();
    }

    @Test
    public void testSqlWrite() throws SQLException {
        page.load();
        page.cookies();
        page.search("IPhone");
        searchResultsPage.waitForResults();
        List<Product> results = searchResultsPage.getProducts(1, 3);
        PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO devices (Name, Price, Screen) VALUES (?,?,?)"
        );

        for (Product p : results) {
            preparedStatement.setString(1, p.getName());
            preparedStatement.setString(2, p.getPrice());
            preparedStatement.setString(3, p.getScreen());
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failed to save in DB: " + p + " | Error: " + e.getMessage());
            }
        }
    }
}
