# README: Card Account Service

The Card Account Service, a micro-service that manages credit cards and accounts. This service provides CRUD operations for cards and accounts, allowing clients to create, retrieve, update, and delete their cards and accounts through RESTful APIs.

## Technologies Used

- **Spring Boot**: The backend application is built using Spring Boot, providing a robust and scalable foundation.
- **Java 17**: The application is developed using Java 8 or later.
- **H2 Database (Optional)**: In-memory H2 database is used for storing mock data. You can switch to other databases like PostgreSQL if needed.

## Getting Started

To run the application locally, follow these steps:

1. Navigate to the project directory: `cd card-account-service`
2. Run the application: `spring-boot:run`

The application will start, and you can access the APIs using the specified endpoints.

## Adjusting Application Port

By default, the application runs on port 8080. If you need to change the port, follow these steps:

1. **Modify `application.properties`:**

   Open `src/main/resources/application.properties` and add or update the following property to set a custom port:

   ```properties
   # Set the custom port
   server.port=your_custom_port

## Data Models

### Account

- **ID**: Auto-generated unique identifier for an account.
- **IBAN**: iban of the account.
- **BIC/SWIFT**: bic swift of the account.
- **Client ID**: client to whom the account belongs.

### Card

- **ID**: Auto-generated unique identifier for a card.
- **Card Alias**: Personalized name for the card (editable).
- **Account ID**: Identifier linking the card to a specific account.
- **Card Type**: Indicates if the card is virtual or physical.

## Association between Card and Account

The relationship between Card and Account is established using the `@ManyToOne` annotation in the Card entity. This indicates that many Card entities can be associated with one Account entity. The `@JoinColumn` annotation specifies the column used for joining the two entities.

### Card

  - **`@ManyToOne`:**
  - **`@JoinColumn(name = "accountId", referencedColumnName = "id")`:**
  - **`private Account account;`:**


**Explanation:**

- **`@Entity`:** Marks the `Card` class as a persistent entity, indicating that it's mapped to a database table.
- **`@ManyToOne`:** Denotes a many-to-one relationship between `Card` and `Account`, meaning one account can have multiple cards.
- **`@JoinColumn`:** Specifies the column used to join the `Card` table with the `Account` table. In this case, the `accountId` column in the `Card` table references the `id` column in the `Account` table.




## API Endpoints

### Account Endpoints

- **GET /accounts**: Retrieve all accounts.
- **GET /accounts/{accountId}**: Retrieve an account by ID.
- **POST /accounts**: Create a new account.
- **PUT /accounts/{accountId}**: Update an existing account.
- **DELETE /accounts/{accountId}**: Delete an account.
- **GET /accounts/{accountId}/cards**: Retrieve all cards associated with an account.

### Card Endpoints

- **GET /cards/by-account/{accountId}**: Retrieve all cards associated with an account.
- **POST /cards**: Create a new card.
- **PUT /cards/{cardId}**: Update an existing card.
- **DELETE /cards/{cardId}**: Delete a card.

## Mock Data

The application uses a `MockDataInitializer` class to populate the database with mock data for testing purposes. This class implements the `CommandLineRunner` interface, ensuring that its `run` method is executed on application startup. The `run` method creates mock accounts and cards and saves them to the database.

### MockDataInitializer Class

The `MockDataInitializer` class is located in the `com.sitemapdev.cardaccountservice.config` package. It is responsible for initializing mock data, including five different account IDs and five different client IDs. 

## Running Tests

The application includes test classes to ensure the correctness of the implemented functionality. The tests are written using JUnit and Mockito. Below are the test classes and instructions on how to run them.

### AccountServiceImplTest

The `AccountServiceImplTest` class tests the functionality of the `AccountServiceImpl` service, which handles operations related to accounts.

# To run AccountServiceImplTest
`mvnw test -Dtest=AccountServiceImplTest`


### CardServiceImplTest
The `CardServiceImplTest` class tests the functionality of the `CardServiceImpl` service, which handles operations related to cards

# To run CardServiceImplTest
`mvnw test -Dtest=CardServiceImplTest`

## Extras

- **Containerization**: Dockerize the application for easy deployment.
- **Database**: Optionally, switch to PostgreSQL for persistent storage.
- **Swagger Open API Specification**: Explore and test APIs using Swagger UI.

#### Containerization

Docker is used to containerize the application. The Dockerfile defines the steps to create a container, making it easy to deploy the service in various environments.

## Running the Docker Image

To run the application using Docker, follow these steps:

1. **Build the Docker Image:**

   Open a terminal, navigate to the project directory containing your Dockerfile, and run:

   
   `docker build -t card-account-service .`
   Replace `card-account-service` with the desired name for your Docker image.


2. **Run the Docker Container:**

   Once the image is built, start a container using:
   `docker run -p 8080:8080 card-account-service`
   This command maps port 8080 from the container to port 8080 on your host 

3. **Access the Application:**

    Open a web browser and navigate to http://localhost:8080 to interact with the running Spring Boot application.

4. **Stopping the Container:**

    When you're done, stop the container using:
    `docker stop container-id`
    Replace `container-id` with the actual ID or name of the running container. You can find the container ID by running `docker ps`


#### Database

The application supports both an in-memory H2 database and an external PostgreSQL database. Configuration properties in `application.properties` allow switching between these options.


## Switching from H2 to PostgreSQL

If you want to switch from the default H2 in-memory database to PostgreSQL, follow these steps:

1. **Modify `application.properties`:**

   Replace the H2 database properties with PostgreSQL properties:

   ```properties
   # DataSource settings: set PostgreSQL properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=org.postgresql.Driver

   # Hibernate settings
   spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
   spring.jpa.hibernate.ddl-auto=update

   # Log SQL statements
   spring.jpa.show-sql=true

#### Swagger Open API Specification

Swagger is integrated into the application to provide an interactive API documentation through the Swagger UI. Explore and test the APIs by visiting the `/swagger-ui.html` endpoint.

If you have any questions or feedback, please don't hesitate to reach out.

---

