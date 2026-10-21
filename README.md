Smart Pantry Manager

Course: Mobile App Development 700 — Practical Assignment
Student Name: Lesedi Mokwena
Student ID: 402307216
Repository: https://github.com/Lesedimacrocs/SmartPantryManager.git

Project Overview

Smart Pantry Manager is a vibrant, user-friendly Android application designed to help users track and manage their household grocery inventory efficiently. Built with modern Android development practices, the application allows users to dynamically add typed ingredients, view their saved pantry inventory in a structured pop-up overview, and remove items seamlessly.

Features

Vibrant & Intuitive UI: Styled with a clean green-and-white theme featuring styled operational buttons and interactive dialogs.

Dynamic Item Addition: Interactive prompt allowing users to enter custom ingredient names and quantities (e.g., Rice (2 kg)).

Inventory Overview: Instant access to the full list of saved pantry items in a readable popup dialog.

Item Deletion: Quick tap-to-delete functionality with safety confirmation dialogs before removal.

Local Data Management: Powered by structured Java data structures and an integrated SQLite database helper for backend storage.

Tech Stack & Architecture

Language: Java (JDK 17+)

IDE: Android Studio

Build System: Gradle (AGP)

UI Components: Material Components, XML Layouts, AlertDialog, Toast notifications

Database: SQLite (DatabaseHelper.java)

Version Control: Git & GitHub

Getting Started

Prerequisites:

Android Studio installed

Android SDK (API 24 / Android 7.0 or higher)

Android Emulator or physical device with Developer Options enabled

Installation & Setup:

Clone the Repository:
git clone https://github.com/Lesedimacrocs/SmartPantryManager.git

Open in Android Studio:
Launch Android Studio, click Open, and select the cloned SmartPantryManager folder. Allow Gradle to sync dependencies automatically.

Run the Application:
Select your target emulator or connected physical Android device and click the Run button (green play icon).

Repository Structure

SmartPantryManager/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/lsmartpantrymanager/
│   │       │   ├── MainActivity.java
│   │       │   └── DatabaseHelper.java
│   │       └── res/
│   │           └── layout/
│   │               └── activity_main.xml
├── build.gradle
└── README.md
