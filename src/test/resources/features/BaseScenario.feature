@Chrome
Feature: BaseScenarios

  Scenario: Login
    Given the user is logged in


  Scenario: Log Out
    Given the user is logged in
    Then the user clicks log out

  Scenario: Create Board
    Given the user is logged in
    When the user clicks create board
    Then a new board is opened