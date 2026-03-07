# Finance Microservices - Spring Kafka

A microservices-based financial system built with Spring Boot and Apache Kafka using an event-driven architecture.

This project demonstrates how to build scalable microservices communicating asynchronously using Kafka while maintaining independent databases for each service.

---

## Architecture

The system is composed of multiple microservices that communicate through events published to Kafka topics.


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
                                      ▼
                             ┌────────────────-─┐
                             │ Auth Service     │
                             │  ┌──────────-─┐  │
                             │  │Category API│  │
                             │  └──────────-─┘  │
                             │         │        │
                             │  ┌──────────-─┐  │
                             │  │Category DB │  │
                             │  │(PostgreSQL)│  │
                             │  └───────────-┘  │
                             └────────────────-─┘
                                      │
              ┌───────────────────────┴───────────────────────┐
              ▼                       ▼                       ▼
    ┌─────────────────┐     ┌─────────────────┐     ┌────────────────-─┐
    │   USER SERVICE  │     │  ACCOUNT SERVICE│     │ CATEGORY SERVICE │
    │  ┌───────────┐  │     │  ┌───────────┐  │     │  ┌──────────-─┐  │
    │  │  User API │  │     │  │Account API│  │     │  │Category API│  │
    │  └───────────┘  │     │  └───────────┘  │     │  └──────────-─┘  │
    │       │         │     │        │        │     │       │          │
    │  ┌──────────-─┐ │     │  ┌──────────-─┐ │     │  ┌──────────-─┐  │
    │  │  User DB   │ │     │  │Account DB  │ │     │  │Category DB │  │
    │  │(PostgreSQL)│ │     │  │(PostgreSQL)│ │     │  │(PostgreSQL)│  │
    │  └──────────-─┘ │     │  └───────────-┘ │     │  └───────────-┘  │
    └─────────────────┘     └─────────────────┘     └────────────────-─┘
           │                         │                         │
           └──────────────┬──────────┴──────────────┬──────────┘
                          ▼                          ▼
              ┌───────────────--──┐              ┌─────────────────┐
              │TRANSACTION SERVICE│              │ PLANNING SERVICE│
              │  ┌───────────┐    │              │  ┌───────────-┐ │
              │  │Trans API  │    │              │  │Planning API│ │
              │  └───────────┘    │              │  └──────────-─┘ │
              │       │           │              │       │         │
              │  ┌──────────-─┐   │              │  ┌───────────-┐ │
              │  │Trans DB    │   │              │  │Planning DB │ │
              │  │(PostgreSQL)│   │              │  │(PostgreSQL)│ │
              │  └─────────-──┘   │              │  └──────────-─┘ │
              └────────────────--─┘              └─────────────────┘
                    │   │                              │   │
                    │   └──────────────┬───────────────┘   │
                    ▼                  ▼                   ▼
              ┌─────────────────┐ ┌─────────────────┐ ┌────────────────-┐
              │   GOAL SERVICE  │ │  REPORT SERVICE │ │NOTIFICATION SVC │
              │  ┌───────────┐  │ │  ┌───────────┐  │ │  ┌───────────┐  │
              │  │ Goal API  │  │ │  │Report API │  │ │  │Notif API  │  │
              │  └───────────┘  │ │  └───────────┘  │ │  └───────────┘  │
              │       │         │ │       │         │ │       │         │
              │  ┌──────────-─┐ │ │  ┌───────────┐  │ │  ┌───────────┐  │
              │  │ Goal DB    │ │ │  │Report DB  │  │ │  │Notif DB   │  │
              │  │(PostgreSQL)│ │ │  │(MongoDB)  │  │ │  │(Redis)    │  │
              │  └───────────-┘ │ │  └───────────┘  │ │  └───────────┘  │
              └─────────────────┘ └─────────────────┘ └─────────────────┘
                    │                                              │
                    └──────────────────┬───────────────────────────┘
                                       ▼
                          ┌────────────────--─┐
                          │INTEGRATION SERVICE│
                          │  ┌───────────┐    │
                          │  │Integ API  │    │
                          │  └───────────┘    │
                          │       │           │
                          │  ┌───────────-┐   │
                          │  │Integ DB    │   │
                          │  │(PostgreSQL)│   │
                          │  └──────────-─┘   │
                          │       │           │
                          │  ┌───────────┐    │
                          │  │OpenFinance│    │
                          │  │Webhooks   │    │
                          │  └───────────┘    │
                          └────────────────--─┘
                                   │
                          ┌────────▼────────┐
                          │  Bancos Externos│
                          │   (Open Finance)│
                          └─────────────────┘


```

---

## ✉️ Contact

Email: klebervales.dev@gmail.com

Redes: [LinkedIn](https://www.linkedin.com/in/klebervales) | [GitHub](https://github.com/KleberVales)

**Kleber Vales**

Java & Spring Software Engineer 

Cloud | DevOps | Microservices | Git/Github | Docker | Kubernetes | Generative AI | Event-drive Architecture

<p align="justify">Software engineer with 5+ years of experience building scalable systems using Java, Spring Boot and cloud-native architectures. Strong background in microservices, event-driven systems and DevOps practices.<p/>

🏆 **Oracle Certified Associate – Java SE 7 Programmer**  
🏆 **Microsoft Technology Associate – Software Development Fundamentals**  
🏆 **Scrum Fundamentals Certified (SFC™)**  
🏆 **Oracle Cloud Infrastructure 2025 – DevOps Professional**  
🏆 **Oracle Cloud Infrastructure 2025 – Generative AI Professional**

🎓 **Bachelor's Degree in Computer Science**  
🎓 **MBA in Web Software Development**
