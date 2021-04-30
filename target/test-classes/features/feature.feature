#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Create a  user
  I want Create a  user

  @tag1
  Scenario Outline: Create a user
    Given I want to access the page
    Then I select the button Sing In
    Then I write
     |email|mail11@mail.com|
     |First name|Anyelo|
     |Last name|Pineda|
     |Password|Admin2021|
     |company|Company|
     |address1|Company|
     |City|Bogota|
     |postal|00000|
     |phone|7777|
     |Adres|Main|
