# Doctor Scheduling Module – EasyCare

## Overview

The **Doctor Scheduling module** is a part of the **EasyCare – Smart Hospital Management System**.

This module manages **doctor availability and appointment scheduling**, allowing patients to be assigned to doctors based on available time slots.

The application is a **console-based Java program** built with a **service layer architecture**, tested using **JUnit 5**, and managed using **Maven** for dependency and build management.

The module demonstrates **modular software design, unit testing, and DevOps-ready development practices**.

---

# Features

## Doctor Management
- Add new doctors
- Store doctor specialization
- Maintain available time slots

## Appointment Scheduling
- Assign doctor to patient using **Patient ID**
- Allocate available time slots
- Prevent double booking of slots
- Remove slot once it is booked

## Appointment Tracking
- View all doctors and their schedules
- View all appointments
- Search appointments by **Patient ID**

## Testing
- Unit testing using **JUnit 5**
- Automated test execution using **Maven Surefire Plugin**

---

# Module Responsibilities

## 1. Doctor Management
Handles all doctor-related operations:
- Add doctor details
- Store doctor specialization
- Maintain available appointment slots

## 2. Appointment Scheduling
Responsible for assigning doctors to patients:
- Allocate doctor slots
- Validate doctor availability
- Prevent slot conflicts

## 3. Schedule Tracking
Provides appointment tracking capabilities:
- View all appointments
- Search appointments by Patient ID

---

# Technologies Used

| Technology | Purpose |
|------------|--------|
| Java 17 | Core application development |
| Maven | Build automation and dependency management |
| JUnit 5 | Unit testing framework |
| Java Collections (ArrayList) | In-memory data storage |
| Git & GitHub | Version control |
| VS Code | Development environment |

---

# Project Structure

```
EasyCare/
│
└── DoctorScheduling/
    │
    └── maven_demo/tutorial_demo
        │
        ├── pom.xml
        │
        ├── src
        │   │
        │   ├── main
        │   │   └── java/tutorial
        │   │       │
        │   │       ├── doctorScheduling.java
        │   │       ├── DoctorService.java
        │   │
        │   └── test
        │       └── java/tutorial
        │           │
        │           └── DoctorServiceTest.java
        │
        └── target
            ├── classes
            ├── test-classes
            └── surefire-reports
```

**Package Name:** `tutorial`

---

# Application Architecture

The module follows a **layered architecture**.

```
Console UI Layer
       │
       ▼
doctorScheduling.java
       │
       ▼
Service Layer
DoctorService.java
       │
       ▼
Data Models
Doctor
Appointment
```

### Components

**doctorScheduling.java**
- Console user interface
- Handles user input and menu navigation

**DoctorService.java**
- Contains business logic
- Manages doctors and appointments

**DoctorServiceTest.java**
- JUnit 5 test cases
- Verifies service layer functionality

**Doctor & Appointment**
- Data model classes used for storing doctor and appointment information

---

# Maven Configuration

The project uses **Maven for dependency management and build automation**.

### Key Configuration

- Java Version: **17**
- Testing Framework: **JUnit 5**

### Main Dependency

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```

---

# How to Run the Application

### Step 1 – Navigate to project directory

```
cd EasyCare/DoctorScheduling/maven_demo/tutorial_demo
```

### Step 2 – Compile the project

```
mvn compile
```

### Step 3 – Run the application

```
java -cp target/classes tutorial.doctorScheduling
```

---

# Running Unit Tests

To execute all unit tests:

```
mvn test
```

### Expected Output

```
Tests run: 7
Failures: 0
Errors: 0
BUILD SUCCESS
```

Test reports are generated in:

```
target/surefire-reports
```

---

# Sample Menu

```
=== Doctor Scheduling Module ===
1. Add Doctor
2. View Doctors
3. Assign Doctor to Patient
4. View All Appointments
5. Search Appointment by Patient ID
6. Exit
```

---

# Example Workflow

### Step 1 – Add Doctor

Name: Dr Sharma  
Specialization: General Physician  
Slots: 10AM, 11AM

### Step 2 – Assign Doctor

Patient ID: P101  
Doctor ID: 1  
Slot: 10AM

### Step 3 – View Appointment

Patient P101 → Dr Sharma at 10AM

---

# Unit Testing

The project contains **7 unit tests** covering:

- Doctor creation
- Successful appointment booking
- Slot conflict detection
- Invalid doctor ID
- Slot availability validation
- Appointment retrieval by patient
- Handling patients with no appointments

Testing ensures **business logic correctness and reliability**.

---

# Integration with EasyCare System

This module interacts with other EasyCare components:

| Module | Interaction |
|------|------|
| Patient Module | Uses Patient ID for scheduling |
| Billing Module | Consultation billing |
| Lab Module | Doctor test referrals |

The **service layer architecture** allows easy integration with future APIs.

---

# DevOps Readiness

The project follows practices that support DevOps pipelines:

- Modular architecture
- Automated unit testing
- Maven build system
- Dependency management
- Git version control

It can be integrated with:

- Jenkins CI/CD pipelines
- Docker containers
- Microservice architectures

---

# Future Enhancements

Planned improvements include:

- Database integration using **MySQL**
- REST API development using **Spring Boot**
- Containerization with **Docker**
- CI/CD pipeline integration using **Jenkins**
- Full hospital management system integration

---

# Author

**Pranoti Jadhav**

B.Tech – Information Technology  
MKSSS Cummins College of Engineering for Women  
Pune, India