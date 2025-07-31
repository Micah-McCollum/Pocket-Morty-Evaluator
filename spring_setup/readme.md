# Pocket Mortys Worthiness Evaluator API

A backend REST API for evaluating the stat-based potential of Morty characters based on their initial spawn attributes. Inspired by the gameplay of Pocket Mortys and games with random stat generation (like Pokemon), this API determines whether a Morty is worth training based on custom scoring logic.

---

## Features

- Create and manage Morty characters with detailed stat blocks
- Build teams of Mortys 
- Evaluate Morty stats for worthiness via stat scoring parameters
- Secure user-based authentication with H2 database
- Fully tested with unit tests and Postman integration tests

---

## Tech Stack

- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA (H2 database)
- Gradle
- JUnit 5 + Mockito
- Postman (manual and automated API testing)

---

## How to Run Locally

1. Clone the repo:

   ```bash
   git clone https://github.com/yourusername/pocketmortys-evaluator-api.git
   cd pocketmortys-evaluator-api
   ```

2. Run the app:

   ```bash
   ./gradlew bootRun
   ```

3. Access:

   - API Root: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`
   - Postman Environment: [`PocketMortysLocal.postman_environment.json`](postman/PocketMortysLocal.postman_environment.json)

---

## Authentication

This project uses HTTP Basic authentication with a pre-seeded user:

```
Username: admin
Password: adminpass
```

User credentials are stored in the H2 database and loaded at runtime.

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

```bash
./gradlew test
```

### Postman

- Collection: [`PocketMortysAPI.postman_collection.json`](postman/PocketMortysAPI.postman_collection.json)
- Environment: [`PocketMortysLocal.postman_environment.json`](postman/PocketMortysLocal.postman_environment.json)

Import both into Postman and run the full request suite.

---

## Project Structure

```
src/
 ├── main/java/com/micah/springapi
 │   ├── controller/     # REST controllers
 │   ├── dto/            # Request/response payloads
 │   ├── model/          # Entities and enums
 │   ├── repository/     # JPA repositories
 │   └── service/        # Business logic

postman/
 ├── PocketMortysAPI.postman_collection.json
 └── PocketMortysLocal.postman_environment.json
```

---

## Summary

This project demonstrates a secure, RESTful, stat-evaluation API built with Spring Boot. It includes full CRUD support, custom business logic, DTO separation, unit tests, and live integration testing. Ideal for showcasing backend development capabilities in a focused, game-inspired application.

