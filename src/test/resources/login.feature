
@login
Feature: As a user I want to login to my account, so I can track my items
  Scenario: Register as new user
    Given I am on the longin page
    When I click new user button
    Then I am directed to the registration page

  #  Given I am on the registration page
  #  When I enter my details
  #  And click the register button
  #  Then I am not able to register without recapta
