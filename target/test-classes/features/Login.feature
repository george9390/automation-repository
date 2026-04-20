@scenario1


Feature: Login
        As a user I should able to login into my app
 
 Scenario: I login with valid credential
 		Given I navigate to "https://rahulshettyacademy.com/loginpagePractise/"
        And I enter "rahulshettyacademy" into username field
        When I click on submit button
        Then I should get logged-in