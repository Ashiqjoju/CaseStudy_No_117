# Music Store Management System

## Description
This project is a menu-driven console application that simulates a music store management system. The application allows users to manage albums, artists, and sales records using a MySQL database.

## Features
- **Album Management**: Add, view, update, and delete albums.
- **Artist Management**: Add, view, update, and delete artists.
- **Sales Management**: Record, view, update, and cancel sales.

## Technologies
- Java (Core)
- MySQL
- JDBC

## Setup Instructions
1. **Database Setup**:
   - Create a MySQL database named `musicstoredb`.
   - Create the following tables:

     ```sql
     CREATE TABLE Artist (
         artist_id INT PRIMARY KEY,
         name VARCHAR(100),
         genre VARCHAR(50),
         country VARCHAR(50)
     );

     CREATE TABLE Album (
         album_id INT PRIMARY KEY,
         title VARCHAR(100),
         artist_id INT,
         release_date DATE,
         price DOUBLE,
         FOREIGN KEY (artist_id) REFERENCES Artist(artist_id)
     );

     CREATE TABLE Sales (
         sale_id INT PRIMARY KEY,
         album_id INT,
         sale_date DATE,
         quantity_sold INT,
         total_price DOUBLE,
         FOREIGN KEY (album_id) REFERENCES Album(album_id)
     );
     ```

2. **Java Setup**:
   - Download the project and place the `mysql-connector-java-x.x.xx.jar` in the `lib/` directory.
   - Add the MySQL connector JAR to your project’s classpath.

3. **Run the Application**:
   - Compile and run the `main.java` class.
   - Follow the on-screen menu to manage albums, artists, and sales.

## Usage
- Select the appropriate menu option to perform operations like adding, viewing, updating, or deleting records in the system.

## Notes
- Ensure that your MySQL server is running and accessible.
- Modify the database credentials in the `main.java` file if necessary.



