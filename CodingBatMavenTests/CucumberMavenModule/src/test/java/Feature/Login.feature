Feature: Check login

  Scenario: Login with correct username
    Given I navigate to login page
    And I enter username "username" and password "password"
    And I click login page
    Then I should see user page