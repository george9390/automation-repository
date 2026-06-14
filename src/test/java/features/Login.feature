
Feature: Login
        As a user I should able to login into my app
 
 @scenario1
 Scenario Outline:I login with valid credential
 		Given I navigate to "https://rahulshettyacademy.com/loginpagePractise/"
        And I enter <username> into username field
        When I click on submit button
        Then I should get logged-in
 Examples:
|username|
|rahulshettyacademy|