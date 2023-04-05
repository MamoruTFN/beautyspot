-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2023 at 06:17 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `beautyspot`
--
CREATE DATABASE IF NOT EXISTS `beautyspot` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `beautyspot`;
-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DistrictID` int(11) NOT NULL,
  `ProvinceID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `type` enum('Atplace') COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Atplace',
  `price` double NOT NULL,
  `currentDate` date NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `PaymentID` int(11) NOT NULL,
  `PromotionID` int(11) NOT NULL,
  `ReservationID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE `promotion` (
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `percentDiscount` double NOT NULL,
  `PromotionID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ProvinceID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `currentDate` date NOT NULL,
  `reservationDate` date NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `otherGroupId` int(11) DEFAULT NULL,
  `ReservationID` int(11) NOT NULL,
  `PromotionID` int(11) NOT NULL,
  `StoreID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `RoleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`name`, `RoleID`) VALUES
('ROLE_Staff', 1),
('ROLE_Customer', 2),
('ROLE_Admin', 3);

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

CREATE TABLE `store` (
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `openTime` date NOT NULL,
  `closeTime` date NOT NULL,
  `phoneNumber` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` enum('Nail','Hair','Spa') COLLATE utf8_unicode_ci NOT NULL,
  `StoreID` int(11) NOT NULL,
  `subdistrictID` int(11) NOT NULL,
  `UserID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `subdistrict`
--

CREATE TABLE `subdistrict` (
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `subdistrictID` int(11) NOT NULL,
  `DistrictID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `pwd` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phonenumber` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `UserID` int(11) NOT NULL,
  `RoleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`name`, `email`, `pwd`, `phonenumber`, `UserID`, `RoleID`) VALUES
('user1', 'user1@hotmail.com', '$2a$10$KblNhJga0KjWFe3pPsz2FeWiJ1uU9qVMoCOJ2M.FxCjSnbXuivsPm', '0896345911', 1, 2),
('user2', 'user2@hotmail.com', '$2a$10$KblNhJga0KjWFe3pPsz2FeWiJ1uU9qVMoCOJ2M.FxCjSnbXuivsPm', '0896345911', 2, 2),
('admin', 'admin@hotmail.com', '$2a$10$KblNhJga0KjWFe3pPsz2FeWiJ1uU9qVMoCOJ2M.FxCjSnbXuivsPm', '0896345911', 3, 3),
('staff1', 'staff1@hotmail.com', '$2a$10$KblNhJga0KjWFe3pPsz2FeWiJ1uU9qVMoCOJ2M.FxCjSnbXuivsPm', '0896345911', 4, 1),
('staff2', 'staff2@hotmail.com', '$2a$10$KblNhJga0KjWFe3pPsz2FeWiJ1uU9qVMoCOJ2M.FxCjSnbXuivsPm', '0896345911', 5, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`DistrictID`),
  ADD KEY `TC_District113` (`ProvinceID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`PaymentID`),
  ADD UNIQUE KEY `TC_Payment103` (`ReservationID`),
  ADD UNIQUE KEY `TC_Payment100` (`PromotionID`),
  ADD KEY `TC_Payment116` (`PromotionID`),
  ADD KEY `TC_Payment114` (`ReservationID`),
  ADD KEY `TC_Payment115` (`UserID`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`PromotionID`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`ProvinceID`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`ReservationID`),
  ADD KEY `TC_Reservation120` (`UserID`),
  ADD KEY `TC_Reservation121` (`PromotionID`),
  ADD KEY `TC_Reservation119` (`StoreID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`RoleID`);

--
-- Indexes for table `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`StoreID`),
  ADD UNIQUE KEY `TC_Store112` (`UserID`),
  ADD KEY `TC_Store124` (`subdistrictID`),
  ADD KEY `TC_Store123` (`UserID`);

--
-- Indexes for table `subdistrict`
--
ALTER TABLE `subdistrict`
  ADD PRIMARY KEY (`subdistrictID`),
  ADD KEY `TC_subdistrict125` (`DistrictID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserID`),
  ADD KEY `TC_User126` (`RoleID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `district`
--
ALTER TABLE `district`
  MODIFY `DistrictID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `PaymentID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `promotion`
--
ALTER TABLE `promotion`
  MODIFY `PromotionID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `province`
--
ALTER TABLE `province`
  MODIFY `ProvinceID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `ReservationID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `RoleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `store`
--
ALTER TABLE `store`
  MODIFY `StoreID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subdistrict`
--
ALTER TABLE `subdistrict`
  MODIFY `subdistrictID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `district`
--
ALTER TABLE `district`
  ADD CONSTRAINT `FK_District50` FOREIGN KEY (`ProvinceID`) REFERENCES `province` (`ProvinceID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `FK_Payment49` FOREIGN KEY (`PromotionID`) REFERENCES `promotion` (`PromotionID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Payment51` FOREIGN KEY (`ReservationID`) REFERENCES `reservation` (`ReservationID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Payment56` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK_Reservation48` FOREIGN KEY (`PromotionID`) REFERENCES `promotion` (`PromotionID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Reservation54` FOREIGN KEY (`StoreID`) REFERENCES `store` (`StoreID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Reservation57` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `store`
--
ALTER TABLE `store`
  ADD CONSTRAINT `FK_Store55` FOREIGN KEY (`subdistrictID`) REFERENCES `subdistrict` (`subdistrictID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Store59` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subdistrict`
--
ALTER TABLE `subdistrict`
  ADD CONSTRAINT `FK_subdistrict45` FOREIGN KEY (`DistrictID`) REFERENCES `district` (`DistrictID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_User52` FOREIGN KEY (`RoleID`) REFERENCES `role` (`RoleID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
