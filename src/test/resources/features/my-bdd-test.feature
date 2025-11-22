Feature: Search and save products

  Scenario: Search for iPhone and save results
    Given I open Allo website
    And I accept cookies
    When I search for "iPhone"
    Then search results should be visible
    And I save top 3 products to database
