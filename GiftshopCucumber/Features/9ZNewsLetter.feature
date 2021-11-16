Feature: Subscibe to newsletter
Scenario Outline: Newsletter
Given Open the URL in browser
When I Enter the "<Emailid>"
Then Navigate and quit

Examples:
|Emailid|
|s.pooja2399@gmail.com|

