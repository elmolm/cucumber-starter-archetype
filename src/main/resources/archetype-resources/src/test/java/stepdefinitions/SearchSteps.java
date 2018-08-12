/*
 * Copyright 2018 Florian Schmidt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ${package}.stepdefinitions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ${package}.pageobjects.DuckDuckGoHomePage;
import ${package}.utils.WebDriverFactory;

/**
 * @author Florian Schmidt https://elmland.blog
 */
public class SearchSteps {

	private DuckDuckGoHomePage googleHomePage;

	public SearchSteps() {
		this.googleHomePage = new DuckDuckGoHomePage(WebDriverFactory.driver);
	}

	@Given("I am on duckduckgo homepage")
	public void i_am_on_duckduckgo_homepage() {
		this.googleHomePage.navigateTo();
	}

	@When("I enter {string} as search phrase")
	public void i_enter_as_search_phrase(String string) {
		this.googleHomePage.enterSearchPhrase(string);
	}

	@When("I press the search button")
	public void i_press_the_search_button() {
		this.googleHomePage.clickSearchButton();
	}

	@Then("duckduckgo should show {string} in the result list on position {int}")
	public void duckduckgo_should_show_in_the_result_list_on_position(String expectedResultUrl, int position) {
		List<String> searchResultUrls = this.googleHomePage.getSearchResults();

		assertThat(expectedResultUrl, equalTo(searchResultUrls.get(0)));
	}

}
