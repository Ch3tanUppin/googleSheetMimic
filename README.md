# Java Spreadsheet Application

This project is a backend implementation of a web application that mimics the core functionalities of Google Sheets. The focus is on providing spreadsheet-like operations, mathematical functions, and data quality tools via REST APIs. There is no frontend included in this version.

---

## Features

### 1. Mathematical Functions
APIs to support:
- **SUM**: Calculates the sum of a range of cells.
- **AVERAGE**: Calculates the average of a range of cells.
- **MAX**: Returns the maximum value from a range of cells.
- **MIN**: Returns the minimum value from a range of cells.
- **COUNT**: Counts the number of cells with numeric values in a range.

### 2. Data Quality Functions
APIs to support:
- **TRIM**: Removes leading and trailing whitespace from a cell.
- **UPPER**: Converts text in a cell to uppercase.
- **LOWER**: Converts text in a cell to lowercase.
- **REMOVE_DUPLICATES**: Removes duplicate rows from a selected range.
- **FIND_AND_REPLACE**: Finds and replaces specific text within a range of cells.

---

## Installation and Usage
- **Prerequisites
- **Java 17+
- **Maven 3.6+
The backend server will start at http://localhost:8080

##API End Point
- **Math Functions
- http://localhost:8080/api/sheets/calculate
- http://localhost:8080/api/sheets/text/transform
  
