@tag
Feature: User Registration
  I want to be able to register on nopecommerce site

  @tag1
  Scenario Outline: User registration
    Given user on the home page
    When I click on register link 
    And I enter "<FirstName>","<LastName>","<DayofBirth>","<MonthofBirth>","<YearofBirth>","<mail>","<password>","<company>"
    And I click on register
    Then sucessful registring Msg is displayed
    And I click continue
    
    Given user on the home page
    When I click on log in Link 
    And I enter "<mail>","<password>"
    And I click on log in
    Then Myaccount link is displayed
    And I click logout
    
    Examples: 
  | FirstName | LastName | DayofBirth | MonthofBirth | YearofBirth | mail | password | company |
	| Max | Dobblin | 13 | June | 1989 | Testt@gmail.com | mypassworfd123 | teck |
	| Harry | Macw | 22 | June | 1989 | Testz@gmail.com | mypassworfd124 | teck |
    

    
    

  

    
