Feature: Product List and Sorting


  Scenario: Check in the product list displayed accordingly
    Given The user access the Swag Lab page
    And The user enter user and password
    When The user click on Login button
    Then The user can see the product list title
    And The picture, the product title are displayed
    Then The user can see also the price and the "Add to cart" button

  Scenario: Check sorting items by Name from Z to A
    Given The user access the Swag Lab page
    When The user enter user and password
    Then The user click on Login button
    And The user sort the product list by Name from Z to A
    Then The product list are filtered by "Name (Z to A)"

  Scenario: Check sorting items by Price descending
    Given The user access the Swag Lab page
    When The user enter user and password
    Then The user click on Login button
    And The user sort the product list by Price from high to low
    Then The product list are filtered by "Price (high to low)"