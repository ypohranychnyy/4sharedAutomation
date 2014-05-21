@DailyCheck
@All

Feature: Search

  Scenario: Confirm that the search results are present
    Given User go to 4shared
    When User go to search page
    Then there should be some results
