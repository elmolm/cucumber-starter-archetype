[![Build Status](https://travis-ci.org/elmolm/cucumber-starter-archetype.svg?branch=master)](https://travis-ci.org/elmolm/cucumber-starter-archetype)

# 1. Introduction
This is a maven archetype to create a simple cucumber 3/selenium 3 project. Projects built with this archetype contain:

* a simple cucumber/gherkin/selenium example **search via duduckgo**
* a DriverFactory
* auto download of selenium webdrivers via **webdriverextensions-maven-plugin**

 
# 2. Installing cucumber-starter-archetype

```
$ git clone git@github.com:elmolm/cucumber-starter-archetype.git
$ cd cucumber-starter-archetype
$ mvn install
```

# 3. Building your cucumber project
```
$ cd <your_dev_root_path>
$ mvn archetype:generate -B \
	-DarchetypeGroupId=blog.elmland.maven \
	-DarchetypeArtifactId=cucumber-starter-archetype \
	-DgroupId=<your_group_id> \
	-DartifactId=<your_artifact_id>
	
$ cd <your_artifact_id>
$ mvn test
```
