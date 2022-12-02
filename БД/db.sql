CREATE DATABASE Taxipark
GO

USE Taxipark

GO
CREATE TABLE TaxiCars(
	carID INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	carName NVARCHAR(40) NOT NULL,
	carNumber NVARCHAR(10) NOT NULL,
	maxSpeed INT NOT NULL,
	tankCapacity FLOAT NOT NULL,
	engineCapacity FLOAT NOT NULL,
	price FLOAT NOT NULL,
	yearOfManufacture INT NOT NULL,
	fuelConsumptionPerHundred FLOAT NOT NULL,
	transmission NVARCHAR(10) NOT NULL,
	wheelDrive NVARCHAR(10) NOT NULL,
	typeOfGasoline NVARCHAR(10) NOT NULL,
	carType NVARCHAR(15) NOT NULL
)

CREATE TABLE Cars(
	carID INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	carCompany NVARCHAR(20) NOT NULL,
	carModel NVARCHAR(25) NOT NULL
)

INSERT INTO Cars(carCompany,carModel)
VALUES
('Audi','A6'),
('Audi','Q7'),
('Audi','e-Tron'),
('Audi','RS6'),
('Audi','100'),

('Bentley','Flying'),
('Bentley','Continental'),
('Bentley','Bentayga'),
('Bentley','Mulsanne'),
('Bentley','Arnage'),

('Porsche','Cayenne'),
('Porsche','911'),
('Porsche','Panamera'),
('Porsche','Cayman'),
('Porsche','Taycan'),

('SEAT','Ibiza'),
('SEAT','Leon'),
('SEAT','Altea XL'),
('SEAT','Cordoba'),
('SEAT','Toledo'),

('Skoda','Octavia'),
('Skoda','Superb'),
('Skoda','Kodiaq'),
('Skoda','Karoq'),
('Skoda','Fabia'),

('Suzuki','Vitara'),
('Suzuki','Jimny'),
('Suzuki','SX4'),
('Suzuki','Samurai'),
('Suzuki','Swift'),

('Volkswagen','Tiguan'),
('Volkswagen','Jetta'),
('Volkswagen','Golf'),
('Volkswagen','Passat'),
('Volkswagen','Touareg')