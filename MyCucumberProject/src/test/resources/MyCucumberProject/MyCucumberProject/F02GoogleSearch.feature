Feature: Validate Google Search

  Scenario: To validate search functionality on Google
    Given Open Google Application
    When Enter some text in search box
    And Hit Enter
    Then A valid search result should display
