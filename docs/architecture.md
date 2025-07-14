# 📐 HelpNest Architecture

## 🧭 Overview

HelpNest is an internal IT ticketing and support platform designed with a modular, scalable microservices architecture. Each domain service operates independently to ensure clean separation of concerns and ease of future extension.

---

## 🧱 High-Level Architecture

```
User ──▶ [Angular Frontend] ──▶ [API Gateway] ──▶ Microservices
                                        │
                                        └──▶ [auth-service]
                                        └──▶ [user-service]
                                        └──▶ [ticket-service]
```

---

## 🧩 Services

| Service          | Description                                             |
| ---------------- | ------------------------------------------------------- |
| `auth-service`   | Handles login, authentication, and JWT token issuance.  |
| `user-service`   | Manages user data, roles, departments, and group links. |
| `ticket-service` | Handles ticket creation, updates, and assignments.      |

> Future services like `approval-service`, `group-service`, and `comment-service` can be added seamlessly.

---

## 📡 Communication

* RESTful API over HTTP
* Services communicate via REST endpoints
* Authorization token (JWT) passed in `Authorization` header

---

## 🗃️ Data Storage

* All services use **PostgreSQL**
* Each service manages its own schema (database-per-service pattern)

---

## ⚙️ Deployment Ready

* Dockerized microservices
* Ready for CI/CD with GitHub Actions
* Can be deployed via Docker Compose or Kubernetes

---

## 🔒 Security

* JWT Token-based authentication
* Role-based access enforced in services
* All endpoints protected via middleware/gateway-level guards

---

## 🌱 Extensibility

Thanks to the microservices design, new features like:

* Comments
* Attachments
* Approval Flow
* Reporting can be added without rewriting core systems.

---

## ✅ Status: MVP Phase

We are currently building the base architecture for HelpNest MVP with three services:

* `auth-service`
* `user-service`
* `ticket-service`

These form the foundational core, designed to be extendable and robust from Day 1.
