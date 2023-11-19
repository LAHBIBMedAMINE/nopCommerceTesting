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
Feature: End to End Purshase
  I want to login, search for product, choose 2 product to purhcase, select shipment options (3), select payment options
  download the order and logout

  @tag1
  Scenario Outline: End to End Purshase
  	Given I register on a website using fake account
    And As registered user I Login to my account
    When I search for First available "<First_product>"
    And I add First products to cart
    When I search for Second available "<Second_product>"
    And I add Second products to cart
    When I proceed to my shopping cart "<First_product>" "<Second_product>"
    And I check the agree of terms and proceed to pay
    And I fill the adress form
    And I check ship to same adress option
    And I choose the shipment_Option "<shipment_Option>"
    And I choose the payment_Option "<payment_Option>"
    Then I validate the puchase
    And I download the order
    And I log Out

    Examples: 
      | First_product             | Second_product                    | shipment_Option  | payment_Option         |
      | Apple MacBook Pro 13-inch | HTC One M8 Android L 5.0 Lollipop | shippingoption_0 | Paybycreditordebitcard |
      | Apple MacBook Pro 13-inch | HTC One M8 Android L 5.0 Lollipop | shippingoption_1 | Paybycheque            |
      | Apple MacBook Pro 13-inch | HTC One M8 Android L 5.0 Lollipop | shippingoption_2 | Paybycheque            |
