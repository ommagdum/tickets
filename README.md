# 🎫 Event Ticket Platform

A full-stack event ticketing system built with Spring Boot and React, featuring QR code ticket generation, real-time validation, and role-based access control.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-green)
![React](https://img.shields.io/badge/React-18+-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)
![License](https://img.shields.io/badge/license-MIT-green)

## 🚀 Features

- **Event Management**: Create, update, and delete events with multiple ticket types
- **Ticket Sales**: Purchase tickets with real-time inventory tracking
- **QR Code Generation**: Automatic QR code creation for digital tickets
- **Ticket Validation**: Scan QR codes or manual entry for event check-in
- **Role-Based Access**: Organizer, Attendee, and Staff user roles
- **OAuth2 Authentication**: Secure login via Keycloak
- **Real-time Search**: Filter and search published events

## 🛠️ Tech Stack

**Backend:**
- Java 21 + Spring Boot 3.4.4
- Spring Security + OAuth2
- Spring Data JPA + PostgreSQL
- MapStruct + Lombok
- ZXing (QR Code Generation)

**Frontend:**
- React 18 + TypeScript
- Tailwind CSS + shadcn/ui
- Vite

**Infrastructure:**
- Docker + Docker Compose
- Keycloak (OAuth2/OIDC)
- Adminer (Database UI)

## 📋 Prerequisites

- Java 21+
- Node.js 18+
- Docker & Docker Compose
- Maven 3.9+

## ⚡ Quick Start

### 1. Start Infrastructure

```bash
docker-compose up -d
```

This starts PostgreSQL (5432), Keycloak (9090), and Adminer (8888).

### 2. Configure Keycloak

1. Go to `http://localhost:9090` (admin/admin)
2. Create realm: `event-ticket-platform`
3. Create client: `event-ticket-platform-app` (public, redirect: `http://localhost:5173/callback`)
4. Create roles: `ROLE_organizer`, `ROLE_attendee`, `ROLE_staff`
5. Create users and assign roles

### 3. Run Backend

```bash
mvn clean compile
mvn spring-boot:run
```

Backend runs on `http://localhost:8080`

### 4. Run Frontend

```bash
cd frontend
npm install --force
npm run dev
```

Frontend runs on `http://localhost:5173`

## 📁 Project Structure

```
src/
├── main/java/com/devtiro/tickets/
│   ├── config/              # Security & app configuration
│   ├── controllers/         # REST endpoints
│   ├── domain/
│   │   ├── entities/        # JPA entities
│   │   └── dtos/           # Data transfer objects
│   ├── exceptions/          # Custom exceptions
│   ├── mappers/            # MapStruct mappers
│   ├── repositories/        # Spring Data repos
│   └── services/           # Business logic
└── resources/
    ├── application.properties
    └── META-INF/orm.xml
```

## 🔐 API Endpoints

### Public
- `GET /api/v1/published-events` - Search events
- `GET /api/v1/published-events/{id}` - Event details

### Organizer (ROLE_organizer)
- `POST /api/v1/events` - Create event
- `GET /api/v1/events` - List my events
- `PUT /api/v1/events/{id}` - Update event
- `DELETE /api/v1/events/{id}` - Delete event

### Attendee (ROLE_attendee)
- `POST /api/v1/events/{eventId}/ticket-types/{typeId}/ticket` - Purchase
- `GET /api/v1/tickets` - My tickets
- `GET /api/v1/tickets/{id}/qr-codes` - QR code image

### Staff (ROLE_staff)
- `POST /api/v1/ticket-validations` - Validate ticket

## 🗄️ Database Schema

**Key Entities:**
- `users` - User accounts
- `events` - Event information
- `ticket_types` - Ticket categories per event
- `tickets` - Purchased tickets
- `qr_codes` - Generated QR codes (Base64)
- `ticket_validations` - Validation history

## 🔑 Environment Variables

```properties
# Database
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=change-me-in-prod!

# Keycloak
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:9090/realms/event-ticket-platform
```

## 🧪 Testing

```bash
mvn test
```

## 📦 Build & Deploy

```bash
# Build JAR
mvn clean package

# Build Docker image
docker build -t event-ticket-platform .

# Run container
docker run -p 8080:8080 event-ticket-platform
```

## 🎯 Key Features Explained

### QR Code Generation
- Uses ZXing library
- ID embedded in QR code
- Base64 storage in PostgreSQL
- One active QR per ticket

### Concurrency Control
- Pessimistic locking on ticket purchase
- Prevents overselling
- Atomic operations with `@Transactional`

### Security
- JWT-based authentication
- Role extraction from Keycloak tokens
- Endpoint-level authorization
- CSRF disabled (stateless API)

## 🤝 Contributing

1. Fork the repository
2. Create feature branch (`git checkout -b feature/amazing`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing`)
5. Open Pull Request
