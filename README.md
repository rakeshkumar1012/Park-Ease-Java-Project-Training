# 🚗 ParkEase System

A simple yet efficient **Java-based Parking Lot Management System** that automates parking slot allocation, fare calculation, and checkout history tracking using **Object-Oriented Programming (OOP)** concepts.

---

## 📌 Features
- **Accepts only 2 or 4-wheelers** for valid parking.
- **Automatic slot allocation** for the first available space.
- **Fare calculation** based on vehicle type and parking duration.
- **CSV file storage** for checkout history.
- **Receipt generation** upon vehicle removal.
- **Slot status display** (occupied/empty).
- Menu-driven interface for easy interaction.

---

## 🛠️ Technologies Used
- **Language:** Java
- **Concepts Implemented:**
  - Interface
  - Abstraction
  - Inheritance
  - Encapsulation
  - Nested Class
  - Static Members
  - File Handling (CSV)
  - Polymorphism

---

## 🎯 Objectives
- Efficiently manage parking slots.
- Reduce manual errors in parking operations.
- Provide quick check-in/check-out services.
- Maintain accurate historical records.

---

## 🧩 OOP Concepts in Action
- **Interface:** `ParkingOperations` for defining core parking operations.
- **Abstraction:** Abstract class `Vehicle` hides implementation details.
- **Inheritance:** `SimpleVehicle` inherits from `Vehicle`.
- **Encapsulation:** Private fields with getters/setters.
- **Nested Class:** `ParkingLot.Slot` for slot representation.
- **Static Members:** Track total revenue and constants.

---

## 📝 Sample Output
=== Parking Lot Menu ===
1. Park Vehicle
2. Remove Vehicle
3. Display Slots
4. Exit
Choose an option: 1
Enter vehicle number: KA01AB1234
Enter number of wheels (2 or 4): 2
[SUCCESS] Parked at slot 1

Choose an option: 2
Enter slot number to remove: 1
Enter number of hours parked: 3
Charge: Rs. 15
Do you want to view receipt? (yes/no): yes
--- Receipt ---
Vehicle Number: KA01AB1234
Vehicle Type: 2-Wheeler
Hours Parked: 3
Charge: Rs. 15
----------------
