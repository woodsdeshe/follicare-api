Feature: Model Functionality

  Scenario: Creating a User
    Given a user provides valid registration data
    When the user creates an account
    Then a new user record should be created

  Scenario: Updating User Profile
    Given a user provides valid profile data
    When the user updates their profile
    Then the profile information should be updated