@DailyCheck
@All

Feature: Advertisment

  Scenario: Ads is present for free user
    Given User go to 4shared
    When User go to search page
    Then there should be ads on search
    When he go to D-one page of some file
    Then there should be ads
    When he press Download button on D-one
    And he goes to D-two
    Then there should be ads