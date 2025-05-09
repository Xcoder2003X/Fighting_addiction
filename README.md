# Discipline: A Habit-Tracking and Content-Monitoring Application

Discipline is a web application designed to help users improve their online habits by tracking their progress, blocking distracting websites, and monitoring violations. The app combines a **React-based frontend** with a **Spring Boot backend** to deliver a seamless experience for users aiming to build better habits.

---

## Features

### **Frontend**
- **User Authentication**: Login and registration forms with JWT-based authentication.
- **Dashboard**: Displays user statistics (streaks, violations) and progress using charts.
- **Plan Creation**: Allows users to create multi-phase plans with durations and rewards.
- **Blocked Sites Management**: Displays and manages a list of blocked websites.
- **Theme Switching**: Toggle between light and dark themes.

### **Backend**
- **User Management**: Handles user registration, authentication, and plan resets.
- **Plan Management**: Supports multi-phase plans with tracking of progress and rewards.
- **Content Monitoring**: Tracks violations when users access blocked websites.
- **Tampering Detection**: Detects inactivity or tampering with the monitoring system.
- **Blocked Sites**: Allows users to block specific websites.

---

## Project Structure

### **Frontend**
Located in the `dicipline_interface/` directory, the frontend is built with React and Material-UI.

#### Key Files:
- `src/App.js`: Main application entry point.
- `src/pages/Dashboard.jsx`: Displays user statistics and progress.
- `src/pages/Home.jsx`: Landing page for the application.
- `src/components/dashboard/PlanStepper.jsx`: Multi-phase plan creation wizard.
- `src/components/dashboard/BlockedSites.jsx`: Displays blocked websites in a data grid.
- `src/contexts/AuthContext.jsx`: Manages user authentication state.
- `src/contexts/ThemeContext.jsx`: Manages light/dark theme toggling.

#### Scripts:
- `npm start`: Runs the app in development mode.
- `npm test`: Launches the test runner.
- `npm run build`: Builds the app for production.

---

### **Backend**
Located in the `dicipline/` directory, the backend is built with Spring Boot.

#### Key Files:
- `src/main/java/com/example/dicipline/Controller`: Contains REST API controllers for authentication, plans, blocked sites, and violations.
- `src/main/java/com/example/dicipline/Service`: Contains business logic for user management, plans, content monitoring, and blocked sites.
- `src/main/java/com/example/dicipline/model`: Defines the data models (e.g., `User`, `Plan`, `Violation`).
- `src/main/java/com/example/dicipline/repository`: Contains JPA repositories for database interactions.
- `src/main/resources/application.properties`: Configuration for the application (e.g., database, JWT, scheduling).

#### Key Endpoints:
- **Authentication**:
  - `POST /api/auth/login`: Logs in a user and returns a JWT token.
  - `POST /api/auth/register`: Registers a new user.
- **Plans**:
  - `POST /api/plans`: Creates a new plan for the authenticated user.
- **Blocked Sites**:
  - `POST /api/blocked-sites`: Adds a new blocked site for the authenticated user.
- **Violations**:
  - `POST /api/violations/check`: Checks if a URL is blocked and records a violation if necessary.

#### Build and Run:
- **Build**: Use Maven to build the project: `./mvnw clean install`.
- **Run**: Start the application: `./mvnw spring-boot:run`.

---

## Installation

### Prerequisites
- **Frontend**: Node.js and npm.
- **Backend**: Java 21, Maven, and MySQL.

### Steps
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo-url.git
   cd discipline
