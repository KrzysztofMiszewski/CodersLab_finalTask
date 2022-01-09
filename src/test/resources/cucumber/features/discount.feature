@DiscountTest
Feature: Discount

  Scenario Outline: discount is correctly displayed on product page

    Given i am on product page https://mystore-testlab.coderslab.pl
    Then discount is correctly displayed
