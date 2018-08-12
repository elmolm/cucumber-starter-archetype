Feature: Search on duckduckgo 

Scenario: Search on duckduckgo with 
	Given I am on duckduckgo homepage 
	When I enter "elmland" as search phrase 
	And I press the search button 
	Then duckduckgo should show "https://elmland.blog/" in the result list on position 1 
