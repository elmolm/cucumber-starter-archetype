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
package ${package}.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author Florian Schmidt https://elmland.blog
 */
public class WebDriverFactory {

	public static WebDriver driver;

	@Before
	public void init() {
		initDriverSystemProps();

		driver = createDriver(Config.getBrowser());
		driver.manage().window().maximize();
	}

	private WebDriver createDriver(Browser browser) {

		switch (browser) {
		case FIREFOX:
			return new FirefoxDriver();
		case CHROME:
			return new ChromeDriver();
		case SAFARI:
			return new SafariDriver();
		default:
			throw new RuntimeException("unsupported browser");
		}
	}

	private void initDriverSystemProps() {
		OS operatingSystem = OS.currentOS();

		switch (operatingSystem) {
		case LINUX:
			System.setProperty("webdriver.gecko.driver", "_webdrivers/geckodriver-linux-64bit");
			System.setProperty("webdriver.chrome.driver", "_webdrivers/chromedriver-linux-64bit");

			break;
		case MACOS:
			System.setProperty("webdriver.gecko.driver", "_webdrivers/geckodriver-mac-64bit");
			System.setProperty("webdriver.chrome.driver", "_webdrivers/chromedriver-mac-64bit");

			break;
		case WINDOWS:
			System.setProperty("webdriver.gecko.driver", "_webdrivers/geckodriver-window-64bit.exe");
			System.setProperty("webdriver.chrome.driver", "_webdrivers/chromedriver-windows-64bit.exe");

			break;

		default:
			break;
		}
	}

	@After
	public void dinit() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
