@api
Feature: Sample API example

Scenario: Send API Request
Given a json request is set
When a POST request is sent
Then the status code is 200
And the response is valid