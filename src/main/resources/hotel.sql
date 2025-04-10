-- Crear la base de datos
CREATE DATABASE gestion_hotel;

-- Usar la base de datos
USE gestion_hotel;

-- Tabla principal: hotel
CREATE TABLE hotel (
  habitaciones INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  location VARCHAR(255) NOT NULL
);

-- Segunda tabla: empleados
CREATE TABLE empleados (
  empleado_id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  puesto VARCHAR(255) NOT NULL,
  salario DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (empleado_id)
);

-- Tercera tabla: reservas
CREATE TABLE reservas (
  reserva_id INT NOT NULL AUTO_INCREMENT,
  nombre_huesped VARCHAR(255) NOT NULL,
  fecha_entrada VARCHAR(10) NOT NULL,
  fecha_salida VARCHAR(10) NOT NULL,
  numero_habitacion INT NOT NULL,
  PRIMARY KEY (reserva_id)
);
