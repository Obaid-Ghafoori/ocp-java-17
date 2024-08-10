# Employee Management System

## Overview

The Employee Management System is a simple Java application designed to manage employee information within a company. This system leverages the Java Collections Framework to store, retrieve, and manipulate employee data efficiently. The system focuses on using lists, maps, and sets to manage employees, ensuring unique identifiers and enabling quick lookups and data manipulation.

## Features

- **Store Employee Information:** Manage employees with attributes such as `id`, `name`, `department`, and `salary`.
- **Employee List:** Maintain a list of employees using `List<Employee>`, allowing for adding, removing, and updating employee records.
- **Departmental Organization:** Organize employees by department using `Map<String, List<Employee>>`.
- **Unique Employee IDs:** Ensure that each employee has a unique ID using a `Set<Integer>`.
- **Salary Analysis:** Calculate the average salary of employees within a specific department.
- **Employee Search:** Quickly search for employees by name using a `Map<String, Employee>`.

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- An Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or Visual Studio Code

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Obaid-Ghafoori/ocp-java-17.git
cd chatper_08/employee-management
