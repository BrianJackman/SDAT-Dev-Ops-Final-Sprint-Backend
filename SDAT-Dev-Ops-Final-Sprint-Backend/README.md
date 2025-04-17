# SDAT Dev Ops Final Sprint Backend

This is the backend service for the SDAT Dev Ops Final Sprint project. It is a Spring Boot application that provides RESTful APIs for managing cities, flights, and related data. The application is designed to be lightweight, scalable, and easy to deploy using Docker.

## Getting Started

### Prerequisites
To set up the project locally, ensure you have the following installed:
- Java 17 or higher
- Maven 3.8 or higher
- Docker (optional, for containerization)
- A database (e.g., MySQL or H2)

### Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/BrianJackman/SDAT-Dev-Ops-Final-Sprint-Backend
   cd SDAT-Dev-Ops-Final-Sprint-Backend

2. Configure the application by updating the application.properties file in the src/main/resources with your database configuration:
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3. Build the application by running:
    mvn clean package 

4. Run the application by running :
    java -jar target/SDAT-Dev-Ops-Final-Sprint-Backend-0.0.1-SNAPSHOT.jar

5. Testing the application using postman you can GET commands to retrieve all data for a particular entry, POST to add a new entry or DELETE to remove an entry here are examples using the cities api :
    Get all cities: GET http://localhost:8080/api/cities 
    Post a new city: POST http://localhost:8080/api/cities
    Delete a city DELETE http://localhost:8080/api/cities/<cityid> 
The data is stored in JSON format.  
6. Run the unit tets using Maven by running
    mvn test

## Docker Deployment

The application is Dockerized and can be deployed using Docker.

1. Build the Docker image:
    docker build -t sdat-backend:latest 
2. Run the Docker container:
    docker run -p 8080:8080 sdat-backend:latest




