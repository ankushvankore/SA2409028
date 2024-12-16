Feature: Validate login on Practice Login Page

  Background: 
    Given Open Practice Automation page

  Scenario: To test login with valid data
    When Enter valid userName as "student" and Password as "Password123"
    And I Will Click on Login button
    Then Home page should display

  Scenario: To test login with invalid data
    When Enter invalid userName as "nagrag" and Password as "nagraj123"
    Then Click on Submit button
    Then I should get Error Message
