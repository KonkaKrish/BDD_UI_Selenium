Feature: Your Store Testing Cases

Scenario: Verify Error Message

	Given user is on home Page
	When open browser
	Then add new item <TestCaseName> and <Expected>
	
	Examples:
	|TestCaseName|Expected|
	|Verify Login Error - TC001|Warning: No match for E-Mail Address and/or Password.|
	
Scenario: Verify Side Links

	Given user is at home Page
	When Get Side Limks
	Then Validate side Links <CartInfo> and <Expected>
	
	Examples:
	|CartInfo|Expected|
	|Verify Cart Details - TC002|Login|
	