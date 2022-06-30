-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 21, 2020 at 09:18 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";



CREATE TABLE `admin` (
  `id` varchar(50) NOT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `admin` (`id`, `mail`, `password`, `name`) VALUES
("1234", 'test@test.com', '123147', 'MHAE');

CREATE TABLE `student` (
  `id` varchar(50) NOT NULL,
  `fname` VARCHAR(40)DEFAULT NULL,
  `lName` VARCHAR(40) DEFAULT NULL,
  `stdPhone` varchar(11) DEFAULT NULL,
  `class` varchar(50) DEFAULT NULL,
  `gpa` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `course` (
  `id`varchar(50) NOT NULL,
  `name` VARCHAR(40) DEFAULT NULL,
  `mid` varchar(50) DEFAULT NULL,
  `project` varchar(50) DEFAULT NULL,
  `final` varchar(50) DEFAULT NULL,
  `total` varchar(50) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `grades` (
  `sid` VARCHAR(40) DEFAULT NULL,
  `bid` VARCHAR(40) DEFAULT NULL,
  `mid` varchar(50) DEFAULT NULL,
  `project`varchar(50) DEFAULT NULL,
  `final`varchar(50) DEFAULT NULL,
  `total` varchar(50)  DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `class` (`class`);

ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

