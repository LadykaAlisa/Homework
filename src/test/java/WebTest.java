import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

//TODO: write test that will to go allo.ua, search for iphone 17
//TODO *: Assert that search has at least 3 results

public class WebTest {

    @Test
    public void webTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.allo.ua");

        WebElement searchInput = driver.findElement(By.id("search-form__input"));
        searchInput.sendKeys("IPhone 17");
        searchInput.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> searchResultsContainer = driver.findElements(
                By.cssSelector(".products-layout__container.products-layout--grid .product-card"));
        Assert.assertTrue(searchResultsContainer.size() >= 3, "searchResultsContainer has 3 elements" + searchResultsContainer.size());

        if (searchResultsContainer.size() >= 3) {
            System.out.println ("Успішно: знайдено " + searchResultsContainer.size() + " продуктів");
        } else {
            Assert.fail ("Помилка! Знайдено менше ніж 3 продукти");
        }
        driver.quit();
    }

    }

