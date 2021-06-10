Feature: Employee Search

  Background:
    And user is logged in with valid admin credentials
    And user navigates to employee list page

  @regression
  Scenario: Search employee by id
    Given user navigates to hrms
    When user enters valid employee id
    And  click on search button
    Then user see employee information is displayed

    @regression
    Scenario:
      Given user navigates to hrms
      When user enters valid employee name
      And  click on search button
      Then user see employee information is displayed
