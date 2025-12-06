package Homework13.steps.elements;

import org.openqa.selenium.By;

public enum AlloPageElements implements ILocatable{
    SEARCH_INPUT(By.id("search-form__input")),
    ACCEPT_COOKIES(By.xpath("//button[contains(text(),'Разрешить') or contains(text(),'Accept') or contains(text(),'OK')]")),
    SEARCH_BUTTON(By.className("search-form__submit-button"));


    private final By locator;

    AlloPageElements(By locator) {
        this.locator = locator;
    }

    @Override
    public By getLocator() {
        return locator;
    }
}
