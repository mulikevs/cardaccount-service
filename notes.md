# notes.md: Implementation Notes

## Data Models

### Account

- **ID**: Auto-generated unique identifier for an account.
- **IBAN**: International Bank Account Number associated with the account.
- **BIC/SWIFT**: Bank Identifier Code/Society for Worldwide Interbank Financial Telecommunication code for the account.
- **Client ID**: Identifier for the client associated with the account.

### Card

- **ID**: Auto-generated unique identifier for a card.
- **Card Alias**: Personalized name for the card (editable).
- **Account ID**: Identifier linking the card to a specific account.
- **Card Type**: Indicates if the card is virtual or physical.

## Association between Card and Account

The relationship between Card and Account is established using the `@ManyToOne` annotation in the Card entity. This indicates that many Card entities can be associated with one Account entity. The `@JoinColumn` annotation specifies the column used for joining the two entities.

```java
@Entity
public class Card {
    // ...
    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "id")
    private Account account;
    // ...
}

## Implementation Details

### Association between Card and Account

This setup ensures that each card is associated with exactly one account.

### Mock Data

Mock data is used to simulate accounts and cards for testing purposes. At least two different account IDs and two different client IDs are present in the system. This data is stored in an in-memory H2 database.

### Testing

The application includes unit tests to ensure the correctness of the implemented functionality. These tests cover scenarios such as creating accounts, updating cards, and retrieving cards by account ID.

### Extras

#### Containerization

Docker is used to containerize the application. The Dockerfile defines the steps to create a container, making it easy to deploy the service in various environments.

#### Database

The application supports both an in-memory H2 database and an external PostgreSQL database. Configuration properties in `application.properties` allow switching between these options.

#### Swagger Open API Specification

Swagger is integrated into the application to provide an interactive API documentation through the Swagger UI. Explore and test the APIs by visiting the `/swagger-ui.html` endpoint.

#### Additional Considerations

- Keep the application simple, using only essential libraries and frameworks.
- Ensure the service is designed to run in a production environment.
- Use Java 8 or later for compatibility.

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

 If you encounter any issues or have suggestions, please provide feedback.

