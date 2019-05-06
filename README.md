# Unibet Blog Search Functionality Automation

#### Required Software:

- Java (version 1.8)
- Appium (version 1.10.1)
- Maven (version 3.5.3)
- TestNG (version 6.14.3)
- log4j (version 1.2.17)

#### About Project Structure: 
This project is aimed to automate three most important search functionalities of **Unibet** blog. This project is implemented using Java, Appium/Webdriver and TestNG. Page Object Model (POM) is used to make the code more readable, maintainable, and reusable.

There are 3 flows which are covered in this test automation project.
- Verify valid results are being displayed on Searching with keyword, i.e., search result list should have the searched keyword present in paragraph being displayed.
- Verify 'No Search Result' page should appear when user searches for keywords which is not present in any of the blog.
- Verify auto-suggestion appears on performing search on search results page. And clicking on any of the auto-suggested blog, user must be redirected to the same blog.

#### Logging:
Logging is done using log4j. Log file is being generated in 'log' directory.

#### Steps to setup and execute:

- Install Java, maven, android & appium, and set their respective paths in system variables
- Clone project from git 
    > git clone https://github.com/prernapal13/unibet-automation.git
- Clean and compile project using 
    > mvn clean compile
- Modify details in **_Init.java_** file as per the device. [PLATFORM_NAME, DEVICE_NAME & PLATFORM_VERSION]
- Start appium server either from command prompt(command: appium) or from desktop application.
- To execute the scripts, execute following command from command prompt:
    > mvn test

#### More tests related to 'Search' functionality that can be performed are listed below:
- Verify if there are any minimum or maximum count limit for search keyword.
- Verify that localization is working properly, i.e., user should be able to search and get results in any of the supported languages.
- Verify that all blog searched should have either full search string match or partial search string match.
- Cross-browser & cross-platform testing.
