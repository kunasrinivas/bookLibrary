# Book Library REST API

A simple and intuitive REST API for managing a book library, built with Spring Boot and Java 21. This application allows you to create, read, update, and delete books through easy-to-use endpoints.

## Overview

The Book Library API is a backend service that helps you manage a collection of books. You can add new books, view all books in your library, search for specific books by ID, and remove books you no longer need. The application uses an in-memory H2 database, making it perfect for development and testing.

## Technologies Used

- **Java 21** - Modern Java features and performance
- **Spring Boot 4.0.0** - Framework for building the REST API
- **Spring Data JPA** - Database operations made simple
- **H2 Database** - In-memory database for quick testing
- **Maven** - Dependency management and build tool

## Getting Started

### Prerequisites

Before running this application, make sure you have:

- Java 21 or higher installed on your computer
- Maven installed (or use the included Maven wrapper)

### How to Run

1. **Clone or download this project** to your computer
2. **Navigate to the project folder** in your terminal:

   ```bash
   cd booklibrary
   ```
3. **Run the application** using Maven:

   ```bash
   mvn spring-boot:run
   ```

   Or on Windows, use the Maven wrapper:

   ```bash
   ./mvnw.cmd spring-boot:run
   ```
4. **The application will start** on `http://localhost:8080`

## How to Use the API

### Welcome Message

Visit the home page to see a welcome message:

```
GET http://localhost:8080/
```

### Add a New Book

You can add books using either **JSON format** or **form data**.

**Using JSON** (recommended for programmatic access):

```bash
curl -X POST http://localhost:8080/save \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Clean Code",
    "author": "Robert C. Martin",
    "revision": "1st Edition",
    "yearOfPublication": "2008",
    "price": 42.50
  }'
```

**Using Form Data** (works with HTML forms):

```bash
curl -X POST http://localhost:8080/save \
  -d "name=Clean Code" \
  -d "author=Robert C. Martin" \
  -d "revision=1st Edition" \
  -d "yearOfPublication=2008" \
  -d "price=42.50"
```

The API will save your book and return a list of all books in the library.

### View All Books

Get a complete list of all books in your library:

```
GET http://localhost:8080/allBooks
```

This returns a JSON array with all books, including their auto-generated IDs.

### Find a Specific Book

Search for a book using its ID:

```
GET http://localhost:8080/findBook/1
```

Replace `1` with the ID of the book you want to find.

### Delete a Book

Remove a book from your library:

```
GET http://localhost:8080/deleteBook/1
```

Replace `1` with the ID of the book you want to delete.

## Book Information

Each book in the library contains:

- **ID** - Automatically generated unique identifier
- **Name** - The title of the book
- **Author** - Who wrote the book
- **Revision** - Edition or version (e.g., "1st Edition", "Revised")
- **Year of Publication** - When the book was published
- **Price** - Cost of the book in your preferred currency

## Example Usage

Here's a complete example of using the API:

1. **Add your first book:**

   ```bash
   curl -X POST http://localhost:8080/save \
     -H "Content-Type: application/json" \
     -d '{"name":"The Pragmatic Programmer","author":"Andrew Hunt","revision":"2nd","yearOfPublication":"2019","price":35.99}'
   ```
2. **See all books:**

   ```bash
   curl http://localhost:8080/allBooks
   ```
3. **Find book with ID 1:**

   ```bash
   curl http://localhost:8080/findBook/1
   ```
4. **Delete that book:**

   ```bash
   curl http://localhost:8080/deleteBook/1
   ```

## Database

The application uses an **H2 in-memory database**, which means:

- Data is stored only while the application is running
- When you restart the application, all data is cleared
- Perfect for development and testing
- No additional database setup required

If you want to keep your data permanently, you can configure a different database like MySQL or PostgreSQL by updating the `application.properties` file.

## Project Structure

```
booklibrary/
├── src/main/java/com/kuna/booklibrary/
│   ├── BooklibraryApplication.java    # Main application entry point
│   ├── controller/
│   │   └── BookController.java        # REST API endpoints
│   ├── entity/
│   │   └── Book.java                  # Book data model
│   ├── repository/
│   │   └── BookRepository.java        # Database operations
│   └── service/
│       └── BookService.java           # Business logic
├── pom.xml                            # Maven configuration
└── README.md                          # This file
```

## Development Notes

- The application runs on port **8080** by default
- Spring Boot DevTools is included for automatic restarts during development
- The API returns JSON responses for easy integration with frontend applications
- No authentication is required (add security for production use)

## Future Enhancements

Ideas for extending this project:

- Add update functionality (PUT endpoint)
- Implement search by author or title
- Add pagination for large book collections
- Include book categories or genres
- Add authentication and user management
- Implement a frontend interface
- Switch to a persistent database

## License

This is a learning project and is free to use and modify.

## Contact

For questions or suggestions about this project, feel free to reach out or open an issue in the repository.

---

**Happy Reading! 📚**
