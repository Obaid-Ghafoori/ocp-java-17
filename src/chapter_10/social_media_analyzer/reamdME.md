# Social Media Analytics System

## Overview

This project implements a Social Media Analytics System to apply Stream API concepts in Java with a clean architecture approach. The application processes user activity data to provide various analytics, such as filtering, sorting, grouping, and aggregating data.

## Features

- **Filter User Activities:** Identify users or activities based on specific criteria.
- **Sort Activities:** Organize activities by date, popularity, or engagement.
- **Group Activities:** Categorize activities by type or user.
- **Aggregate Insights:** Compute metrics such as total engagement and average posts.
- **Find Specific Data:** Retrieve specific user activities or top performers.

## Architecture

The system is designed using clean architecture principles to ensure separation of concerns and maintainability.

### Layers

- **Domain Layer:**
    - **UserActivity:** Core entity representing user activities.
    - **UserActivityRepository:** Interface for data access operations.

- **Application Layer:**
    - **UserActivityService:** Business logic for processing user activities.

- **Infrastructure Layer:**
    - **UserActivityRepositoryImpl:** Implementation of data access operations.

- **UI Layer:**
    - **AnalyticsController:** Handles user interactions and displays analytics results.

### Diagram

*Note: Include the UML diagram image file in the `uml` directory.*

## Getting Started

### Prerequisites

- Java 17 or later
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/Obaid-Ghafoori/ocp-java-17.git
   cd chatper_10/social-media-analytics
