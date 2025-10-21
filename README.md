# 🏦 Java Selenium Banking Project

This project automates end-to-end functional testing of the **GlobalSQA Banking Project** web application (https://www.globalsqa.com/angularJs-protractor/BankingProject/) using **Java + Selenium WebDriver**. It validates key customer and manager workflows including login, account creation, deposits, withdrawals, and transaction verification.  

Tools: Java, Selenium WebDriver, TestNG, IntelliJ IDEA, Git & GitHub.  

Automated tests cover customer login/logout, manager login and customer creation, account operations, and transaction verification. Test results can be viewed directly in the IDE’s test runner or console output, and screenshots or logs can be added to the README if desired.  

## ⚙️ CI/CD Integration

This project includes a **GitHub Actions workflow** that automatically runs the Selenium tests on each code push or pull request.  
The workflow file is located at:
.github/workflows/ci.yml


The pipeline:
- Sets up the Java environment.
- Builds the project with Maven.
- Executes all Selenium test cases.
- Displays results directly in the **Actions** tab on GitHub.


**Author:** Levente Cornea
