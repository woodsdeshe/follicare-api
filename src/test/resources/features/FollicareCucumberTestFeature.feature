Feature: Model Functionality

  Scenario: User retrieves a list of all specialists
    Given there are multiple specialists in the system
    When the user requests the list of all specialists
    Then the system should return a list of all specialists

  Scenario: Retrieving Specialists by Specialty
    Given a specialist specializes in a specific specialty
    When the user searches for specialists by hair disorder
    Then a list of specialists specializing in that hair disorder should be returned

  Scenario: Retrieving Specialists by Zip Code
    Given a specialist in located in a specific zip code
    When the user searches for specialists by zip code
    Then a list of specialists located in that zip code should be returned

  Scenario: Retrieving Specialists by Hair Disorder and Zip Code
    Given a specialist specializes in a specific specialty and is located in a specific zip code
    When the user searches for specialists by specialty and zip code
    Then a list of specialists specializing in the specialty and located in the zip code should be returned

  Scenario: User retrieves a list of all resources
    Given there are multiple topics in the system
    When the user requests the list of all topics
    Then the system should return a list of all topics

  Scenario: Retrieving Resources by Topic Title
    Given a user provides a specific topic title
    When the user searches for resources by title
    Then a list of resources related to that title should be returned

