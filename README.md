# Finance Microservices - Spring Kafka




```text

 
User Service → publishes events → Kafka
  ↓
Account Service → consumes events
  ↓
PostgreSQL databases per service

```

Event-driven communication ensures loose coupling between services and improves scalability.

---

## Technologies

- Java 21
- Spring Boot
- Spring Data JPA
- Apache Kafka
- PostgreSQL
- Docker
- Gradle

---

## Microservices

### Auth Service

Handles authentication and authorization.

### User Service

Responsible for managing users and publishing user-related events.

### Account Service

Responsible for managing financial accounts and reacting to user events.

---

## Event Flow

Example flow when a new account is created:

```text

Account Service
   ↓
Publish event: account-created
   ↓
Kafka Topic
   ↓
Other services consume the event

```

This allows services to remain independent and react to events asynchronously.

---

## Project Structure

```text
finance-microservices-spring-kafka
│
├── auth-service
├── user-service
├── account-service
│
├── docker-compose.yml
│
└── README.md
```

---

## Running the Project

### Requirements

- Docker
- Docker Compose
- Java 21
- Gradle

---

### Start the system

docker compose up --build

This will start:

- Kafka
- Zookeeper
- PostgreSQL databases
- All microservices

---

### Running Services

| Service | Port |
|------|------|
| auth-service | 8082 |
| user-service | 8081 |
| account-service | 8083 |

---



