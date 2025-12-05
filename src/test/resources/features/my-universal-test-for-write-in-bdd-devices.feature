Feature: Search and save products

  Scenario: Search for iPhone and save results
    Given I open Allo website
    Given I click ACCEPT_COOKIES if present
    Given I click SEARCH_INPUT
    Given  I set element SEARCH_INPUT value to "Java"
    Given  I click SEARCH_BUTTON
    And I save top 3 products to database



