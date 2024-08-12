# Java-Database-Connectivity

This developed using Java Swing for the graphical user interface (GUI) and MySQL for database management. It provides a user-friendly interface to perform basic CRUD (Create, Read, Update, Delete) operations on student records.

Features
Select Student Record: Retrieve and display student details by entering a student ID.
Insert New Record: Add new student records into the database with details such as name, mobile number, gender, state, address, and preferred programming language.
Update Record: Modify existing student records based on student ID.
Delete Record: Remove student records from the database using student ID.
Clear Fields: Reset all input fields and selections.

Components
JFrame: The main window of the application.
JLabels: Text labels for input field descriptions and headings.
JTextFields: Input fields for student ID, name, and mobile number.
JTextArea: Multi-line text area for entering the student address.
JComboBox: Dropdown menu for selecting the state.
JRadioButtons: Radio buttons for selecting gender and programming language.
JButtons: Action buttons for performing operations like Select, Insert, Update, Delete, and Clear.

Database
MySQL: The relational database used to store student records.
Tables: The database contains a student table with the following columns:
Id (INT)
Name (VARCHAR)
Mobile_no (VARCHAR)
Gender (VARCHAR)
State (VARCHAR)
Address (TEXT)
prog_lang (VARCHAR)
