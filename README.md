# finance-microservices-spring-kafka

## Project Structure

```text
┌─────────────────────────────────────────────────────────────────────────────┐
│                              API GATEWAY                                    │
│  ┌───────────────────────────────────────────────────────────────────────┐  │
│  │  • Roteamento de Requisições    • Autenticação/JWT                    │  │
│  │  • Rate Limiting                • Load Balancing                      │  │
│  │  • Request/Response Transform   • Caching                             │  │
│  └───────────────────────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────────────────────┘
                                      │
              ┌───────────────────────┼───────────────────────┐
              ▼                       ▼                       ▼
    ┌───────────────-------┐     ┌─────────────────---┐  ┌─────────────────-------┐
    │  SERVICE DISCOVERY   │     │  CONFIG SERVER     │  │     MESSAGE BROKER     │
    │    (Eureka/Consul)   │     │   (Spring Cloud)   │  │     (Kafka/RabbitMQ)   │
    │  • Registro serviços │     │  • Config central  │  │   • Eventos assíncronos│
    │  • Health check      │     │  • Profiles        │  │   • Pub/Sub            │
    └───────────────────--─┘     └─────────────────---┘  └─────────────────────---┘
                                      │
              ┌───────────────────────┴───────────────────────┐
              ▼                       ▼                       ▼
    ┌─────────────────┐     ┌─────────────────┐     ┌────────────────-─┐
    │   USER SERVICE  │     │  ACCOUNT SERVICE│     │ CATEGORY SERVICE │
    │  ┌───────────┐  │     │  ┌───────────┐  │     │  ┌──────────-─┐  │
    │  │  User API │  │     │  │Account API│  │     │  │Category API│  │
    │  └───────────┘  │     │  └───────────┘  │     │  └──────────-─┘  │
    │       │         │     │       │         │     │       │          │
    │  ┌──────────-─┐ │     │  ┌──────────-─┐ │     │  ┌──────────-─┐  │
    │  │  User DB   │ │     │  │Account DB  │ │     │  │Category DB │  │
    │  │(PostgreSQL)│ │     │  │(PostgreSQL)│ │     │  │(PostgreSQL)│  │
    │  └──────────-─┘ │     │  └───────────-┘ │     │  └───────────-┘  │
    └─────────────────┘     └─────────────────┘     └────────────────-─┘

```

---

## ✉️ Contact

Email: klebervales.dev@gmail.com

Redes: [LinkedIn](https://www.linkedin.com/in/klebervales) | [GitHub](https://github.com/KleberVales)

**Kleber Vales**

Java & Spring Software Engineer

Cloud | DevOps | Microservices | Git/Github | Docker | Kubernetes | Scrum | Generative AI | Event-driven architecture

<p align="justify">Software engineer with 5+ years of experience building scalable systems using Java, Spring Boot and cloud-native architectures. Strong background in microservices, event-driven systems and DevOps practices.<p/>

🏆 **Oracle Certified Associate – Java SE 7 Programmer**  
🏆 **Microsoft Technology Associate – Software Development Fundamentals**  
🏆 **Scrum Fundamentals Certified (SFC™)**  
🏆 **Oracle Cloud Infrastructure 2025 – DevOps Professional**  
🏆 **Oracle Cloud Infrastructure 2025 – Generative AI Professional**

🎓 **Bachelor's Degree in Computer Science**  
🎓 **MBA in Web Software Development**
