# Tool-Shop-Selenium-Test

Application testing project

## Run Tests

You can build your project and run your tests using maven-surefire-plugin.
Default execution of test are in POM file.

### Run all tests using maven

Command line:   
mvn test -Dsurefire.suiteXmlFiles=src/test/suite/RunAll.xml

Run your tests from suite folder by selecting "Smoke Test.xml" file and run it (right click - Run)

## utility package

- Before All: @Before annotation - executed before each test.
- WaitAnd class: Advanced Function which I created to use to work with web elements. .
- ConfigEnv: Contains static methods for creating Config instances.

## page object package
- Page Object: Used in test automation that creates Object Repository for web UI elements.

## fun package
Fun-Functions: A set of functions in one place, such as log in, checkout...

## Report
When the testing is complete, the report will be available in

- `surefire-reports/index.html`
(Open in any Web Browser)
