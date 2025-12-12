
    package Homework12;

    import homework_pom.MainPage;
    import homework_pom.SearchResultsPage;
    import io.cucumber.testng.AbstractTestNGCucumberTests;
    import io.cucumber.testng.CucumberOptions;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.annotations.AfterSuite;
    import org.testng.annotations.BeforeSuite;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

    @CucumberOptions(
            features = "src/test/resources/features12",
            glue = "Homework12.steps",
            plugin = {"pretty", "json:target/cucumber-reports/cucumber12.json"}
    )
    public class CucumberRunner12 extends AbstractTestNGCucumberTests {
        public static Connection conn;
        public static Statement stmt;
        public static ChromeDriver driver;
        public static MainPage page;
        public static SearchResultsPage searchResultsPage;

        @BeforeSuite
        public void setUp() throws SQLException {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            page = new MainPage(driver);
            searchResultsPage = new SearchResultsPage(driver);
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=UTF-8", "root", "11111111");
            stmt = conn.createStatement();

        }

        @AfterSuite
        public void tearDown() throws SQLException {
            if (conn != null) conn.close();
            if (driver != null) driver.quit();
        }
    }


