# Movie Watchlist Application

A Spring Boot application that allows users to create, manage, and prioritize their movie watching plans.

## Features

- **Create and manage** movie entries in your personal watchlist
- **Rate movies** on a scale
- **Prioritize movies** to watch based on custom priority levels
- **Add comments** to each movie entry
- **Full CRUD operations** with validation 
- **Responsive UI** for both desktop and mobile viewing

## Technologies Used

- **Java** (Version 23)
- **Spring Boot** - Web framework
- **Spring Data JPA** - Data persistence
- **Hibernate** - ORM tool
- **H2 Database** - In-memory database
- **Thymeleaf** - Server-side Java template engine
- **Maven** - Dependency management
- **HTML/CSS** - Frontend styling

## Project Structure

The application follows the MVC (Model-View-Controller) architecture:

- **Model**: Entity classes in `com.Sarthak.WatchlistApplication.entity`
- **View**: Thymeleaf templates in `src/main/resources/templates`
- **Controller**: Controllers in `com.Sarthak.WatchlistApplication.controller`
- **Repository**: Data access layer in `com.Sarthak.WatchlistApplication.repositry`
- **Service**: Business logic in `com.Sarthak.WatchlistApplication.service`

## Setup Instructions

### Prerequisites
- Java JDK 23
- Maven

### Installation Steps
1. Clone the repository
   ```
   git clone https://github.com/your-username/WatchlistApplication.git
   ```

2. Navigate to the project directory
   ```
   cd WatchlistApplication
   ```

3. Build the project
   ```
   mvn clean install
   ```

4. Run the application
   ```
   mvn spring-boot:run
   ```

5. Access the application
   ```
   http://localhost:8080
   ```


## Future Enhancements

- User authentication and personalized watchlists
- Integration with movie APIs for fetching movie details
- Social sharing capabilities
- Advanced search and filter options

