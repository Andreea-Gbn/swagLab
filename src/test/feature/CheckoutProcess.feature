Feature: Checkout Process

  Background:
    Given The user access the Swag Lab page
    When The user enter user and password
    And The user click on "Login" button

  Scenario: Verify that clicking the "Checkout" button redirects the user to the "Checkout: Your Information" page.
    Given The user is on Products page
    When The user add one product to the Shopping Cart
    Then The user click on Shopping Cart image
    When The user click on "Checkout" button
    Then The user can see the "Checkout: Your Information" page
    And The user can see specific page fields like firsName input, lastName input and Postal Code

  Scenario: Verify the checkout process
    Given The user is on Products page
    When The user add one product to the Shopping Cart
    Then The user click on Shopping Cart image
    When The user click on "Checkout" button
    And The user add input for First Name, Last Name and Postal Code
    And The user click on "Continue" button to submit the form
    Then The user can see the "Checkout: Overview" page

  Scenario Outline: Verify if error is displayed when submitting the form with missing required inputs
    Given The user is on Products page
    When The user add one product to the Shopping Cart
    Then The user click on Shopping Cart image
    When The user click on "Checkout" button
    And The user leave fields "<fields>" empty
    And The user click on "Continue" button to submit the form
    Then The user check if specific error "<error>" is displayed

    Examples:
      | fields          | error                          |
      | all             | Error: First Name is required  |
      | First Name      | Error: First Name is required  |
      | Last Name       | Error: Last Name is required   |
      | Zip/Postal Code | Error: Postal Code is required |

  Scenario: Verify if clicking the "Cancel" button on the "Checkout: Your Information" page redirects the user back to the shopping cart
    Given The user is on Products page
    When The user add one product to the Shopping Cart
    Then The user click on Shopping Cart image
    When The user click on "Checkout" button
    Then The user can see the "Checkout: Your Information" page
    When The user click on "Cancel" button
    Then The user can see the "Your Cart" page
    And The Your Cart page is displayed

  Scenario: Verify if "Checkout: Overview" page displays the order details
    Given The user is on Products page
    When The user add one product to the Shopping Cart
    Then The user click on Shopping Cart image
    When The user click on "Checkout" button
    And The user add input for First Name, Last Name and Postal Code
    And The user click on "Continue" button to submit the form
    Then The user can see the "Checkout: Overview" page
    And The user can see specific order details

  Scenario: Verify if clicking the "Cancel" button on the "Checkout: Overview" page redirects the user back to the product list page
    Given The user is on Products page
    When The user add one product to the Shopping Cart
    Then The user click on Shopping Cart image
    When The user click on "Checkout" button
    And The user add input for First Name, Last Name and Postal Code
    And The user click on "Continue" button to submit the form
    Then The user can see specific order details
    When The user click on "Cancel" button
    Then The user is on Products page

  Scenario: Verify if clicking the "Finish" button on the "Checkout: Overview" page redirects the user to the "Checkout: Complete" page
    Given The user is on Products page
    When The user add one product to the Shopping Cart
    Then The user click on Shopping Cart image
    When The user click on "Checkout" button
    And The user add input for First Name, Last Name and Postal Code
    And The user click on "Continue" button to submit the form
    Then The user can see specific order details
    When The user click on "Finish" button
    Then The user can see the "Checkout: Complete!" page
    And The user can see that Back Home button is displayed

  Scenario: Verify if clicking the "Back Home" button on the "Checkout: Complete" page redirects the user to the product list page
    Given The user is on Products page
    When The user add one product to the Shopping Cart
    Then The user click on Shopping Cart image
    When The user click on "Checkout" button
    And The user add input for First Name, Last Name and Postal Code
    And The user click on "Continue" button to submit the form
    Then The user can see specific order details
    When The user click on "Finish" button
    Then The user can see the "Checkout: Complete!" page
    When The user click on "Back Home" button
    Then The user is on Products page