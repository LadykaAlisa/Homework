package Homework13.steps.elements;

import org.openqa.selenium.By;

public enum ProductElements implements ILocatable {
    PRODUCT_CARD(By.cssSelector(".product-card")),
    NAME(By.cssSelector(".product-card__title")),
    PRICE(By.cssSelector(".v-pb__cur")),
    SCREEN(By.xpath(".//dt[contains(text(), 'Тип екрану')]/following-sibling::dd[1]"));

    private final By locator;

    ProductElements(By locator) {
        this.locator = locator;
    }

    @Override
    public By getLocator() {
        return locator;
    }
}
