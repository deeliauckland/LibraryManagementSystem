# Library Management System

A RESTful API service for managing books and authors, built with Spring Boot, JPA, and QueryDSL.

## Features

- RESTful API for book and author management
- QueryDSL integration for type-safe queries
- Optimized queries with fetch joins to avoid N+1 problem
- H2 in-memory database for development
- Automatic data initialization on startup
- Comprehensive unit tests


## Prerequisites

- Java 21 or higher
- Maven 3.6+

## Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd LibraryManagementSystem
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Connection Details
- JDBC URL: `jdbc:h2:mem:librarydb`
- Username: `sa`
- Password: (leave empty)

## 📡 API Endpoints

### Get All Books

Retrieves all books with their associated author information.

**Endpoint:**
```
GET /api/books
```

**Response Example:**
```json
[
  {
    "id": 1,
    "title": "book1 Title",
    "author": {
      "id": 1,
      "name": "author 1"
    }
  },
  {
    "id": 2,
    "title": "book2 Title",
    "author": {
      "id": 1,
      "name": "author 1"
    }
  },
  {
    "id": 3,
    "title": "book3 Title",
    "author": {
      "id": 2,
      "name": "author 2"
    }
  },
  {
    "id": 4,
    "title": "book3 Title",
    "author": {
      "id": 3,
      "name": "author 3"
    }
  }
]
```