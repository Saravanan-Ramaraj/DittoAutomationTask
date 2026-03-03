# Ditto Automation Task - Calculating Premium with Add-Ons #

This repository contains an automated test framework designed to validate the premium calculation logic for the Ditto health insurance application.  
The automation verifies that the **Total Premium equals the Base premium plus selected add-ons**, using Selenium WebDriver, TestNG, and Maven.

The framework uses a **Hybrid Page Object Model (POM)** structure, enhanced reporting with **ExtentReports**, and logging with **Log4j2**.
___

## 👋 About Me ##

Hi,
I am Saravanan Ramraj a SDET with 4+ years of experience in Software Testing.
I have hands-on experience in Selenium, Java, TestNG, Maven for UI Automation and Postman, RestAssured for API Automation.
I enjoy building scalable automation frameworks using Page Object Model and implementing robust reporting and logging mechanisms. 
I am passionate about improving software quality through efficient test design and automation best practices.
You can connect with me over: (https://www.linkedin.com/in/saravanan-ramaraj-tester/)
___

## 🧪 Scope of Automation ##

The following functionality is validated:

✔ Select a health insurance plan  
✔ Navigate through multi-step form flow  
✔ Enter user details and calculate base premium  
✔ Capture add-on values  
✔ Validate premium calculation logic  
✔ Capture screenshots on failure  
✔ Generate detailed HTML reports with logs and screenshots
___

## 🚀 Technologies Used ##

✔ Java  
✔ Selenium WebDriver  
✔ TestNG  
✔ Maven  
✔ Page Object Model (POM)  
✔ ExtentReports (HTML Report)  
✔ Log4j2 (Logging)  
___

## 📊 Report & Logging ##

The report will be created as report.html in project folder
![Extent Report](https://github.com/Saravanan-Ramaraj/DittoAutomationTask/blob/static-content/image.png)

These help in understanding execution flow, pass/fail status, and failure context.
___

## 📦 Project Structure ##
```
DittoAutomationTask
├─ .classpath
├─ .project
├─ .settings
│  ├─ org.eclipse.jdt.core.prefs
│  └─ org.eclipse.m2e.core.prefs
├─ logs
│  └─ automation.log
├─ pom.xml
├─ report.html
├─ src
│  ├─ main
│  │  ├─ java
│  │  └─ resources
│  └─ test
│     ├─ java
│     │  └─ com
│     │     └─ ditto
│     │        ├─ listeners
│     │        │  ├─ MyRetryAnalyzer.java
│     │        │  └─ TestListener.java
│     │        ├─ pages
│     │        │  ├─ PlanSelectionPage.java
│     │        │  ├─ PremiumPage.java
│     │        │  └─ UserDetailsPage.java
│     │        ├─ tests
│     │        │  ├─ BaseTest.java
│     │        │  └─ HealthInsurancePremiumCalculationTest.java
│     │        └─ utils
│     │           ├─ BrowserUtility.java
│     │           ├─ DriverFactory.java
│     │           ├─ ExtentReporterUtility.java
│     │           └─ LoggerUtility.java
│     └─ resources
│        └─ log4j2.xml
└─ testng.xml

```
___

## ▶ How to Run the Project? ##
You can run the project on your local system for that:

1. Clone the Project on Local System: git clone https://github.com/Saravanan-Ramaraj/DittoAutomationTask.git
2. Execute tests via Maven: mvn test
