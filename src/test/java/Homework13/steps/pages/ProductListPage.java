package Homework13.steps.pages;


import Homework13.steps.elements.ProductElements;
import Homework13.steps.models.Product;
import Homework13.steps.elements.GeneralPageObject;
import org.openqa.selenium.*;
import java.util.*;


public class ProductListPage extends GeneralPageObject {


    public List<Product> collectProducts() {
        List<WebElement> cards = driver.findElements(ProductElements.PRODUCT_CARD.getLocator());
        List<Product> products = new ArrayList<>();


        for (WebElement card : cards) {
            String name = safeGet(card, ProductElements.NAME);
            String price = safeGet(card, ProductElements.PRICE);
            String screen = safeGet(card, ProductElements.SCREEN);


            products.add(new Product(name, price, screen));
        }
        return products;
    }


    private String safeGet(WebElement card, ProductElements el) {
        try { return card.findElement(el.getLocator()).getText(); }
        catch (Exception e) { return ""; }
    }
}
