package Book;
import java.util.ArrayList;
import java.util.List;

public class BookManager implements BookOperations {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
        // Dodajemy początkowe książki
        books.add(new Book("Wiedźmin: Ostatnie życzenie", "Andrzej Sapkowski", "ISBN1", 1993));
        books.add(new Book("Wiedźmin: Miecz przeznaczenia", "Andrzej Sapkowski", "ISBN2", 1992));
        books.add(new Book("Wiedźmin: Krew elfów", "Andrzej Sapkowski", "ISBN3", 1994));
        books.add(new Book("Wiedźmin: Czas pogardy", "Andrzej Sapkowski", "ISBN4", 1995));
        books.add(new Book("Wiedźmin: Chrzest ognia", "Andrzej Sapkowski", "ISBN5", 1996));
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    @Override
    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Book removed: " + book.getTitle());
        } else {
            System.out.println("Book not found: " + book.getTitle());
        }
    }

    @Override
    public void updateBook(Book oldBook, Book newBook) {
        int index = books.indexOf(oldBook);
        if (index != -1) {
            books.set(index, newBook);
            System.out.println("Book updated: " + oldBook.getTitle());
        } else {
            System.out.println("Book not found: " + oldBook.getTitle());
        }
    }

    @Override
    public List<Book> getBooks() {
        System.out.println("List of books:");
        return books;
    }}