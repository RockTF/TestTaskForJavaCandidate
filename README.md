# User Data Aggregation Service

This is a Java Spring Boot application that provides a RESTful API for aggregating user data from multiple databases. The application allows you to specify data sources in the configuration, and it retrieves user data from these sources and aggregates it into a single response.

## API Endpoint

### Get All Users
- **HTTP Method:** GET
- **Endpoint:** `/users`
- **Description:** Retrieves user data from all configured data sources and aggregates it into a single response.

**Example Response:**
```json
[
 {
  "userId": "e38f017b-93ad-48e1-ac7f-ca43793980e2",
  "username": "jdoe",
  "name": "John",
  "surname": "Doe"
},
{
"userId": "5fcf2c34-8aed-41b4-9f4e-4071d65efc26",
"username": "asmith",
"name": "Alice",
"surname": "Smith"
},
{
"userId": "830a0705-51df-3d52-a52a-bf2ec261f068",
"username": "usernameMongo",
"name": "nameMongo",
"surname": "surnameMongo"
}
]
```

## Configuration

The application uses declarative configuration for specifying data sources. You can configure the data sources in the `application.yaml` file. You can add or remove data sources by editing this configuration file.

**Example Configuration:**
```yaml
spring:
  main:
    allow-bean-definition-overriding: true
  data:
    mongodb:
      uri: mongodb://
      database: 
  datasource:
    username: 
    password: 
    url: jdbc:postgresql://l
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 20
      auto-commit: false
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: none
    properties:
      hibernate:
        format_sql: true
        jdbc:
          batch_size: 20
        order_inserts: true
        order_updates: true
        connection:
          release_mode: after_transaction
        temp:
          use_jdbc_metadata_defaults: false
  flyway:
    enabled: true

```

## Technology Stack

- Spring Boot
- OpenAPI for API contract specification
- Git for version control

## Usage

1. Clone this repository.
2. Configure your data sources in the `application.yaml` file.
3. Build and run the application using Spring Boot.
4. Access the API endpoints to retrieve aggregated user data.

## Optional Requirements

- OpenAPI contract specification for API endpoints can be found in the `openapi.yaml` file.
- The project is hosted on a Git repository with this README file.

Feel free to reach out if you have any questions or need further assistance with the application.