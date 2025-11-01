package homework_pom;

//TODO: Make allo.ua page object:
//TODO: - go to store page
//TODO: - execute search
//TODO: - print device name, price and screen type (use hover to see it)
// by index in search results index 1-3

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {

        private final WebDriver driver;
        private final static String URL = "https://allo.ua/";
        private WebDriverWait wait;
        private By searchInput = By.id("search-form__input");
        private By searchButton = By.className("search-form__submit-button");

        public MainPage (WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }

        public void load() {
            driver.get(URL);
        }

        public void cookies () {
            List<WebElement> buttons = driver.findElements(
                    By.xpath("//button[contains(text(),'Прийняти') or contains(text(),'Accept') or contains(text(),'OK')]"));
            if (!buttons.isEmpty()) {
                WebElement acceptButton = buttons.get(0);
                if (acceptButton.isDisplayed() && acceptButton.isEnabled()) {
                    acceptButton.click();
                }
            }
        }
        public void search (String text) {
            wait.until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(text);
            driver.findElement(searchButton).click();
        }

    }

