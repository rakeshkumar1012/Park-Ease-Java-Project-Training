# 🚗 ParkEase 

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

Park Vehicle

Remove Vehicle

Display Slots

Exit

Choose an option: 1
Enter vehicle number: KA01AB1234
Enter number of wheels (2 or 4): 2
✅ [SUCCESS] Parked at slot 1

Choose an option: 2
Enter slot number to remove: 1
Enter number of hours parked: 3
💰 Charge: Rs. 15
Do you want to view receipt? (yes/no): yes

--- Parking Receipt ---

Vehicle Number	Vehicle Type	Hours Parked	Charge
KA01AB1234	2-Wheeler	3	Rs. 15
## 📈 Applicable SOLID Principle
- **Single Responsibility Principle (SRP):**  
  Each class is responsible for a single functionality (e.g., `Vehicle` handles vehicle details, `ParkingLot` manages slots, file handling is separate).

---

## 📊 UML Diagram
Here’s the high-level UML diagram for the **ParkEase System**:

<img width="418" height="747" alt="image" src="https://github.com/user-attachments/assets/ea3d4ec5-4f45-41b3-ad73-ca55fbdfaef3" />




---

## 🔮 Future Enhancements
- Add **Date & Time Tracking** for automatic duration calculation.
- Integrate **GUI** using JavaFX or Swing.
- Implement **multi-floor parking**.
- Add **online payment support**.

---
