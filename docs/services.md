# 🔧 HelpNest Microservices Overview

This document lists all microservices used in HelpNest with responsibilities, endpoints, and extensibility.

---

## ✅ `auth-service`

Handles authentication and JWT token generation.

### Responsibilities

* Login with username/email + password
* Issue signed JWT with claims: userId, role, department, group
* Validate credentials securely

### Endpoints

```
POST /auth/login
```

---

## ✅ `user-service`

Handles user records, roles, group mapping.

### Responsibilities

* Create/update user profiles (admin only)
* Fetch user info (self or admin views)
* Filter users by group or department

### Endpoints

```
POST /users/create          # Admin creates users
GET /users/me               # Current user profile
GET /users/by-group         # Engineers in same group
```

---

## ✅ `ticket-service`

Handles ticket lifecycle from creation to resolution.

### Responsibilities

* Create tickets by requesters
* View own tickets (requesters)
* View group tickets (engineers)
* Assign ticket (admin)
* Change status (engineers/admins)

### Endpoints

```
POST /tickets/create
GET  /tickets/my
GET  /tickets/group
PUT  /tickets/assign
PUT  /tickets/update-status
```

---

## ⏳ Future Services (Not in MVP)

### ⛔ `approval-service`

* Handle multi-stage approval logic for privileged tickets

### ⛔ `group-service`

* Manage dynamic support groups separately

### ⛔ `comment-service`

* Add ticket comments/notes

### ⛔ `file-service`

* Store and serve attachments via cloud/local

### ⛔ `reporting-service`

* Export reports and generate analytics

---

## 🧠 Key Notes

* Each service runs independently and has its own database
* All services protected with JWT
* Extensible design: just register a new route in the gateway to connect future modules

> As of MVP, 3 core services are live: auth-service, user-service, ticket-service
