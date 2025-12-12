Feature: Search and save products to database

  Scenario: Search for iPhone and save results to database
       Given I open website
       Given I click ACCEPT_COOKIES if present
       Given I click element SEARCH_INPUT
       Given I set element SEARCH_INPUT value to "Asus"
       Given I click element SEARCH_BUTTON
       Given I click ACCEPT_COOKIES if present
       Given I collect PRODUCT_CARD from search results
       Given I extract PRODUCT_CARD parameters "Name, Price, Screen"
       Given I save collected PRODUCT_CARD parameters "Name, Price, Screen" to database





