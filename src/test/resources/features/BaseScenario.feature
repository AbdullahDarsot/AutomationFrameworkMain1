@Chrome
Feature: BaseScenarios

  These scenarios can be used in any project

  Scenario: 01. Validate the title of a website
    Given a DuckDuckGo user is on the base page
    Then they see the page title contains "DuckDuckGo"