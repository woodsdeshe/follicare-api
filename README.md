# Follicare-API

## Table of Contents
- [Follicare Description](#follicare-description)
- [Tools and Technologies Used](#tools-and-technologies-used)
- [Test Folder Setup](#test-folder-setup)
- [Unsolved Problems or Major Hurdles](#unsolved-problems-or-major-hurdles)
- [User Stories](#user-stories)
- [ERD Diagram](#erd-diagram)
- [Planning Documentation](#planning-documentation)
- [Installation Instructions for Dependencies](#installation-instructions-for-dependencies)
- [API Endpoints](#api-endpoints)
- [Future Features](#future-features)
- [Documentation](#documentation)
- [Shout Outs](#shout-outs)

## Description
Follicare is a consultation app designed specifically for individuals facing hair disorders. The main focus of the app is to provide accessibility and support, particularly for minority communities, in effectively managing their hair disorders. With Follicare, users can create an account, log in, edit their profile details, add specialists to their favorites list, search for specialists, and access a knowledge base for information on their hair disorder.

## Tools and Technologies Used
 - **IDE**: IntelliJ is the integrated development environment for software development.
  - **Programming Language**: The API is developed using Java 17.
  - **Framework**: The API is built on Spring Boot version 2.7.8.
    - **Server**: The application runs on the Tomcat server.
  - **Project Management**: [GitHub Projects](https://github.com/users/woodsdeshe/projects/6) is utilized for project management and tracking progress.
  - **Documentation Tool**: [Google Docs](https://docs.google.com/document/d/1IrPEi7DRGvpivJOVLtRf7Ejdoql4ds-LKyS0UoeONZQ/edit?usp=sharing) is used for documenting daily stand-ups and stand-downs.
  - **Version Control**: GitHub is used for version control. The codebase can be found at [GitHub Repository](https://github.com/woodsdeshe/follicare-api).
  - **Entity Relationship Diagram (ERD)**: [Dbdiagram.io](https://dbdiagram.io/d/644ad886dca9fb07c42b4c62) is used to create the ERD for the database design.
  - **Database**: The [H2 Database Engine](https://www.geeksforgeeks.org/spring-boot-h2-database/) is used during development.
  - **Web Browser**: Google Chrome Browser was used to access the H2 Database Engine.
  - **Application Generator**: [Spring Initializer](https://start.spring.io/) is used to boostrap the project structure. The project is built using Maven.
     - **Packaging**: The spring boot application uses Jar packaging.
  - **API Testing**: [Postman](https://www.postman.com/) is used to test the API endpoints and manage the workspace.
  - **Markdown Table Generator**: The Markdown table generator available at [Tables Generator](https://www.tablesgenerator.com/markdown_tables) is used to create Markdown tables.
## Test Folder Setup
To set up the test folder in the project repository, follow these steps:
1. Create a test folder in the project repository.
2. Choose either MockMvc or Cucumber with Rest Assured for testing.
3. Add test files for all the endpoints in the test folder.

## Unsolved Problems or Major Hurdles
During the project, the following unsolved problems or major challenges were faced:
- Accuracy of tests: There were hurdles involving the accuracy of tests, as the previous system showed passing tests when they were not passing. Double-checking was required to validate the tests once a working path was completed.

## User Stories
User stories can be found in the [User Stories document](link-to-user-stories-document).

## ERD Diagram
The ERD diagram for Follicare can be accessed at [link-to-ERD-diagram](link-to-ERD-diagram).

## Planning Documentation
The detailed scope, schedule, and deliverables breakdown of the project can be found in the [GitHub Project](link-to-GitHub-project).

## Installation Instructions for Dependencies
To install and set up the dependencies required for the project, follow these instructions:
1. [Dependency 1]: [Installation instructions]
2. [Dependency 2]: [Installation instructions]
3. [Dependency 3]: [Installation instructions]
...

## API Endpoints
The following REST API endpoints are available in Follicare:
Sure! Here are the API endpoints in a table format:

| Request Type | URL                                          | Functionality                                                                                     | Access  |
|--------------|----------------------------------------------|--------------------------------------------------------------------------------------------------|---------|
| POST         | /auth/register                               | User creates an account                                                                           | Public  |
| POST         | /auth/login                                  | User logs into their account                                                                      | Public  |
| PUT          | /profile                                     | User updates their profile                                                                        | Private |
| GET          | /auth/users/{profileId}/favorites            | User gets a list of specialists in their favorites list                                           | Private |
| POST         | /auth/users/{profileId}/favorites            | User adds a specialist to their favorites list                                                    | Private |
| DELETE       | /auth/users/{profileId}/favorites/{specialistId} | User removes a specialist from their favorites list                                             | Private |
| GET          | /specialists                                 | User retrieves a list of all specialists                                                          | Public  |
| GET          | /specialists?hairDisorder={hairDisorder}     | User retrieves a list of specialists based on their specialty                                     | Public  |
| GET          | /specialists?zipcode={zipcode}               | User retrieves a list of specialists based on the zipcode                                         | Public  |
| GET          | /specialists?hairDisorder={hairDisorder}&zipcode={zipcode} | User retrieves a list of specialists based on their specialty and zipcode               | Public  |
| GET          | /resources/all                               | User retrieves a list of all topics                                                                | Public  |
| GET          | /resources?partialTitle={partialTitle}       | User retrieves a list of topics based on the partial topic title                                  | Public  |

Please note that the access level specifies whether the endpoint is public (accessible to all) or private (requires authentication).

Please refer to the API documentation for detailed information on request types and functionality.

## Future Features
Follicare aims to incorporate the following features in the future:
- Chatbot: Provide real-time assistance, answering frequently asked questions and offering guidance on hair disorder

 management.
- Calendar/Booking Function: Enable users to schedule appointments with specialists through an integrated calendar and booking system.
- Community Support: Allow users to post questions, provide insights, and engage in discussions related to hair disorders.

## Documentation
To learn more about specific topics related to Follicare, refer to the following documentation:
- [LIKE queries in Spring JPA Repository](documentation-link)
- [UriUtils.encode()](documentation-link)
- [StandardCharsets.UTF_8](documentation-link)
- [Data Transfer Object (DTO)](documentation-link)

## Shout Outs
Special thanks to Tobe for the valuable input and guidance throughout the development process, particularly in the implementation of all features before adding security.
