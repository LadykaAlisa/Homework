package homework_pom;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

import java.time.Duration;

    public class SearchResultsPage {

        private final WebDriver driver;
        private final WebDriverWait wait;
        private final Actions actions;

        private By productList = By.cssSelector(".product-card");
        private By productName = By.cssSelector(".product-card__title");
        private By productPrice = By.cssSelector(".v-pb__cur");
        private By screenInfo = By.cssSelector(".product-card__specs");

        public SearchResultsPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            this.actions = new Actions(driver);
            driver.manage().window().maximize();
        }

        public void waitForResults() {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productList));
        }

        public void printProducts(int fromIndex, int toIndex) {
            List<WebElement> products = driver.findElements(productList);
            int size = products.size();
            System.out.println("Found " + size + " results.");

            for (int i = fromIndex - 1; i < toIndex && i < size; i++) {
                WebElement product = products.get(i);

                String name = product.findElement(productName).getText();
                String price = product.findElement(productPrice).getText();

                actions.moveToElement(product).perform();


                System.out.println("Product " + (i + 1) + ":");
                System.out.println("  Name: " + name);
                System.out.println("  Price: " + price);
                System.out.println("  Screen: " + screenInfo);
                System.out.println("-------------------------");
            }
        }
    }