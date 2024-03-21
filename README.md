# TrelloApisRestAssured

## Introduction

TrelloApisRestAssured is a test automation framework designed to interact with Trello's API through RESTful requests. It facilitates testing functionalities for creating, retrieving, updating, and deleting resources using RestAssured library.
## Table of Contents

- [Technologies Used](#Technologies-Used)
- [Prerequisites](#Prerequisites)
- [Overview](#Overview)
- [Installation](#Installation)
- [Project Structure](#Project-Structure)
- [Running Tests](#Running-Tests)
- [Conclusion](#Conclusion)
- [Contact](#Contact)

## Technologies Used
<a href="https://selenium.dev"><img src="https://selenium.dev/images/selenium_logo_square_green.png" width="40" height="40" alt="Selenium"/></a>
<a href="https://testng.org/"><img src="https://github.com/Mochxd/TAU_InternetDemoWebsite/assets/122634626/86a31183-1950-4cf4-bbbe-c1c1d6dc2567" width="40" height="40" alt="TestNG"/></a>
<a href="https://rest-assured.io/"><img src="https://github.com/Mochxd/SwaggerPetstore_RestAssured_Project/assets/122634626/735af872-df76-4f8e-84ff-28795f8d28f4" width="40" height="40" alt="RestAssured"/></a>
<a href="https://allurereport.org/"><img src="https://github.com/Mochxd/SwaggerPetstore_RestAssured_Project/assets/122634626/fe07103e-be9b-4b9f-9164-e7509d90f56f" width="40" height="40" alt="allure"/></a>

## Prerequisites

Before diving into the project, ensure you have the following prerequisites:

- Java (Version 8 or higher).
- Maven for project management.
- An IDE like Eclipse or IntelliJ.
- Selenium WebDriver (Java bindings).
- RestAssured.
- TestNG.
- Optionally, Allure Reports for enhanced reporting.

## Overview

TrelloApisRestAssured is a test automation framework tailored for interacting with Trello's API. It provides a structured approach to testing and validating various API functionalities, ensuring reliability and efficiency in the testing process.

## Installation

To set up the project, follow these steps:

1. Clone the repository to your local machine:
    ```
    git clone https://github.com/Mochxd/TrelloApisRestAssured.git
    ```

2. Open the project in your preferred Java IDE (e.g., IntelliJ, Eclipse).
3. Install the required dependencies (Selenium WebDriver, TestNG, RestAssured) using Maven. You can do this by right-clicking on the project and selecting "Maven" -> "Update Project."

## Project Structure

The project structure is organized as follows:

- `EndPoints`: Contains classes defining API endpoints.
  - `URLS.java`: Defines base URLs for API requests.
- `Payload`: Package containing classes for payload data.
  - `PayLoad.java`: Defines the structure of a user object.
- `Tests`: Contains test automation scripts.
  - `Base`: Contains base test classes or utility classes shared across different test classes.
  - `Board`: Contains tests related to Trello boards.
  - `Card`: Contains tests related to Trello cards.
  - `CheckItem`: Contains tests related to Trello check items.
  - `Checklist`: Contains tests related to Trello checklists.
  - `List`: Contains tests related to Trello lists.
- `utilities`: Package containing utility classes.
  - `DataProviders.java`: Provides data for data-driven tests.
  - `ExcelFileUtilities.java`: Contains methods for interacting with Excel files.
- `TestData`: Package containing test data.
  - `BoaedData.xlsx`: Excel spreadsheet containing board data.

## Running Tests

Tests are executed using TestNG. You can monitor the progress in your IDE's console.

## Conclusion

TrelloApisRestAssured offers a comprehensive framework for automating interactions with Trello's API. By following the provided installation instructions, you can quickly set up the project and begin testing Trello API functionalities efficiently.

## Contact
For any queries or assistance, feel free to contact me via email at [mohameddmostafa98@gmail.com](mailto:mohamedbadrxd@gmail.com). Your feedback and suggestions are greatly appreciated.
