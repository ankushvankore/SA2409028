#Demo for data driven testing in Cucumber
Feature: Validate login functionality on ExpandTesting

  Scenario Outline: To validate login functionality using data driven testing
    Given Launch ExpandTesting using URL "https://practice.expandtesting.com/login"
    When I Enter username as "<UserName>" and password as "<Password>"
    And Click on Login button for verify
    Then Login should successful

    Examples: 
      | UserName | Password             |
      | sourabh  | sourabh123           |
      | practice | SuperSecretPassword! |
      | basav    | basav123             |
      | practice | SuperSecretPassword! |
      | chetan   | chetan123            |
