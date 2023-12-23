CREATE DATABASE IF NOT EXISTS university;

USE university;

CREATE TABLE IF NOT EXISTS Abiturient (
    id INT AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(255),
    first_name VARCHAR(255),
    patronymic VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(20),
    average_score DECIMAL(4,2),
    birth_year INT
);

INSERT INTO Abiturient (last_name, first_name, patronymic, address, phone, average_score, birth_year) VALUES
('Іванов', 'Іван', 'Іванович', 'Київ', '123456789', 85.5, 2000),
('Петров', 'Петро', 'Петрович', 'Львів', '987654321', 75.0, 1999),
('Сидоров', 'Сидір', 'Сидорович', 'Одеса', '111222333', 90.2, 2001),
('Кузнецов', 'Дмитро', 'Сергійович', 'Харків', '555666777', 78.7, 1998),
('Смірнов', 'Олексій', 'Миколаєвич', 'Дніпро', '999888777', 88.0, 2002),
('Михайлов', 'Андрій', 'Ігорович', 'Запоріжжя', '444333222', 92.8, 1997),
('Новіков', 'Артем', 'Олегович', 'Вінниця', '777888999', 80.5, 2000),
('Васильєв', 'Євген', 'Павлович', 'Рівне', '333444555', 87.3, 1999),
('Морозов', 'Сергій', 'Володимирович', 'Суми', '666555444', 94.1, 2001),
('Коваленко', 'Оксана', 'Іванівна', 'Полтава', '222111000', 79.6, 2002);
