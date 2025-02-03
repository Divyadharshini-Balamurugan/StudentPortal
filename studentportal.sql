-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 02, 2025 at 01:51 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentportal`
--

-- --------------------------------------------------------

--
-- Table structure for table `locktable`
--

CREATE TABLE `locktable` (
  `ID` int(11) NOT NULL,
  `Subject_Code` varchar(100) NOT NULL,
  `Att1` int(11) NOT NULL,
  `Att2` int(11) NOT NULL,
  `Asses1` int(11) NOT NULL,
  `Asses2` int(11) NOT NULL,
  `EndSem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `locktable`
--

INSERT INTO `locktable` (`ID`, `Subject_Code`, `Att1`, `Att2`, `Asses1`, `Asses2`, `EndSem`) VALUES
(1, 'MA5451', 0, 0, 0, 0, 0),
(2, 'XC5451', 0, 0, 0, 0, 0),
(3, 'XC5452', 0, 0, 0, 0, 0),
(4, 'XC5454', 0, 0, 0, 0, 0),
(5, 'XC5461', 0, 0, 0, 0, 0),
(6, 'XC5462', 0, 0, 0, 0, 0),
(7, 'XC5463', 0, 0, 0, 0, 0),
(8, 'XC5453', 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `Mark_ID` int(11) NOT NULL,
  `Roll_No` int(11) DEFAULT NULL,
  `Subject_code` varchar(11) NOT NULL,
  `Attendence1` int(3) NOT NULL,
  `Attendence2` int(3) NOT NULL,
  `Attendence3` int(3) NOT NULL,
  `Assessment1` float NOT NULL,
  `Assessment2` float NOT NULL,
  `Assessment3` float NOT NULL,
  `TotalAttendence` int(3) NOT NULL,
  `TotalInternal` float NOT NULL,
  `EndSem` float NOT NULL,
  `Total` float NOT NULL,
  `Grade` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`Mark_ID`, `Roll_No`, `Subject_code`, `Attendence1`, `Attendence2`, `Attendence3`, `Assessment1`, `Assessment2`, `Assessment3`, `TotalAttendence`, `TotalInternal`, `EndSem`, `Total`, `Grade`) VALUES
(1, 2001, 'MA5451', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(2, 2002, 'MA5451', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(3, 2003, 'MA5451', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(4, 2004, 'MA5451', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(5, 2005, 'MA5451', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(6, 2001, 'XC5451', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(7, 2002, 'XC5451', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(8, 2003, 'XC5451', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(9, 2004, 'XC5451', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(10, 2005, 'XC5451', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(11, 2001, 'XC5452', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(12, 2002, 'XC5452', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(13, 2003, 'XC5452', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(14, 2004, 'XC5452', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(15, 2005, 'XC5452', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(16, 2001, 'XC5453', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(17, 2002, 'XC5453', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(18, 2003, 'XC5453', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(19, 2004, 'XC5453', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(20, 2005, 'XC5453', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(21, 2001, 'XC5454', 0, 0, 0, 40, 0, 0, 0, 10, 0, 0, '-'),
(22, 2002, 'XC5454', 0, 0, 0, 30, 0, 0, 0, 7.5, 0, 0, '-'),
(23, 2003, 'XC5454', 0, 0, 0, 50, 0, 0, 0, 12.5, 0, 0, '-'),
(24, 2004, 'XC5454', 0, 0, 0, 70, 0, 0, 0, 17.5, 0, 0, '-'),
(25, 2005, 'XC5454', 0, 0, 0, 90, 0, 0, 0, 22.5, 0, 0, '-'),
(26, 2001, 'XC5461', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(27, 2002, 'XC5461', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(28, 2003, 'XC5461', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(29, 2004, 'XC5461', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(30, 2005, 'XC5461', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(31, 2001, 'XC5462', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(32, 2002, 'XC5462', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(33, 2003, 'XC5462', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(34, 2004, 'XC5462', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(35, 2005, 'XC5462', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(36, 2001, 'XC5463', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(37, 2002, 'XC5463', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(38, 2003, 'XC5463', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(39, 2004, 'XC5463', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-'),
(40, 2005, 'XC5463', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Roll_No` int(9) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `DOB` date NOT NULL,
  `Department` varchar(100) NOT NULL,
  `Branch` varchar(100) NOT NULL,
  `Degree_program` varchar(30) NOT NULL,
  `Date_of_Join` date NOT NULL,
  `Sem_No` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Roll_No`, `Name`, `DOB`, `Department`, `Branch`, `Degree_program`, `Date_of_Join`, `Sem_No`) VALUES
(2001, 'B.Divya', '2003-12-01', 'Mathematics', 'M.sc IT', 'PG', '2022-12-01', 4),
(2002, 'B.Dharshini', '2004-10-02', 'Mathematics', 'M.sc IT', 'PG', '2022-08-27', 4),
(2003, 'V.Shalini', '2004-11-20', 'Mathematics', 'M.Sc IT', 'PG', '2022-08-26', 4),
(2004, 'S.Ramya', '2004-10-02', 'Mathematics', 'M.Sc IT', 'PG', '2022-08-27', 4),
(2005, 'R.Bala', '2003-12-01', 'Mathematics', 'M.Sc IT', 'PG', '2022-12-01', 4);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `Code` varchar(100) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Sem` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`Code`, `Name`, `Type`, `Sem`) VALUES
('MA5451', 'PROBABILITY AND STATISTICS', 'T', 4),
('XC5451', 'THEORY OF COMPUTATION', 'T', 4),
('XC5452', 'DATABASE MANAGEMENT SYSTEM', 'T', 4),
('XC5453', 'JAVA AND INTERNET PROGRAMMING', 'T', 4),
('XC5454', 'COMPUTER NETWORKS', 'LT', 4),
('XC5461', 'JAVA AND INTERNET PROGRAMMING LABORATORY', 'L', 4),
('XC5462', 'DATABASE MANAGEMENT SYSTEM LABORATORY', 'L', 4),
('XC5463', 'COMPUTATIONAL LABORATORY USING R', 'L', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `locktable`
--
ALTER TABLE `locktable`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD PRIMARY KEY (`Mark_ID`),
  ADD KEY `test` (`Roll_No`),
  ADD KEY `test2` (`Subject_code`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Roll_No`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`Code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `locktable`
--
ALTER TABLE `locktable`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `marks`
--
ALTER TABLE `marks`
  MODIFY `Mark_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `test` FOREIGN KEY (`Roll_No`) REFERENCES `student` (`Roll_No`) ON DELETE CASCADE,
  ADD CONSTRAINT `test2` FOREIGN KEY (`Subject_code`) REFERENCES `subject` (`Code`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
