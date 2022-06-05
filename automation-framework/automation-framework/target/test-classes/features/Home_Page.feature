@home-page

Feature: Home Page

  Scenario: Validate that Footer is shown
    Given I access the home Page
    And I click on the Cookie Acceptance
    And I click on the search button
    And I write automation to search field
    And I search results are listed on the page
    And I click on the first of the results
    And I verify testing and automation page opened
    And I scroll down to the bottom of the page
    Then I verify obss footer
