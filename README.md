# Doctor Scheduling Module – EasyCare

## Overview

The Doctor Scheduling module is a part of the **EasyCare – Smart Hospital Management System**.
This module manages doctor availability and assigns doctors to patients based on available time slots.

It is a **console-based Java application** that simulates real-world doctor appointment management without using a database or frontend.

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

---

## Module Responsibilities

This module performs the following functions:

1. Doctor Management

   * Add doctor details
   * Store specialization
   * Maintain available time slots

2. Appointment Scheduling

   * Assign doctor to patient
   * Allocate time slot
   * Remove slot after booking

3. Schedule Tracking

   * View all appointments
   * Search patient appointment details

---

## Technologies Used

* Java (Core Java)
* Console-based interface
* ArrayList for in-memory data storage
* Git & GitHub for version control

---

## File Structure

```
EasyCare/
│
├── doctorScheduling.java
├── README.md
```

---

## How to Run

### Step 1: Compile the program

```
javac doctorScheduling.java
```

### Step 2: Run the program

```
java doctorScheduling
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
   * Slots: 10AM-11AM, 11AM-12PM

2. Assign Doctor

   * Patient ID: P1023
   * Doctor ID: 1
   * Slot: 10AM-11AM

3. View Appointment

   * Patient P1023 → Dr. Sharma at 10AM-11AM

---

## Integration with EasyCare System

This module interacts with:

* **Patient Module** – Uses Patient ID
* **Billing Module** – Provides doctor consultation details
* **Lab Module** – Doctor can refer tests (future scope)

In a full DevOps setup, this module can be converted into a **REST API service** and deployed as a microservice.

---

## Future Enhancements

* Database integration (MySQL)
* REST API using Spring Boot
* Docker containerization
* CI/CD using Jenkins
* Integration with other hospital modules

---

