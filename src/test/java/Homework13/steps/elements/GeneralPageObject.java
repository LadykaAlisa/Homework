package Homework13.steps.elements;


import Homework13.steps.CucumberHooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class GeneralPageObject {


    protected WebDriver driver = CucumberHooks.driver;
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public WebElement waitFor(ILocatable element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element.getLocator()));
    }


    public void click(ILocatable element) {
        waitFor(element).click();
    }


    public void write(ILocatable element, String text) {
        WebElement el = waitFor(element);
        el.clear();
        el.sendKeys(text);
    }


    public boolean isPresent(ILocatable element) {
        try {
            driver.findElement(element.getLocator());
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

