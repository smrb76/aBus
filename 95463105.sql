-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2018 at 10:51 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `95463105`
--
DROP DATABASE IF EXISTS `95463105`;
CREATE DATABASE IF NOT EXISTS `95463105` DEFAULT CHARACTER SET utf8 COLLATE utf8_persian_ci;
USE `95463105`;

-- --------------------------------------------------------

--
-- Table structure for table `employee_details`
--

DROP TABLE IF EXISTS `employee_details`;
CREATE TABLE `employee_details` (
  `idnumber` int(3) NOT NULL,
  `firstname` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `lastname` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `employee_details`
--

INSERT INTO `employee_details` (`idnumber`, `firstname`, `lastname`, `username`, `password`) VALUES
(0, '', '', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tour_details`
--

DROP TABLE IF EXISTS `tour_details`;
CREATE TABLE `tour_details` (
  `id` int(3) NOT NULL,
  `bus_no` varchar(5) COLLATE utf8_persian_ci NOT NULL,
  `bus_source` varchar(10) COLLATE utf8_persian_ci NOT NULL,
  `bus_dest` varchar(10) COLLATE utf8_persian_ci NOT NULL,
  `depart_date` date NOT NULL,
  `depart_time` varchar(10) COLLATE utf8_persian_ci NOT NULL,
  `price` int(50) NOT NULL,
  `total_seat` int(4) NOT NULL,
  `corReserve` varchar(10) COLLATE utf8_persian_ci NOT NULL,
  `requestOfReserve` varchar(4) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tour_details`
--

INSERT INTO `tour_details` (`id`, `bus_no`, `bus_source`, `bus_dest`, `depart_date`, `depart_time`, `price`, `total_seat`, `corReserve`, `requestOfReserve`) VALUES
(1, '123', 'tehran', 'qazvin', '2018-07-11', '12:00', 123000, 45, 'YES', 'YES'),
(2, '321', 'shiraz', 'tehran', '2018-07-26', '14:00', 40000, 45, 'NO', 'NO'),
(3, 'B141', 'Tehran', 'Kish', '2018-09-14', '18:30', 250000, 65, 'NO', 'NO'),
(4, 'Y138', 'Qom', 'Qazvin', '2018-09-25', '19:30', 32000, 32, 'YES', 'YES'),
(5, 'R312', 'Esfehan', 'Shiraz', '2018-10-11', '14:30', 45000, 35, 'YES', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `tour_user`
--

DROP TABLE IF EXISTS `tour_user`;
CREATE TABLE `tour_user` (
  `id` int(3) NOT NULL,
  `username` varchar(20) COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `tour_user`
--

INSERT INTO `tour_user` (`id`, `username`) VALUES
(1, 'admin'),
(4, 'amin69'),
(5, 'javaddi'),
(2, 'admin'),
(5, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details` (
  `idnumber` int(3) NOT NULL,
  `firstname` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `lastname` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `username` varchar(30) COLLATE utf8_persian_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_persian_ci NOT NULL,
  `email_id` varchar(30) COLLATE utf8_persian_ci NOT NULL,
  `web_url` varchar(30) COLLATE utf8_persian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`idnumber`, `firstname`, `lastname`, `username`, `password`, `email_id`, `web_url`) VALUES
(3123, 'seyed', 'bazrgari', 'admin', 'admin', '', ''),
(313, 'amin', 'gholami', 'amin69', '1234', 'amin69@gmail.com', ''),
(754, 'javad', 'javadi', 'javaddi', '9876', 'javaddi@gmail.com', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tour_details`
--
ALTER TABLE `tour_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tour_user`
--
ALTER TABLE `tour_user`
  ADD KEY `fk01_id` (`id`),
  ADD KEY `fk02_username` (`username`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tour_details`
--
ALTER TABLE `tour_details`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tour_user`
--
ALTER TABLE `tour_user`
  ADD CONSTRAINT `fk01_id` FOREIGN KEY (`id`) REFERENCES `tour_details` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk02_username` FOREIGN KEY (`username`) REFERENCES `user_details` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
