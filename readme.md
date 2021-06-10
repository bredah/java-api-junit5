# Java: Test API

Project presents example in using libraries to perform API tests.

## Required software

- Java JDK 11+
- Maven installed and in your classpath

## Running the test suites

The test suites can be run directly by your IDE or by command line. If you run mvn test all the tests will execute because it's the regular Maven lifecycle to run all the tests.

To run different suites based on the groups defined for each test you must inform the property -Dgroups and the group names. The example below shows how to run the test for each stage:

| stage             | command                        |
| :---------------- | :----------------------------- |
| health check test | mvn test -Dgroups="health"     |
| functional test   | mvn test -Dgroups="functional" |
| e2e test          | mvn test -Dgroups="e2e"        |

## Generating the test report

This project uses Allure Report to automatically generate the test report. There are some configuration to make it happen:

- aspectj configuration on `pom.xml` file
- `allure.properties` file on `src/test/resources`

You can use the command line to generate it in two ways:

- `mvn allure:serve`: will open the HTML report into the browser
- `mvn allure:report`: will generate the HTML port at target/site/allure-maven-plugin folder

## About the project

## src/main/java

### test

Tests used in the example of using REST Assured + JUnit4 libraries

### config

The Configuration class is the connections and authentication data between the `api.properties` and `auth.properties` properties file located in `src/test/resources/`.

### model

Model class to mapping objects thought serialization and deserialization in use with [Gson](https://github.com/google/gson).

## src/test/resources

It has a `schemas` folder with the JSON Schemas to enable Contract Testing using Rest-Assured. Also, the properties file to easily configure the API URI.

## Libraries

- [RestAssured](http://rest-assured.io/) library to test REST APIs
- [JUnit 5](https://junit.org/junit5/) to support the test creation
- [Gson](https://github.com/google/gson) convert Java Objects into their JSON representation
- [Owner](http://owner.aeonbits.org/) to manage the property files
- [Log4J2](https://logging.apache.org/log4j/2.x/) as the logging strategy
- [Allure Report](https://docs.qameta.io/allure/) as the testing report strategy
