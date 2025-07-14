# 👥 HelpNest User Roles & Permissions

This document outlines the roles in HelpNest and their access privileges. Roles are embedded into the JWT token and enforced across microservices.

---

## 🔐 Roles Overview

| Role          | Description                                                   |
| ------------- | ------------------------------------------------------------- |
| `SUPER_ADMIN` | Full access to all actions and data                           |
| `ADMIN`       | Can manage users, assign tickets, view all                    |
| `ENGINEER`    | Handles tickets in their assigned group and can raise tickets |
| `REQUESTER`   | Can raise tickets and view their own tickets                  |

---

## 🧾 Role Permissions Matrix

| Action                    | REQUESTER | ENGINEER | ADMIN | SUPER\_ADMIN |
| ------------------------- | --------- | -------- | ----- | ------------ |
| Login                     | ✅         | ✅        | ✅     | ✅            |
| Raise ticket              | ✅         | ✅        | ✅     | ✅            |
| View own tickets          | ✅         | ✅        | ✅     | ✅            |
| View group tickets        | ❌         | ✅        | ✅     | ✅            |
| Assign tickets            | ❌         | ❌        | ✅     | ✅            |
| Update ticket status      | ❌         | ✅        | ✅     | ✅            |
| View all users            | ❌         | ❌        | ✅     | ✅            |
| Create/edit users         | ❌         | ❌        | ✅     | ✅            |
| Assign user roles & group | ❌         | ❌        | ✅     | ✅            |
| Access all ticket data    | ❌         | ❌        | ✅     | ✅            |

---

## 🏢 Role Behavior Summary

### 🔹 `REQUESTER`

* Typically any company employee (non-IT)
* Can raise tickets and track their status
* Cannot assign, view, or modify other tickets

### 🔹 `ENGINEER`

* Belongs to a support group (e.g., AD Support, Infra)
* Can raise tickets as well as handle incoming ones
* Can view & update tickets only within their group
* Can change status (e.g., Open → In Progress)

### 🔹 `ADMIN`

* Can manage users, assign tickets
* Has access to all ticket data
* Can view all groups and engineer availability

### 🔹 `SUPER_ADMIN`

* Only one
* Can assign admin roles to others
* Has visibility and control over the whole system

---

## 🔑 Auth System

* JWT includes: `userId`, `role`, `groupId`, `department`
* Each service performs its own role checks
* Future roles can be added easily (e.g., `APPROVER`, `LEAD_ENGINEER`)

> This role-based system ensures that access to actions and data is tightly controlled and aligned to real-world org structure.
