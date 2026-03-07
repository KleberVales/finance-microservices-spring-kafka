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


