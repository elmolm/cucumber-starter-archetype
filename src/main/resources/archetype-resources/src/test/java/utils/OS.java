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

/**
 * @author Florian Schmidt https://elmland.blog
 */
public enum OS {
	MACOS, WINDOWS, LINUX;

	public static OS currentOS() {
		String osName = System.getProperty("os.name").toLowerCase();

		if (osName.contains("mac")) {
			return OS.MACOS;
		} else if (osName.contains("windows")) {
			return OS.WINDOWS;
		} else if (osName.contains("linux") || osName.contains("unix") || osName.contains("freebsd")) {
			return OS.LINUX;
		} else {
			throw new RuntimeException("unsupported operating system " + osName);
		}
	}

}
