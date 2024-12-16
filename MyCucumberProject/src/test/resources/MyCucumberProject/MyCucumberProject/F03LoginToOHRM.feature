Feature: Validate login functionality on OHRM

  Background: 
    Given Launch Orange HRM

  Scenario: To validate login functionality with valid data
    When I enter valid user name
    When I enter valid password
    And I Click on Login button
    Then Dashboard page should display

  Scenario: To validate login functionality with invalid data
    When I Enter invalid user name
    When I Enter invalid password
    And Click on login button
    Then Error message should display
