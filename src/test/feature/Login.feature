Feature: Login Functionality

  Scenario: Check if user can see Swag Lag login page
    Given The user access the Swag Lab page
    And The Swag Lab title is displayed
    When The the user can see the username and password fields
    And User can click on input fields
    Then The user can see the login button

  Scenario: User successfully login into Swag Lab
    Given The user access the Swag Lab page
    When The user enter user and password
    And The user click on Login button
    Then The user can see the Swan Lab Home Page

  Scenario Outline: Check sign in with invalid inputs
    Given The user access the Swag Lab page
    When The user enter user "<user>" and password "<password>"
    And The user click on Login button
    Then The user can see error "<error>"

    Examples:
      | user          | password     | error                                                                     |
      | standard_user | secret_sauc  | Epic sadface: Username and password do not match any user in this service |
      | standard_us   | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | standard_user |              | Epic sadface: Password is required                                        |
      |               | secret_sauce | Epic sadface: Username is required                                        |
      |               | secret_sauce | Epic sadface: Username is required                                        |