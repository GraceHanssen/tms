DROP DATABASE IF EXISTS taskmanagementsystem;
CREATE DATABASE taskmanagementsystem;
USE taskmanagementsystem;

DROP TABLE IF EXISTS tasks;
CREATE TABLE tasks (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  status ENUM('TODO', 'IN_PROGRESS', 'COMPLETED') NOT NULL
);

INSERT INTO tasks (title, description, status) VALUES
('Task 1', 'Description for task 1', 'TODO'),
('Develop login functionality', 'Create login page and validate user credentials', 'TODO'),
('Implement task management', 'Add ability to create, edit and delete data', 'COMPLETED'),
('Write unit tests for core functionality', 'Ensure core application features have proper test coverage', 'IN_PROGRESS'),
('Optimize database queries', 'Identify and improve slow-performing queries to improve application performance', 'TODO'),
('Refactor code for readability', 'Review and improve code structure and naming conventions', 'COMPLETED');
