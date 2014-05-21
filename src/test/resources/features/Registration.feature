
@All

Feature: Registration

  Scenario: User can register new account with correct credentials
    Given fake email site
    When User enter correct data into registration form
    And he submit it
    Then the second step of registration should appear
    And he have to verify his email
    And the third step of registration should appear
    And User enters account
    Then he delete his account