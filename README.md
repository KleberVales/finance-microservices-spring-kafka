# Finance Microservices - Spring Kafka

A financial system built using Java, Spring Boot, Apache Kafka, and Microservices Architecture.
This project demonstrates how to design event-driven microservices for handling financial operations in a scalable and decoupled way.

The services communicate asynchronously through Kafka events, allowing each microservice to evolve independently while maintaining system consistency.

## Architecture

The system follows a microservices architecture combined with event-driven communication.

```text
Client / API Requests
        │
        ▼
   REST Controllers
        │
        ▼
     Services
        │
        ▼
 Kafka Producer ─────► Kafka Topic ─────► Kafka Consumer
        │                                 │
        ▼                                 ▼
     Database                          Other Services
  
```

Key Concepts

- Microservices Architecture
- Event-driven communication
- Kafka messaging
- Domain-driven structure
- Loose coupling between services

## Project Structure
















