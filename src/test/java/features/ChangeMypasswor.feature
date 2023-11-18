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
Feature: Change my password
  i want to be able to change my Password

  @tag1
  Scenario: Change my password
    Given User on the home page
    When I Click on register link 
    And I fill the registration form
    And I click on register and continue
    When I click on login Link 
    And I log to my new account
    When I click on myAccount
    And I click on change my password
    And I fill the form of changing passwor
    Then Msg your Password was changed
    When I logOut
    And I log in with my new password
    Then I successfuly login 
    And I logOut

 