
-- Base de datos: Sistema de Mantenimiento Vehicular
-- Autor: david
-- Evidencia: GA7-220501096-AA2-EV01
-- ============================================

CREATE DATABASE IF NOT EXISTS basededatosjava;

USE basededatosjava;

CREATE TABLE IF NOT EXISTS Vehiculo (

    idVehiculo INT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(10) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    anio INT NOT NULL,
    kilometraje INT NOT NULL

);