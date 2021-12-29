Feature: add address


  Scenario Outline: user can add new address

    Given an open browser with https://mystore-testlab.coderslab.pl

    And registered user

    When  i click the button "sign in"

    And i fill email and password fields

    And i click the button "add address"

    And i complete the form  <alias>, <address>, <city>, <postal>, <country>, <phone>

    And i click the "save" button

    Then account should be created <alias>, <address>, <city>, <postal>, <country>, <phone>

    And close browser2

    Examples:
      | alias | address | city | postal | country | phone |
      |       |         |      |        |         |       |
      |       |         |      |        |         |       |
      |       |         |      |        |         |       |