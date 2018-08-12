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
package ${package}.pageobjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Florian Schmidt https://elmland.blog
 */
public class DuckDuckGoHomePage extends BasePageObject {

	@FindBy(id = "search_form_input_homepage")
	private WebElement searchInput;

	@FindBy(id = "search_button_homepage")
	private WebElement searchSubmitButton;

	public DuckDuckGoHomePage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(this.driver, this);
	}

	public DuckDuckGoHomePage navigateTo() {
		driver.get("https://duckduckgo.com/");

		return this;
	}

	public DuckDuckGoHomePage enterSearchPhrase(String searchPhrase) {
		this.searchInput.sendKeys(searchPhrase);

		return this;
	}

	public DuckDuckGoHomePage clickSearchButton() {
		this.searchSubmitButton.click();

		return this;
	}

	/**
	 * Returns the urls of the search result.
	 * 
	 * @return list of urls
	 */
	public List<String> getSearchResults() {
		/**
		 * DuckDuckGo renders the search results via javascript. We wait until the "more
		 * results" link is clickable.
		 */
		new WebDriverWait(this.driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.result--more__btn")));

		List<WebElement> results = this.driver.findElements(By.cssSelector("#links a.result__a"));

		return results.stream().map(entry -> entry.getAttribute("href")).collect(Collectors.toList());

	}

}
