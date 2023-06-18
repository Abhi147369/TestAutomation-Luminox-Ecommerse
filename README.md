# TestAutomation-Luminox-Ecommerce

This repository contains automated tests for the Luminox Ecommerce website. The tests are implemented using Java, Selenium WebDriver, Maven, TestNG, and following the Page Object Model (POM) design pattern.

## Prerequisites

Make sure you have the following software installed on your machine:

- Java Development Kit (JDK)
- Maven
- Chrome WebDriver
- Selenium
- TestNG

## Getting Started

1. Clone the repository:

```bash
git clone https://github.com/your-username/TestAutomation-Luminox-Ecommerce.git
```

2. Navigate to the project directory:

```bash
cd TestAutomation-Luminox-Ecommerce
```

3. Update the WebDriver configuration:

   - Download the Chrome WebDriver compatible with your Chrome browser version.
   - Set the path to the WebDriver executable in the `src/test/resources/config.properties` file.

4. Build the project:

```bash
mvn clean install
```

## Test Execution

To execute the automated tests, run the following command:

```bash
mvn test
```

This will run all the tests defined in the project.

## Project Structure

The project follows the Page Object Model (POM) design pattern to separate the test logic from the page structure. The project structure is organized as follows:

- `src/test/java`
  - `pages`: Contains page classes that represent the web pages of the Luminox Ecommerce website.
  - `tests`: Contains test classes that implement the automated tests using TestNG.
- `src/test/resources`
  - `config.properties`: Contains configuration properties such as WebDriver path and other settings.

## Contributing

If you would like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your changes to your fork.
5. Submit a pull request.

## License

This project is Preapared by Abhishek Gavkare.

## Acknowledgments

- This project is developed for educational purposes and based on the Luminox Ecommerce website.
- Special thanks to the Java, Selenium, Maven, and TestNG communities for their valuable tools and resources.
