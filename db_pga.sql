-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 07, 2023 at 11:23 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pga`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_enquiry`
--

CREATE TABLE `tbl_enquiry` (
  `enquiry_id` bigint(20) NOT NULL,
  `enquiry_place_id` bigint(20) DEFAULT NULL,
  `enquiry_tenant_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_enquiry`
--

INSERT INTO `tbl_enquiry` (`enquiry_id`, `enquiry_place_id`, `enquiry_tenant_id`) VALUES
(1, 1, 1),
(2, 3, 1),
(3, 8, 1),
(4, 9, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_owner`
--

CREATE TABLE `tbl_owner` (
  `owner_id` bigint(20) NOT NULL,
  `owner_address` varchar(255) DEFAULT NULL,
  `owner_gender` varchar(255) DEFAULT NULL,
  `owner_name` varchar(255) DEFAULT NULL,
  `owner_email` varchar(255) DEFAULT NULL,
  `owner_mobile_no` varchar(255) DEFAULT NULL,
  `owner_password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_owner`
--

INSERT INTO `tbl_owner` (`owner_id`, `owner_address`, `owner_gender`, `owner_name`, `owner_email`, `owner_mobile_no`, `owner_password`) VALUES
(1, 'Mumbai', 'Male', 'AMan', 'owner@example.com', NULL, 'owner123'),
(2, 'Pune', 'Male', 'Piyush', 'piyush@example.com', NULL, 'owner123'),
(3, 'Bengaluru', 'Female', 'Saroj', 'saroj@example.com', NULL, 'owner123'),
(4, 'Hyderabad', 'Male', 'Satish', 'owner@sample.com', '9012345673', 'owner123'),
(5, 'Chennai', 'Male', 'Ramesh', 'owner@chennai.com', '9012345674', 'owner123');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_place`
--

CREATE TABLE `tbl_place` (
  `place_id` bigint(20) NOT NULL,
  `place_address` varchar(255) DEFAULT NULL,
  `place_name` varchar(255) DEFAULT NULL,
  `place_status` bit(1) DEFAULT NULL,
  `place_owner_id` bigint(20) DEFAULT NULL,
  `place_city` varchar(255) DEFAULT NULL,
  `place_rent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_place`
--

INSERT INTO `tbl_place` (`place_id`, `place_address`, `place_name`, `place_status`, `place_owner_id`, `place_city`, `place_rent`) VALUES
(1, 'New Highway, Near view shopping mall, Mumbai', 'Harman Estate', b'0', 1, 'Mumbai', 5200),
(3, 'Cross Road, Pune', 'New Owner Place', b'1', 3, 'Pune', 3000),
(4, 'South Way Gate, Hyderabad', 'HMD', b'1', 1, 'Hyderabad', 3234),
(5, '80 Feet Road, Bengaluru', 'SK PG', b'1', 3, 'Bengaluru', 4500),
(6, 'IT Park, Chennai', 'BR Campus', b'1', 2, 'Chennai', 7200),
(7, 'North City, Bengaluru', 'ASH Co', b'1', 2, 'Bengaluru', 3500),
(8, 'XYZ Road, Pune', 'Pulse PG', b'1', 2, 'Pune', 8000),
(9, 'Example Colony, Mumbai', 'Rest House', b'1', 1, 'Mumbai', 6000),
(10, 'City West, Mumbai', 'H Nest', b'0', 1, 'Mumbai', 6700),
(11, 'M G Road, Mumbai', 'Achievers PG', b'0', 1, 'Mumbai', 4500);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tenant`
--

CREATE TABLE `tbl_tenant` (
  `tenant_id` bigint(20) NOT NULL,
  `tenant_address` varchar(255) DEFAULT NULL,
  `tenant_gender` varchar(255) DEFAULT NULL,
  `tenant_name` varchar(255) DEFAULT NULL,
  `tenant_email` varchar(255) DEFAULT NULL,
  `tenant_password` varchar(255) DEFAULT NULL,
  `tenant_mobile` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_tenant`
--

INSERT INTO `tbl_tenant` (`tenant_id`, `tenant_address`, `tenant_gender`, `tenant_name`, `tenant_email`, `tenant_password`, `tenant_mobile`) VALUES
(1, 'Hyderabad', 'male', 'Waseem', 'tenant@example.com', 'tenant123', '9922114455');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_enquiry`
--
ALTER TABLE `tbl_enquiry`
  ADD PRIMARY KEY (`enquiry_id`),
  ADD KEY `FKo6nrmap5rtksye3tr46c417j5` (`enquiry_place_id`),
  ADD KEY `FKoiqbueq7qrj0nwpqxey676s72` (`enquiry_tenant_id`);

--
-- Indexes for table `tbl_owner`
--
ALTER TABLE `tbl_owner`
  ADD PRIMARY KEY (`owner_id`);

--
-- Indexes for table `tbl_place`
--
ALTER TABLE `tbl_place`
  ADD PRIMARY KEY (`place_id`),
  ADD KEY `FKdtjbpumowexes8sdsecq8fp3s` (`place_owner_id`);

--
-- Indexes for table `tbl_tenant`
--
ALTER TABLE `tbl_tenant`
  ADD PRIMARY KEY (`tenant_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_enquiry`
--
ALTER TABLE `tbl_enquiry`
  MODIFY `enquiry_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_owner`
--
ALTER TABLE `tbl_owner`
  MODIFY `owner_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_place`
--
ALTER TABLE `tbl_place`
  MODIFY `place_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tbl_tenant`
--
ALTER TABLE `tbl_tenant`
  MODIFY `tenant_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_enquiry`
--
ALTER TABLE `tbl_enquiry`
  ADD CONSTRAINT `FKo6nrmap5rtksye3tr46c417j5` FOREIGN KEY (`enquiry_place_id`) REFERENCES `tbl_place` (`place_id`),
  ADD CONSTRAINT `FKoiqbueq7qrj0nwpqxey676s72` FOREIGN KEY (`enquiry_tenant_id`) REFERENCES `tbl_tenant` (`tenant_id`);

--
-- Constraints for table `tbl_place`
--
ALTER TABLE `tbl_place`
  ADD CONSTRAINT `FKdtjbpumowexes8sdsecq8fp3s` FOREIGN KEY (`place_owner_id`) REFERENCES `tbl_owner` (`owner_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
