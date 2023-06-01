Feature: Model Functionality

  Scenario: Creating a User
    Given a user provides valid registration data
    When the user creates an account
    Then a new user record should be created