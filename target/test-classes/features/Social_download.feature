@DailyCheck
@All

Feature: Social_download

  Scenario: Social_download_FB

    Given User go to 4shared
    And User go to search page
    And he searches for the "gta test.mp3" file
    When he found what he wants
    Then he go to D-one page of some file
    And he press Download button on D-one
    When he goes to D-two
    And press Free Download there
    Then One-click download popup should appear
    And he clicks on fb button
    And he login to fb
    When the timer stops counting
    Then the file starts downloading and user goes to D-three