# Event Tracking API

REST API for tracking and managing application events.

## Tech stack

- Java 21
- Spring Boot
- PostgreSQL 16
- Docker Compose
- Flyway
- Maven

## Requirements

- Java 21
- Docker and Docker Compose

## Start PostgreSQL

```bash
docker compose -f docker/docker-compose.yml up -d
```
PostgreSQL is exposed locally on port *5433*.

## Stop PostgreSQL

```bash
docker compose -f docker/docker-compose.yml down
```

## Recreate Database

This command removes the database volume and all locally stored data:

```bash
docker compose -f docker/docker-compose.yml down -v
docker compose -f docker/docker-compose.yml up -d
```

## Run the application

### Linux and macOS
```bash
./mvnw spring-boot:run
```

### Windows
```bash
.\mvnw.cmd spring-boot:run
```

The application starts at:
```
http://localhost:8080/api 
```

## Run tests

### Linux and macOS
```bash
./mvnw clean test
```

### Windows
```bash
.\mvnw.cmd clean test
```

## Database migrations

The database schema is managed by Flyway.

Migration files are located in:
```
src/main/resources/db/migration
```
Flyway executes pending migrations automatically when the application starts.

Planned features
- JWT authentication