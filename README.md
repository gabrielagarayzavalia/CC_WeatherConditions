# WeatherConditions
Compares temperature  of a location taken from Google search and from Weather API 

Uses JavaSE-17 ( JRE library)
Build as a Maven project on Eclipse
You'll need to download TestNG from Eclipse Market place
At pom.file are included the library that uses this program
(
    testng,
    rest-assured,
    selenium-java,
    selenium-http-jdk-client,
    jackson-databind,
    gson,
)

Run program:
It can be run from Eclipse
1) run as java choosing the "apiTesting.java" file from src/test/java/testSteps
or
2) run as TestNG choosing the "webApiTempComparison.java" file from src/test/java/weatherApi

Chromedriver version: 111
Google Chrome version: Version 112.0.5615.50 (Official Build) (64-bit)


// Work in progress
// TODO: add to apiTesting input for any location (now only runs for one location)
