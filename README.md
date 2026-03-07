# Finance Microservices - Spring Kafka

A microservices-based financial system built with Spring Boot and Apache Kafka using an event-driven architecture.

This project demonstrates how to build scalable microservices communicating asynchronously using Kafka while maintaining independent databases for each service.

---

## Architecture

The system is composed of multiple microservices that communicate through events published to Kafka topics.

```text

Client
  ↓
Auth Service
  ↓
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
















