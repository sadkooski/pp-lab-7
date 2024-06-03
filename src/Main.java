import java.util.Scanner;

import Book.Book;
import Book.BookManager;

public class Main {
    public static void main(String[] args) {
        // Utwórz instancję BookManager
        BookManager bookManager = new BookManager();

        // Wyświetl menu i obsłuż interakcję z użytkownikiem
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("[1] Add book");
            System.out.println("[2] Remove book");
            System.out.println("[3] Update book");
            System.out.println("[4] List books");
            System.out.println("[5] Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter book details:");
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    Book newBook = new Book(title, author, isbn, year);
                    bookManager.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter title of the book to remove: ");
                    String titleToRemove = scanner.nextLine();
                    Book bookToRemove = null;
                    for (Book book : bookManager.getBooks()) {
                        if (book.getTitle().equalsIgnoreCase(titleToRemove)) {
                            bookToRemove = book;
                            break;
                        }
                    }
                    if (bookToRemove != null) {
                        bookManager.removeBook(bookToRemove);
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter details of the book to update:");
                    System.out.print("Title of the book to update: ");
                    String oldTitle = scanner.nextLine();
                    Book oldBook = null;
                    for (Book book : bookManager.getBooks()) {
                        if (book.getTitle().equalsIgnoreCase(oldTitle)) {
                            oldBook = book;
                            break;
                        }
                    }
                    if (oldBook != null) {
                        System.out.println("Enter new details:");
                        System.out.print("New title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("New author: ");
                        String newAuthor = scanner.nextLine();
                        System.out.print("New ISBN: ");
                        String newIsbn = scanner.nextLine();
                        System.out.print("New year: ");
                        int newYear = scanner.nextInt();
                        scanner.nextLine(); 
                        Book newBookInfo = new Book(newTitle, newAuthor, newIsbn, newYear);
                        bookManager.updateBook(oldBook, newBookInfo);
                        System.out.println("Book updated successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.println("List of books:");
                    for (Book book : bookManager.getBooks()) {
                        System.out.println(book.getTitle() + " - " + book.getAuthor() + " (" + book.getYear() + ")");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
