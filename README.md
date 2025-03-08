# 🎓 Student Portal Backend

## 📌 Overview

This project is a backend implementation for a **Student Portal System** using **Java** and **MySQL**. It enables students to view their details and marks while allowing teachers to manage attendance and assessments efficiently.

---

## ✨ Features

✅ **Student Authentication** via Roll Number 

✅ **Teacher Authentication** via Subject Code

✅ **View Student Details & Marks** 

✅ **Insert & Update Marks and Attendance** 

✅ **Locking Assessment & Attendance Data** 

✅ **Calculate Internal Marks & Final Grades**

---

## 🛠️ Technologies Used

- **Programming Language**: Java ☕
- **Database**: MySQL 🛢️
- **JDBC**: Java Database Connectivity for MySQL 🔗

---

## 🗄️ Database Schema

This system interacts with a **MySQL database** named `studentportal`, containing the following tables:

### 📌 `student`

| Column Name | Data Type | Description         |
| ----------- | --------- | ------------------- |
| Roll\_No    | INT (PK)  | Student Roll Number |
| Name        | VARCHAR   | Student Name        |
| Department  | VARCHAR   | Department Name     |
| Year        | INT       | Year of Study       |
| Email       | VARCHAR   | Student Email       |
| Phone       | VARCHAR   | Contact Number      |
| Address     | VARCHAR   | Residential Address |

### 📌 `subject`

| Column Name | Data Type    | Description       |
| ----------- | ------------ | ----------------- |
| Code        | VARCHAR (PK) | Subject Code      |
| Name        | VARCHAR      | Subject Name      |
| Type        | VARCHAR      | Type (Theory/Lab) |

### 📌 `marks`

| Column Name     | Data Type    | Description                   |
| --------------- | ------------ | ----------------------------- |
| Roll\_No        | INT (FK)     | Student Roll Number           |
| Subject\_Code   | VARCHAR (FK) | Subject Code                  |
| Assessment1     | FLOAT        | First Assessment Marks        |
| Assessment2     | FLOAT        | Second Assessment Marks       |
| TotalInternal   | FLOAT        | Internal Marks Total          |
| Attendence1     | INT          | Attendance for Session 1      |
| Attendence2     | INT          | Attendance for Session 2      |
| TotalAttendence | INT          | Overall Attendance Percentage |
| EndSem          | FLOAT        | End Semester Exam Marks       |
| Total           | FLOAT        | Final Score                   |
| Grade           | CHAR(2)      | Final Grade                   |

### 📌 `locktable`

| Column Name   | Data Type | Description              |
| ------------- | --------- | ------------------------ |
| Subject\_Code | VARCHAR   | Subject Code             |
| Asses1        | BOOLEAN   | Assessment 1 Lock Status |
| Asses2        | BOOLEAN   | Assessment 2 Lock Status |
| Att1          | BOOLEAN   | Attendance 1 Lock Status |
| Att2          | BOOLEAN   | Attendance 2 Lock Status |

---

## 🚀 Setup Instructions

### 🔧 Prerequisites

1️⃣ Install **Java (JDK 8 or later)** ☕ 

2️⃣ Install **MySQL** 🛢️ 

3️⃣ Create a database named `studentportal` 📂 

4️⃣ Create the required tables as per the schema above 📋

### ⚙️ Configuration

Update the **database credentials** in the Java code:

```java
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentportal", "root", "password");
```

Replace `password` with your actual **MySQL password**.

### ▶️ Running the Project

```sh
javac studentport.java
java studentport
```

---

## 🎯 Usage

👩‍🎓 **Students** can **view** their details and marks. 

👨‍🏫 **Teachers** can **enter, update, and lock** marks and attendance. 

✅ **Validation** ensures only authorized users access the system.

---

## 🚀 Future Enhancements

🔹 Implement a **REST API** using **Spring Boot** 

🔹 Add **secure authentication** with passwords & roles 

🔹 Improve **error handling & logging** 

🔹 Deploy on **cloud servers** for better accessibility

---

## 👨‍💻 Author

Developed by **[DIVYA DHARSHINI B]** 🚀

