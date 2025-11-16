package homework_pom;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    private By productList = By.cssSelector(".product-card");
    private By productName = By.cssSelector(".product-card__title");
    private By productPrice = By.cssSelector(".v-pb__cur");
    private By relativeScreenInfo = By.xpath(".//dt[contains(text(), 'Тип екрану')]/following-sibling::dd[1]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    public void waitForResults() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productList));
    }

    // --- Внутрішній клас для продукту ---
    public static class Product {
        private String name;
        private String price;
        private String screen;

        public Product(String name, String price, String screen) {
            this.name = name;
            this.price = price;
            this.screen = screen;
        }

        public String getName() { return name; }
        public String getPrice() { return price; }
        public String getScreen() { return screen; }
    }

    public List<Product> getProducts(int fromIndex, int toIndex) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productList));
        List<WebElement> products = driver.findElements(productList);
        int size = products.size();
        System.out.println("Found " + size + " results.");

        List<Product> productData = new ArrayList<>();

        for (int i = fromIndex - 1; i < toIndex && i < size; i++) {
            WebElement product = products.get(i);
            String name = product.findElement(productName).getText();
            String price = product.findElement(productPrice).getText();
            String screen = "N/A";

            try {
                actions.moveToElement(product).perform();
                WebElement screenElement = wait.until(
                        ExpectedConditions.presenceOfNestedElementLocatedBy(product, relativeScreenInfo)
                );
                screen = screenElement.getText();
            } catch (TimeoutException | NoSuchElementException e) {
                System.err.println("Помилка при отриманні екрану для товару " + (i + 1));
            }

            productData.add(new Product(name, price, screen));

            // Вивід у консоль
            System.out.println("Product " + (i + 1) + ":");
            System.out.println("  Name: " + name);
            System.out.println("  Price: " + price);
            System.out.println("  Screen: " + screen);
            System.out.println("-------------------------");
        }

        return productData;
    }
}
