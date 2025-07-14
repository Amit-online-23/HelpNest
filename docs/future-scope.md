# 🔭 HelpNest – Future Scope & Expansion Plan

This document outlines planned features and services to extend HelpNest beyond its MVP state.

---

## 🧩 Future Microservices

### ✅ `approval-service`

* Multi-level ticket approval logic (e.g., AD access, new user creation)
* Tracks approval status & audit logs

### ✅ `group-service`

* Manage IT support groups (e.g., AD Support, Middleware, Infra)
* Assign engineers to one or multiple groups

### ✅ `comment-service`

* Ticket comment threads
* Internal notes vs public comments
* Timestamped, user-attributed

### ✅ `file-service`

* Upload & retrieve attachments (screenshots, logs)
* Integrate with cloud storage (S3/MinIO) or local disk

### ✅ `notification-service`

* Notify engineers/admins of ticket status changes
* Email + optional WebSocket support for real-time updates

### ✅ `reporting-service`

* Dashboards for admins and engineers
* Stats like ticket resolution time, open tickets by group, SLA breaches

---

## 🛡️ Security Enhancements

* Role + department based route filtering
* 2FA/MFA support
* Login attempt rate-limiting
* JWT refresh token handling

---

## 🖼️ Frontend Enhancements

* Component-level lazy loading
* Full ticket dashboard with filters
* Role-based UI rendering
* Attachments viewer
* Comment threads per ticket
* Approval workflow UI

---

## 🧠 Long-Term Ideas

| Idea                    | Goal                               |
| ----------------------- | ---------------------------------- |
| Audit logs microservice | Every action is logged centrally   |
| HRMS integration        | Auto-create users from HRMS system |
| SLA enforcement service | Auto-flag overdue tickets          |
| Mobile app              | Android/iOS ticket tracking        |
| Voice input for tickets | Experimental user-friendly feature |

---

## 📌 Summary

HelpNest is designed to be highly modular and flexible. The MVP sets a solid base upon which robust enterprise-level features can be added incrementally.

Each service listed here is optional and can be plugged into the system at any point without affecting core operations.

> As user base grows, features like auto-escalation, cross-group support, and reporting become essential.

Let's build this one block at a time 🧱
