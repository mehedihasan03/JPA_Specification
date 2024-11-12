# User Search API with Spring Boot and JPA Specifications

This project demonstrates a REST API for searching `Users` based on multiple criteria using **Spring Boot**, **JPA**, and **JPA Specifications**. It allows filtering users by `firstName`, `lastName`, and `age` parameters, with flexible criteria using dynamic specifications.

## Features

- **REST API** for retrieving users based on dynamic search criteria
- **Spring Data JPA Specifications** for building flexible and maintainable queries
- **Pattern Matching** on `firstName` and `lastName`
- **Age Filtering** that allows searching for users above a specified age
- Clean and modular design with controllers, services, and repository layers separated for maintainability

## Project Structure

- **ProductController**: Exposes the `/users` API endpoint for searching users.
- **UserService**: Contains business logic for user search.
- **UserRepository**: Extends `JpaSpecificationExecutor` to support specification-based queries.
- **UserSpecification**: Provides reusable JPA Specifications for various filter criteria (like `firstName`, `lastName`, and `age`).

## API Endpoints

### Search Users

**Endpoint**: `GET /users`

#### Query Parameters
- `firstName` (optional): Filter users by their first name (case-insensitive, partial match)
- `lastName` (optional): Filter users by their last name (case-insensitive, partial match)
- `age` (optional): Filter users older than a specified age

#### Sample Request
```http
GET /users?firstName=John&lastName=Doe&age=25
```
#### Sample Response
```
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "age": 30
  },
  {
    "id": 2,
    "firstName": "Jane",
    "lastName": "Doe",
    "email": "jane.doe@example.com",
    "age": 28
  }
]
```
## Implementation Details
### Specification-based Filtering
  The application uses JPA Specifications to dynamically build queries based on input parameters. Each filter criterion is represented as a specification:

- **First Name Filter:** Matches records where firstName contains the specified value (case-insensitive).
- **Last Name Filter:** Matches records where lastName contains the specified value (case-insensitive).
- **Age Filter:** Matches records where age is greater than the specified value.
## Dependencies
- **Spring Boot**
- **Spring Data JPA**
- **Postgres SQL**

