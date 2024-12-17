# Booking Backend System

This repository contains a **Hotel and Flight Booking Backend System** built using **Spring Boot** with **Maven** and **PostgreSQL**. The system provides APIs for managing hotel and flight bookings, offering a solid foundation for a full-fledged reservation platform.

---

## Project Overview

The **Booking Backend System** is a backend service designed to manage hotel and flight reservations. It provides RESTful APIs for creating, updating, retrieving, and deleting booking records. The system supports:

- Hotel Bookings  
- Flight Bookings  

It is designed for scalability, performance, and extensibility.

---

## Features

- **Hotel Management**:  
  - Add, update, and delete hotel details.  
  - Manage room availability and reservations.

- **Flight Management**:  
  - Add, update, and delete flight information.  
  - Manage seat reservations.

- **User Management**:  
  - Register users and authenticate securely.  

- **Booking APIs**:  
  - Create and manage hotel and flight reservations.  
  - Retrieve booking details and availability status.

- **Database Integration**:  
  - PostgreSQL used for persistent storage.  

- **Validation and Error Handling**:  
  - Ensures input validation and appropriate API error messages.

---

## Tech Stack

- **Backend Framework**: Spring Boot (Java)  
- **Build Tool**: Maven  
- **Database**: MySQL  

---

## System Design

The system follows a **layered architecture** for better separation of concerns:

1. **Controller Layer**: Handles incoming HTTP requests and routes them to services.  
2. **Service Layer**: Contains business logic.  
3. **Repository Layer**: Interfaces with the PostgreSQL database.  
4. **Entities**: Represents database tables.  
5. **DTOs**: Used for data transfer between layers.

---

## Setup and Installation

### Prerequisites

Ensure you have the following installed:

- Java 17 or later  
- Maven  
- MySQL  

### Steps to Run the Project

1. **Clone the Repository**:  
   ```bash
   git clone https://github.com/MangOo22/booking.git
   cd booking
2. **Configure Database**:
  - Create a PostgreSQL database named booking.
  - Update the database connection details in application.properties:
    ```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/booking
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
3. **Build the Project**:
  - Run the following command to package the project:
    ```bash
    mvn clean install
4. **Run the Application**:
  - Start the Spring Boot server:
    ```bash
    mvn spring-boot:run
5. **Access the APIs**:
The server will run on http://localhost:8080.
---
## Project Directory Structure
  ```bash
  src/main/java
    ├── com.booking.hotelflight
         ├── controller        # REST Controllers
         ├── service           # Service Layer
         ├── repository        # Database Repositories
         ├── model             # Entity Classes
         ├── dto               # Data Transfer Objects
         ├── exception         # Custom Exceptions
         ├── config            # Configuration Files
  src/test/java
    ├── BookingServiceTest     # Unit Tests
    ├── BookingControllerTest  # Integration Tests
  resources
    ├── application.properties # Database Configuration
```

## API Documentation**

Below are the key endpoints:

### Hotel APIs

| Method | Endpoint                  | Description                     |
|--------|---------------------------|---------------------------------|
| GET    | `/hotels`                 | List all hotels                 |
| GET    | `/hotels/{id}`            | Get hotel details by ID         |
| POST   | `/hotels`                 | Add a new hotel                 |
| PUT    | `/hotels/{id}`            | Update hotel details            |
| DELETE | `/hotels/{id}`            | Delete a hotel                  |

### Flight APIs

| Method | Endpoint                  | Description                     |
|--------|---------------------------|---------------------------------|
| GET    | `/flights`                | List all flights                |
| GET    | `/flights/{id}`           | Get flight details by ID        |
| POST   | `/flights`                | Add a new flight                |
| PUT    | `/flights/{id}`           | Update flight details           |
| DELETE | `/flights/{id}`           | Delete a flight                 |

### Booking APIs

| Method | Endpoint                  | Description                     |
|--------|---------------------------|---------------------------------|
| POST   | `/bookings/hotel`         | Create a hotel booking          |
| POST   | `/bookings/flight`        | Create a flight booking         |
| GET    | `/bookings`               | List all bookings               |
| DELETE | `/bookings/{id}`          | Cancel a booking                |

---

## Database Schema

The following tables are used in this project:

1. **hotels**  
   - Fields: `id`, `name`, `location`, `available_rooms`, `price_per_night`, `created_at`, `updated_at`.  

2. **flights**  
   - Fields: `id`, `airline`, `flight_number`, `departure_time`, `arrival_time`, `available_seats`, `price`, `created_at`, `updated_at`.  

3. **bookings**  
   - Fields: `id`, `user_id`, `booking_type` (`HOTEL`/`FLIGHT`), `reference_id`, `booking_date`, `status`.  

4. **users**  
   - Fields: `id`, `username`, `email`, `password`, `created_at`, `updated_at`.  

The database schema supports proper relationships and constraints between tables, such as foreign keys and indexing for better performance.

---

## Contact

For any inquiries or suggestions, reach out to:  

**Ahmed Nageh**  
[GitHub Profile](https://github.com/MangOo22)  
