package Homework13.steps.models;


public class Product {
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