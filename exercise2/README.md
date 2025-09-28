# Smart Office Facility – Console Application

## Overview

This project is a **console-based Smart Office Facility Management System**.
It demonstrates **design patterns, SOLID principles, and OOP best practices** while handling:

* Room configuration
* Room booking and cancellation
* Occupancy detection (via sensors)
* Automatic control of lights and air conditioning
* Automatic release of bookings if rooms remain unoccupied for more than 5 minutes

---

## Key Features

### Functional Requirements

1. Configure number of meeting rooms and their capacities.
2. Book and cancel conference rooms.
3. Occupancy detection: at least **2 occupants** required to mark a room as occupied.
4. Auto-release bookings for rooms that are not occupied within **5 minutes**.
5. Lights and AC are automatically turned **ON** when occupied and **OFF** when unoccupied.

### Optional Enhancements Implemented

* Background scheduler checks bookings and releases rooms automatically.
* Robust validation and error handling for invalid inputs.
* Clean console interface with `help` command.

---

## Design Patterns Applied

1. **Singleton Pattern**

   * `OfficeConfig` and `BookingSystem` are single instances to ensure global consistency.

2. **Observer Pattern**

   * `OccupancySensor` notifies observers (`LightController`, `ACController`) when occupancy changes.

3. **Command Pattern**

   * Each operation (config, book, cancel, add occupant, status) is a separate command class.
   * Supports easy extension of new commands without modifying core logic.

---

## Project Structure

```
exercise2/
│
├── command/           # Command pattern implementation
│   ├── Command.java
│   ├── ConfigRoomCommand.java
│   ├── BookRoomCommand.java
│   ├── CancelRoomCommand.java
│   ├── AddOccupantCommand.java
│   └── RoomStatusCommand.java
│
├── model/             # Core domain models
│   ├── Room.java
│   └── Booking.java
│
├── observer/          # Observer pattern implementation
│   ├── OccupancyObserver.java
│   ├── OccupancySensor.java
│   ├── LightController.java
│   └── ACController.java
│
├── singleton/         # Singleton instances
│   ├── OfficeConfig.java
│   └── BookingSystem.java
│
├── utils/             # Utilities
│   ├── Validator.java
│   └── AutoReleaseScheduler.java
│
└── SmartOfficeDemo.java   # Main console application
```

---

## How to Run

1. Clone the repository

```bash
git clone https://github.com/shyam-210/EI_Study/tree/main/exercise2
cd exercise2
```

2. Compile the code

```bash
javac model\*.java singleton\*.java observer\*.java command\*.java utils\*.java SmartOfficeDemo.java

```

3. Run the demo

```bash
cd../
java exercise2.SmartOfficeDemo
```

---

## Example Usage

```
Smart Office Facility Demo. Type 'help' for commands.

> config room count 2
Office configured with 2 meeting rooms.

> config room max capacity 1 5
Room 1 maximum capacity set to 5.

> block 1 09:00 60
Room 1 booked from 2025-09-27T09:00 for 60 minutes.

> add occupant 1 1
Room 1 occupancy insufficient to mark as occupied.

> add occupant 1 2
Room 1 is now occupied by 2 persons.
Lights for Room 1 turned ON.
AC for Room 1 turned ON.

> add occupant 1 0
Room 1 is now unoccupied.
Lights for Room 1 turned OFF.
AC for Room 1 turned OFF.
Room 1 is now unoccupied. Booking released. AC and lights off.

> status 1
Room 1 [capacity=5, occupants=0, occupied=false, booked=false]

> exit
Exiting Smart Office Demo.
```

---
