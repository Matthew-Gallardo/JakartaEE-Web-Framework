
CREATE DATABASE bookstore;

\c bookstore;


CREATE SEQUENCE book_id_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE book (
    id INT DEFAULT NEXTVAL('book_id_seq') PRIMARY KEY,  
    isbn VARCHAR(20) UNIQUE NOT NULL,                 
    title VARCHAR(255) NOT NULL,                       
    author VARCHAR(255) NOT NULL,                      
    price DOUBLE PRECISION NOT NULL,                   
    quantity INTEGER NOT NULL                         
);


INSERT INTO book (isbn, title, author, price, quantity)
VALUES
    ('978-3-16-148410-0', 'The Great Gatsby', 'F. Scott Fitzgerald', 10.99, 50),
    ('978-0-452-28423-4', '1984', 'George Orwell', 8.99, 30),
    ('978-0-7432-7356-5', 'The Da Vinci Code', 'Dan Brown', 12.99, 20),
    ('978-0-316-01792-3', 'Harry Potter and the Sorcerers Stone', 'J.K. Rowling', 14.99, 100),
    ('978-1-250-30694-4', 'Where the Crawdads Sing', 'Delia Owens', 15.99, 40);

    
    
CREATE TABLE users (
  user_id INTEGER PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
);