# Calculadora_ISA

## Overview
Calculadora_ISA is a web application that provides basic calculator functionalities such as addition, subtraction, multiplication, and division. It is built using Java and the Spring Boot framework.

## Features
- Handles HTTP requests for calculator operations.
- Implements business logic for performing calculations.
- Provides a simple RESTful API for users to interact with the calculator.

## Project Structure
```
Calculadora_ISA
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── calculadora
│   │   │           ├── controller
│   │   │           │   └── CalculatorController.java
│   │   │           ├── service
│   │   │           │   └── CalculatorService.java
│   │   │           └── App.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── calculadora
│                   └── AppTest.java
├── pom.xml
└── README.md
```

## Setup Instructions
1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd Calculadora_ISA
   ```
3. Build the project using Maven:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```

## Usage
Once the application is running, you can access the calculator API at:
```
http://localhost:8080/calculator
```
You can perform operations by sending HTTP requests to the appropriate endpoints for addition, subtraction, multiplication, and division.

## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License
This project is licensed under the MIT License.