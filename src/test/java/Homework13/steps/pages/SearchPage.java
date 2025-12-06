package Homework13.steps.pages;


import Homework13.steps.elements.*;


public class SearchPage extends GeneralPageObject {


    public void searchFor(String text) {
        write(AlloPageElements.SEARCH_INPUT, text);
        click(AlloPageElements.SEARCH_BUTTON);
    }
}
