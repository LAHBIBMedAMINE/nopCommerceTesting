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
Feature: Email a product to a friend
  I want to be able to send an email a product to a friend

  @tag1
  Scenario: As registred User Email a product to a friend
    Given I register on a website using fake account
    And As registered user I Login to my account
    When I search for Product
      | Apple MacBook Pro 13-inch |
    And I access to product details
      | Apple MacBook Pro 13-inch |
    When I click on Email to Friend
    And I fill the From
    And I send the email
    Then A sucess Msg is displayed
    And I logout

  @tag2
  Scenario: As Non registred User Email a product to a friend
    Given non registred user on the WebSite
    When I search for Product
      | Apple MacBook Pro 13-inch |
    And I access to product details
      | Apple MacBook Pro 13-inch |
    When I click on Email to Friend
    And I fill the From
    And I send the email
    Then A fail Msg is displayed
