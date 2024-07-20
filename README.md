# infogain_bus_ticket_resevration
InfoGain Bus Ticket Reservation System



To Register [Dev Mode]
![image](https://github.com/user-attachments/assets/c76ed8b2-c29d-4939-8a75-37913a3e0635)


To Register [User Mode]

To Login [Dev Mode]
![image](https://github.com/user-attachments/assets/635cb2a3-05ee-4238-bad0-d3f9ee1729d2)

To Login [User Mode]


# Bus Ticket Reservation System

## Overview

This project is a backend implementation of a bus ticket reservation system using a microservice architecture with Spring Boot. The system allows users to search for buses, view schedules, select seats, and make reservations. It includes user authentication and a mechanism to temporarily block seats to prevent race conditions during booking.

## Microservices

1. **User Service**: Manages user authentication and profiles.
2. **Bus Service**: Handles bus information, routes, and schedules.
3. **Reservation Service**: Manages seat reservations and availability.
4. **Payment Service**: Simulates payment processing.

## Technologies

- **Spring Boot** for microservice creation.
- **Spring Data JPA** for database interaction.
- **Spring Security** for user authentication.
- **Eureka** for service discovery.
- **Feign** for inter-service communication.
- **MySQL** for the database.

## Setup and Installation

### Prerequisites

- Java 11 or higher
- Maven
- Docker (optional for containerization)

### Steps

1. Clone the repository:

    ```bash
    git clone https://github.com/your-repo/bus-ticket-reservation-system.git
    cd bus-ticket-reservation-system
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

3. Run the microservices:

    ```bash
    cd user-service
    mvn spring-boot:run

    cd ../bus-service
    mvn spring-boot:run

    cd ../reservation-service
    mvn spring-boot:run

    cd ../payment-service (optional)
    mvn spring-boot:run
    ```

4. Alternatively, you can use Docker to run the services (if Dockerfile is provided):

    ```bash
    docker-compose up
    ```

## API Endpoints

### User Service

- **Register User**: `POST /users/register`
    ```json
    {
        "username": "john_doe",
        "password": "password123",
        "email": "john.doe@example.com"
    }
    ```

- **Login User**: `POST /users/login`
    ```json
    {
        "username": "john_doe",
        "password": "password123"
    }
    ```

### Bus Service

- **Search Buses**: `GET /buses/search?route={route}&departureTime={departureTime}`

### Reservation Service

- **Block Seat**: `POST /reservations/block`
    ```json
    {
        "busId": 1,
        "seatNumber": "A1",
        "userId": 1
    }
    ```

- **Reserve Seat**: `POST /reservations/reserve`
    ```json
    {
        "busId": 1,
        "seatNumber": "A1",
        "userId": 1
    }
    ```

### Payment Service (Optional)

- **Process Payment**: `POST /payments/process`
    ```json
    {
        "reservationId": 1,
        "amount": 50.0
    }
    ```

## Data Model

### User

| Field    | Type   |
|----------|--------|
| id       | Long   |
| username | String |
| password | String |
| email    | String |

### Bus

| Field          | Type   |
|----------------|--------|
| id             | Long   |
| route          | String |
| departureTime  | String |
| arrivalTime    | String |

### Booking

| Field         | Type        |
|---------------|-------------|
| id            | Long        |
| busId         | Long        |
| userId        | Long        |
| seatNumber    | String      |
| paid          | boolean     |
| blocked       | boolean     |
| blockedUntil  | LocalDateTime |

## Exception Handling

Global exception handling is implemented to manage various errors, including user not found, reservation conflicts, and generic errors.

## Contributing

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For questions or suggestions, please contact us at akashnkumar1@gmail.com.
