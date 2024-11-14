# accountsService

The `happiness Survey` is a Spring Boot service to do a survey within the compagny.

## Features

- Create a survey via admin endpoint.
- Add employee answers for the survey.
- Get Survey answers

### Prerequisites

Ensure you have the following installed:

- Java 17 or higher
- Maven 3.6+
- Docker (optional for running the service as a container)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/kaouther24/happinessSurvey.git
   cd happinessSurvey

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
   docker build -t happiness-survey:latest .
   
2. **Run the docker container**:
   ```bash
   docker run -p 8083:8080 happiness-survey
   
### Technologies Used
- Spring Boot: Framework for building services.
- Docker: To containerize the service.

### License
This project is licensed under the MIT License