package Homework13.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CucumberHooks {
    public static WebDriver driver;


    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @After
    public void teardown() {
        if (driver != null) driver.quit();
    }
}
