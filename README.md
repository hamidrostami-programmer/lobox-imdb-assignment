# Lobox IMDb Assignment

Technical assignment implementation using Java 11, Spring Boot and H2 Database.

## Overview

This project imports IMDb datasets into an embedded H2 database and exposes REST APIs for querying and analyzing the imported data.

The application is designed as a multi-module Maven project with a layered architecture.

### Modules

| Module | Responsibility |
|----------|----------|
| imdb-common | DTOs, constants, shared classes |
| imdb-da | Data access layer and repositories |
| imdb-si | Service interfaces |
| imdb-biz | Business logic implementation |
| imdb-web | REST controllers and web configuration |

---

## Implemented Requirements

### Requirement 1

Import IMDb datasets into the application.

Implemented datasets:

- title.basics.tsv.gz
- title.ratings.tsv.gz

Features:

- Streaming gzip processing
- JdbcTemplate batch inserts
- H2 embedded database
- Genre normalization

  
Example:

GET /api/imdb/importDataset

---

### Requirement 4

Get a genre from the user and return the best title for each year based on:

- Average Rating
- Number of Votes

Implementation details:

- SQL Window Function (ROW_NUMBER)
- Genre normalization
- Database indexing

Example:

GET /api/imdb/highRatedTitlesByGenre?genre=Drama

---

### Requirement 5

Count how many HTTP requests have been received since application startup.

Example:

GET /api/imdb/requestCount

---

## Not Implemented

Due to time constraints, the following requirements were not completed:

### Requirement 2

Return all titles where:

- Director and writer are the same person
- The person is still alive

Planned datasets:

- title.crew.tsv.gz
- name.basics.tsv.gz

### Requirement 3

Return all titles in which two actors have both played.

Planned dataset:

- title.principals.tsv.gz

The existing import framework can be extended to support these datasets.

---

## Performance

Environment:

- Java 11
- Spring Boot
- H2 Embedded Database

Results:

| Operation | Duration |
|------------|------------|
| Dataset Import | ~7 minutes |
| Query #4 (Drama) | ~30 seconds |

Performance optimizations applied:

- JdbcTemplate batch inserts
- Genre normalization
- Database indexing
- Reduced table scans

---

## Future Improvements

- Implement requirements #2 and #3
- Add additional unit and integration tests
- Complete Exception Handleing
- Introduce PostgreSQL support
- Additional query tuning and execution plan optimization

---

## Technologies

- Java 11
- Spring Boot
- Spring Data JPA
- JdbcTemplate
- Maven
- H2 Database
- JUnit 5
- Mockito
