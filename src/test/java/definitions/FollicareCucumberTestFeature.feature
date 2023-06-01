Feature: Model Functionality

  Scenario: Creating a User
    Given a user provides valid registration data
    When the user creates an account
    Then a new user record should be created


  Scenario: Updating User Profile
    Given a user provides valid profile data
    When the user updates their profile
    Then the profile information should be updated

  Scenario: Adding a Specialist to Favorites
    Given a user has a valid profile and a specialist exists
    When the user adds the specialist to their favorites
    Then the specialist should be added to the user's favorites list

  Scenario: Removing a Specialist from Favorites
    Given a user has a specialist in their favorites list
    When the user removes the specialist from their favorites
    Then the specialist should be removed from the user's favorites list