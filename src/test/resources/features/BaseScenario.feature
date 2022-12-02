@Chrome
Feature: BaseScenarios

  These scenarios can be used in any project

  Scenario: 01. Validate the title of a website
    Given a DuckDuckGo user is on the base page
    Then they see the page title contains "DuckDuckGo"

  Scenario: 02. Validate the Url of the website
    Given a DuckDuckGo user is on the base page
    Then they see the page Url contains "https://start.duckduckgo.com/"

  Scenario: 03. Validate the PageSource string on the website
    Given a DuckDuckGo user is on the base page
    Then they see "DuckDuckGo" in the PageSource

  Scenario: 04. Validate existence of multiple texts in PageSource
    Given a DuckDuckGo user is on the base page
    Then they see
      | DuckDuckGo    |
      | Privacy |
      | description     |