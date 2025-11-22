
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
            features = "src/test/resources/features",
            glue = "Homework12.steps",
            plugin = {"pretty"}
    )
    public class CucumberRunner extends AbstractTestNGCucumberTests {
        private Connection conn;
        private Statement stmt;
        private ChromeDriver driver;
        private MainPage page;
        private SearchResultsPage searchResultsPage;

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
    }


