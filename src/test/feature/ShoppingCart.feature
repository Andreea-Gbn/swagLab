Feature: Shopping Cart Operations

  Background:
    Given The user access the Swag Lab page
    When The user enter user and password
    And The user click on "Login" button

  Scenario: Check if shopping cart button redirects to "Your Cart" page
    Given The user is on Products page
    When The user click on Shopping Cart image
    Then The Your Cart page is displayed

  Scenario: Check if number badge increase when adding multiple products to cart
    Given The user is on Products page
    When The user add one product to the Shopping Cart
    Then The the Shopping Cart contains 1 product
    When The user add to chart two products
    Then The the Shopping Cart contains 3 product

  Scenario: Check if number badge decreases when adding multiple products to cart
    Given The user is on Products page
    When The user add one product to the Shopping Cart
    And The user add to chart two products
    Then The the Shopping Cart contains 3 product
    When The user removes "one" product from chart
    Then The the Shopping Cart contains 2 product
    When The user removes "second" product from chart
    Then The the Shopping Cart contains 1 product

  Scenario: Check product details on "Your Cart" page
    Given The user is on Products page
    When The user add to chart two products
    And The user click on Shopping Cart image
    Then The user can check if "quantity" is displayed
    And The user can check if "title" is displayed
    And The user can check if "description" is displayed
    And The user can check if "price" is displayed