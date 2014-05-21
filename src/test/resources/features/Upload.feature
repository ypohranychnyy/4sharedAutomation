@DailyCheck
@All
@Upload

Feature: Upload

  Scenario: User can upload a file
    Given User go to 4shared
    And User logs in from main with correct credentials "test2@deng.4shared.com" and "1"
    When he uploads some file
    Then the file should be present in account
    But We need to delete that file
