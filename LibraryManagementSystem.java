import java.util.HashMap;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Book[ID:" + id + ", Title:" + title + ", Author:" + author + ", Available:" + isAvailable + "]";
    }
}

class BSTNode {
    Book book;
    BSTNode left, right;

    public BSTNode(Book book) {
        this.book = book;
        left = right = null;
    }
}

class BST {
    BSTNode root;

    public BST() {
        root = null;
    }

    public void insert(Book book) {
        root = insertRec(root, book);
    }

    private BSTNode insertRec(BSTNode root, Book book) {
        if (root == null) {
            return new BSTNode(book);
        }
        if (book.id < root.book.id) {
            root.left = insertRec(root.left, book);
        } else if (book.id > root.book.id) {
            root.right = insertRec(root.right, book);
        }
        return root;
    }

    public Book search(int id) {
        BSTNode node = searchRec(root, id);
        return (node != null) ? node.book : null;
    }

    private BSTNode searchRec(BSTNode root, int id) {
        if (root == null || root.book.id == id) {
            return root;
        }
        if (id < root.book.id) {
            return searchRec(root.left, id);
        }
        return searchRec(root.right, id);
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.book);
            inorderRec(root.right);
        }
    }
}

class Library {
    BST bookTree;
    HashMap<Integer, Book> bookTable;

    public Library() {
        bookTree = new BST();
        bookTable = new HashMap<>();
    }

    public void addBook(Book book) {
        bookTree.insert(book);
        bookTable.put(book.id, book);
        System.out.println("Book added: " + book);
    }

    public void borrowBook(int id) {
        Book book = bookTable.get(id);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isAvailable) {
            System.out.println("Book is already borrowed.");
        } else {
            book.isAvailable = false;
            System.out.println("You have borrowed: " + book);
        }
    }

    public void returnBook(int id) {
        Book book = bookTable.get(id);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isAvailable) {
            System.out.println("Book was not borrowed.");
        } else {
            book.isAvailable = true;
            System.out.println("Book returned: " + book);
        }
    }

    public void searchBook(int id) {
        Book book = bookTree.search(id);
        if (book == null) {
            System.out.println("Book not found in library.");
        } else {
            System.out.println("Found: " + book);
        }
    }

    public void displayAllBooks() {
        System.out.println("Library Books (inorder):");
        bookTree.inorder();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while(!exit) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    break;
                case 2:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    library.borrowBook(borrowId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                case 4:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = scanner.nextInt();
                    library.searchBook(searchId);
                    break;
                case 5:
                    library.displayAllBooks();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}

