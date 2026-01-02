# Library Management System

A robust console-based application developed in Java to efficiently manage library operations. This project demonstrates the practical application of core data structures, combining **Binary Search Trees (BST)** and **HashMaps** to optimize data storage, retrieval, and organization.

## Features

* **Add Books**: Register new books with a unique ID, Title, and Author.
* **Borrow Books**: Check out books (updates availability status automatically).
* **Return Books**: Return borrowed books to the system.
* **Search Functionality**: Instantly locate books by their unique ID.
* **Display Catalog**: View all books in the system, sorted by ID.
* **Command Line Interface (CLI)**: User-friendly menu-driven interface for easy navigation.

## Technical Implementation

This system leverages two primary data structures to balance performance and organization:

1.  **HashMap (`java.util.HashMap`)**
    * **Purpose**: Used for O(1) average time complexity lookups when borrowing or returning books.
    * **Benefit**: Ensures that checking if a book exists or is available is instantaneous, regardless of library size.

2.  **Binary Search Tree (BST)**
    * **Purpose**: Custom implementation (`BSTNode`, `BST` classes) to store book records.
    * **Benefit**: Maintains books in a sorted order by ID, allowing for efficient `inorder` traversal to display the catalog.
      
## Prerequisites

* **Java Development Kit (JDK)**: Version 8 or higher.

## How to Run

1.  **Clone the repository** (or download the source code):
    ```bash
    git clone <your-repo-url>
    cd LibraryManagementSystem/src
    ```

2.  **Compile the Java file**:
    ```bash
    javac LibraryManagementSystem.java
    ```

3.  **Execute the application**:
    ```bash
    java LibraryManagementSystem
    ```

## Usage Example

Upon running the application, you will see the following interactive menu:

```text
Library Management System Menu:
1. Add Book
2. Borrow Book
3. Return Book
4. Search Book
5. Display All Books
6. Exit
Enter your choice:
```
