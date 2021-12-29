Feature: add address


  Scenario Outline: user can add new address

    Given an open browser with "https://mystore-testlab.coderslab.pl"

    When  i click the button 'sign in'

    And i fill email and password fields "clovis_litt@gmail.com" "463900814"

    And i click the button 'add address'

    And i complete the form  "<alias>", "<address>", "<city>", <postal>, "<country>", <phone>

    And i click the 'save' button

    Then address should be created "<alias>", "<address>", "<city>", <postal>, "<country>", <phone>

    Examples:
      | alias         | address               | city          | postal | country        | phone        |
      | Norman        | 784 Norman Street     | Los Angeles   | 90008  | United Kingdom | 323-294-9793 |
      | TOD           | 4021 Timber Oak Drive | Pampa         | 79065  | United Kingdom | 806-228-9326 |
      | Oklahoma City | 3946 Ottis Street     | Oklahoma City | 73102  | United Kingdom | 405-278-2303 |