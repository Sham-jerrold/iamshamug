CREATE DATABASE college_association;
USE college_association;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(20) DEFAULT 'student'
);

INSERT INTO users (username, password, role) VALUES ('admin', 'admin123', 'admin');
