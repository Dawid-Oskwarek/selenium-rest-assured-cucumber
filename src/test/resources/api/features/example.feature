@api
Feature: Sample API example

  Scenario: Send API Request
    Given a json request is set
    When a POST request is sent
    Then the status code is 201
    And the response is valid

  Scenario: Send API Request
    Given a json request is set
    When a POST request is sent using an API Client
    Then the status code for API Client response is 201
    And the response from API Client is valid