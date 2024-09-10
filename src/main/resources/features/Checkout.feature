Feature: Checkout

  Scenario: Successful checkout with valid details
    Given the user is logged in with standard_user and secret_sauce
    When the user adds two products to cart
    And the user goes to the cart and proceeds to checkout
    When the user enters John as first name, Doe as last name, and 12345 as postal code
    And the user clicks continue
    Then the user should see the checkout overview page

  Scenario: Unsuccessful checkout due to missing first name
    Given the user is logged in with standard_user and secret_sauce
    When the user remove before adds two products to cart
    And the user goes to the cart and proceeds to checkout
    When the user enters empty the first name, Doe as last name, and 12345 as postal code
    And the user clicks continue
    Then the user should see an error message