# File Management System

## Overview
The **File Management System** is a Java application designed to handle file operations such as uploading, copying, moving, and deleting files in a clean and organized manner. The system ensures that file operations are atomic and supports file validation and notifications.

## Features
- Upload files to a specified directory.
- Copy files to another directory.
- Move files to a different location.
- Delete files securely.
- Notifications on file operations using the Observer pattern.
- Atomic file move operations.
- Validation of file operations (e.g., ensuring files exist before operations).

## Project Structure

The File Management System is organized into the following structure:

```
file_management_system/
│
├── src/
│   ├── main/
│   │   ├── FileManagementSystem.java
│   │   ├── FileManager.java
│   │   ├── FileObserver.java
│   │   ├── FileObserverImpl.java
│   │   ├── FileOperation.java
│   │   ├── FileValidator.java
│   │   ├── utils/
│   │   │   ├── ConfigUtils.java
│   │   │   └── FileUtils.java
│   │   └── resources/
│   │       ├── files/
│   │       │   ├── destination.md
│   │       │   └── source.md
│   │       ├── config.properties
│   │       └── logback.xml
│   └── test/
│       ├── resource/
│       │   └── mockito-extensions/
│       │       └── org.mockito.plugins.MockMaker
│       └── FileManagerTest.java
└── README.md
```

## Technologies Used
- **Java 17**: Programming language.
- **SLF4J**: Simple Logging Facade for Java (for logging).
- **Logback**: Logging framework.
- **Java NIO**: For non-blocking file operations.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Obaid-Ghafoori/ocp-java-17.git
   cd file-management-system
