# Client Management Application

## Overview
This project is a simple client management application that provides CRUD (Create, Read, Update, Delete) functionality for managing client records. The application is designed to run in a single Java window and offers a user-friendly interface for managing client information.

## Features
- Add new clients
- View existing clients
- Edit client information
- Delete clients
- User-friendly graphical interface

## Project Structure
```
ClientManagementApp
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── control
│   │   │   │   └── MainControl.java
│   │   │   ├── model
│   │   │   │   ├── Client.java
│   │   │   │   └── ClientDAO.java
│   │   │   ├── view
│   │   │   │   ├── MainView.java
│   │   │   │   └── ClientForm.java
│   │   │   └── GestionClients.java
│   │   └── resources
│   │       └── application.properties
├── .gitignore
└── README.md
```

## Setup Instructions
1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Ensure you have Java Development Kit (JDK) installed.
4. Compile the project using your preferred IDE or command line.
5. Run the application by executing the `Gestionutilisateurs.java` file.

## Usage
- Launch the application to open the main client management window.
- Use the provided forms to add, edit, or delete client records.
- All client data is managed through the application interface.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.