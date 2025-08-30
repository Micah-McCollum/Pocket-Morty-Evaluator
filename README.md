# Pocket Mortys Worthiness Evaluator API

A backend REST API for evaluating the stat-based potential of Morty characters based on their initial spawn attributes. Inspired by the gameplay of Pocket Mortys and games with random stat generation (like Pokemon), this API determines whether a Morty is worth training based on custom scoring logic.

---

## Features

- Create and manage Morty characters with detailed stat blocks
- Build teams of Mortys 
- Evaluate Morty stats for worthiness via stat scoring parameters
- Secure user-based authentication with Spring Security and MySQL 8.4
- Passwords stored using BCrypt hashing
- Fully tested with unit tests and Postman integration tests

---

## Tech Stack

- Java 21
- Spring Boot 3
- Spring Security (HTTP Basic, BCrypt password storage)
- Spring Data JPA (Runtime: MySQL, Testing: H2)
- Gradle
- JUnit 5 + Mockito
- Postman (manual and automated API testing)
- Docker Compose (MySQL 8.4)

---

## How to Run Locally

1. Clone the repo:

   ```bash
   git clone https://github.com/yourusername/pocketmortys-evaluator-api.git
   cd pocketmortys-evaluator-api
   ```

2. Start MySQL server with Docker:

   docker compose up -d

   The app starts MySQL 8.4 with
   - Database: mortydb
   - User: morty
   - Password: secret

3. Run the app:

   ./gradlew bootRun --args="--spring.profiles.active=mysql"

4. Access:

   - API Root: `http://localhost:8080`
   - Postman Environment: [`PocketMortysLocal.postman_environment.json`](postman/PocketMortysLocal.postman_environment.json)

---

## Authentication

- Uses HTTP Basic Auth.
- User credentials are stored in the users table in MySQL.
- Passwords must be BCrypt hashes (never stored in plaintext).
- To create a user manually:
   - To generate a BCrypt hash, you can run the provided BCryptToolRunner (see com.mortyproject.tools) or use any local Java snippet with new BCryptPasswordEncoder().encode("rawPassword").

INSERT INTO users (username, password, role)
VALUES (
  'micah',
  '$2a$10$Vt7NLN29DShsh..../hashedPasswordHere...',
  'USER'
);

---

## API Examples

### POST /api/evaluate

Evaluate a Morty by providing base stats.

**Request Body:**

```json
{
  "level": 5,
  "hp": 30,
  "attack": 12,
  "defense": 8,
  "speed": 7
}
```

**Response:**

```json
{
  "worthTraining": false,
  "score": 64,
  "recommendation": "Low rolled stats — better to catch another."
}
```

---

### POST /api/mortys

Creates a Morty with embedded stat block.

### GET /api/mortys

Lists all stored Mortys.

### POST /api/teams

Creates a team (max 6 Mortys).

---

## Testing

### JUnit Tests

Run all tests:

./gradlew test

### Postman

- Collection: [`PocketMortysAPI.postman_collection.json`](postman/PocketMortysAPI.postman_collection.json)
- Environment: [`PocketMortysLocal.postman_environment.json`](postman/PocketMortysLocal.postman_environment.json)

Import both into Postman and run the full request suite.

---

## Project Structure

```
src/
 ├── main/java/com/mortyproject
 │   ├── config/                 # Application and Security config
 │   ├── controllers/            # REST controllers
 │   ├── dto/                    # Request/response payloads
 │   ├── model/                  # Entities and enums
 │   ├── repository/             # JPA repositories
 │   ├── repository/             # JPA repositories
 │   └── service/                # Business logic
 ├── main/resources
 │   └── application-mysql.yml   # MySQL runtime profile
 └── test/resources
     └── application.properties  # H2 for tests

postman/
 ├── PocketMortysAPI.postman_collection.json
 └── PocketMortysLocal.postman_environment.json
```

---

## Summary

This project demonstrates a secure, RESTful stat-evaluation API built with Spring Boot 3.5. It includes:

- Full CRUD support for Mortys and Teams

- Custom scoring business logic

- BCrypt-based authentication with MySQL persistence

- Separation of profiles for dev (MySQL) and test (H2)

- Unit tests and Postman integration suite

