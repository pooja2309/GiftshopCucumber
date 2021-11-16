Feature: Login
Scenario Outline: Login
Given The landing page is open fetch driver
When I click on Signin
Then Navigate to the page and enter "<emailid>" and "<password>"


Examples:
|emailid|		|password|
|s.pooja2309@gmail.com|		|password1|
