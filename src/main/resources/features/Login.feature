Feature: Login on SauceDemo

  Scenario: Login with valid credentials and add products to cart
    Given the user is on the login page
    When User enters valid username and password for login
    And User clicks login button for login
    Then the user should see the products page

  Scenario: Login with invalid credentials
    Given the user is on the login page
    When User enters invalid username and valid password
    And User clicks login button for login
    Then User should see an error message for login

  Scenario: Unsuccessful login with invalid password
    Given the user is on the login page
    When User enters valid username and invalid password for login
    And User clicks login button for login
    Then User should see an error message for login

  Scenario: Unsuccessful login with empty username and password
    Given the user is on the login page
    When User enters empty username and empty password for login
    And User clicks login button for login
    Then User should see an error message for login