@CheckoutTest
Feature: Checkout

  Scenario Outline: user can pick up products in store and pay by check

    Given an open browser with "https://mystore-testlab.coderslab.pl" CheckoutTest
    And a logged user easter1980@gmail.com QI286196
    When i add Hummingbird Printed Sweater <size> x <number> to shopping cart
    And i proceed to checkout
    And i pick address, pick up in-store, pay by check and agree to terms
    And i click order
    Then i make screenshot
    And i check if order is on order list

    Examples:
      | size | number |
      | M    | 5      |