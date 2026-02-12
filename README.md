# Doctor Scheduling Module – EasyCare

## Overview

The Doctor Scheduling module is a part of the **EasyCare – Smart Hospital Management System**.
This module manages doctor availability and assigns doctors to patients based on available time slots.

It is a **console-based Java application** with a separate service layer and **JUnit 5 unit testing**, designed following basic DevOps and modular development practices.

---

## Features

* Add new doctors
* Store doctor specialization
* Manage available time slots
* Assign doctor to a patient using **Patient ID**
* Prevent double booking of slots
* View all doctors and their schedules
* View all appointments
* Search appointments by Patient ID
* Unit testing using **JUnit 5**

---

## Module Responsibilities

### 1. Doctor Management

* Add doctor details
* Store specialization
* Maintain available time slots

### 2. Appointment Scheduling

* Assign doctor to patient
* Allocate time slot
* Remove slot after booking

### 3. Schedule Tracking

* View all appointments
* Search patient appointment details

---

## Technologies Used

* Java (Core Java)
* Console-based interface
* ArrayList for in-memory data storage
* JUnit 5 for unit testing
* Git & GitHub for version control

---

## Project Structure

```
EasyCare/
│
└── DoctorScheduling/
    │
    ├── doctorScheduling.java       # Console UI
    ├── DoctorService.java          # Business logic layer
    ├── DoctorServiceTest.java      # JUnit 5 test cases
    ├── Doctor.class
    ├── Appointment.class
    └── other compiled class files
```

**Package Name:** `DoctorScheduling`

---

## How to Run the Application

### Step 1: Navigate to project root

```
cd EasyCare
```

### Step 2: Compile

```
javac DoctorScheduling/*.java
```

### Step 3: Run

```
java DoctorScheduling.doctorScheduling
```

---

## Running Unit Tests (JUnit 5)

### Step 1: Compile with JUnit classpath

```
javac -cp .:junit-platform-console-standalone-1.10.0.jar DoctorScheduling/*.java
```

### Step 2: Execute tests

```
java -jar junit-platform-console-standalone-1.10.0.jar -cp . --scan-classpath
```

Expected output:

```
Test run finished
[ 7 tests successful ]
```

---

## Sample Menu

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

## Example Workflow

1. Add Doctor

   * Name: Dr. Sharma
   * Specialization: General Physician
   * Slots: 10AM–11AM, 11AM–12PM

2. Assign Doctor

   * Patient ID: P1023
   * Doctor ID: 1
   * Slot: 10AM–11AM

3. View Appointment

   * Patient P1023 → Dr. Sharma at 10AM–11AM

---

## Integration with EasyCare System

This module interacts with:

* **Patient Module** – Uses Patient ID
* **Billing Module** – Provides consultation details
* **Lab Module** – Doctor can refer tests (future scope)

The business logic is implemented in `DoctorService`, making the module ready for future API or microservice integration.

---

## DevOps Readiness

* Modular structure (UI + Service layer)
* Automated unit testing with JUnit 5
* Can be integrated into CI/CD pipelines (Jenkins)
* Ready for containerization and microservice conversion

---

## Future Enhancements

* Database integration (MySQL)
* REST API using Spring Boot
* Docker containerization
* CI/CD pipeline using Jenkins
* Integration with other hospital modules
