# accountsService

The `accountsService` is a Spring Boot microservice that manages bank accounts and provides functionalities for creating new accounts, retrieving account details, and handling customer-related operations.

## Features

- Create a new bank account for an existing customer.
- Retrieve details of a customer's bank accounts.
- Fetch customer accounts based on UUID.
- Validate and process account data securely.

### Prerequisites

Ensure you have the following installed:

- Java 17 or higher
- Maven 3.6+
- Docker (optional for running the service as a container)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/kaouther24/accountsService.git
   cd accountsService

2. **Build the project using Maven**:
   ```bash
   mvn clean install

3. **run the application**:
   ```bash
   mvn spring-boot:run

The service will be available at http://localhost:8080.

### Running with Docker

1. **Build with docker**:
   ```bash
   docker build -t accounts-service:latest .
   
2. **Run the docker container**:
   ```bash
   docker run -p 8083:8080 accounts-service
   
### API Endpoints
The accountsService exposes the following API endpoints:
1. **Create a new account for an existing customer**:
- Endpoint: POST /bankAccount/new
- Request body:
  {
  "customerUuid": "string",
  "balance": 1000.0
  }

2. **Get list of accounts by customer UUID**:
- Endpoint: GET /bankAccount/byCustomerId/{customerUuid}
3. **Create an account by its UUID**:
- Endpoint: GET /bankAccount/byIdAccount/{accountUuid}

### Technologies Used
- Spring Boot: Framework for building microservices.
- JUnit & Mockito: For unit and integration testing.
- Docker: To containerize the service.

### License
This project is licensed under the MIT License