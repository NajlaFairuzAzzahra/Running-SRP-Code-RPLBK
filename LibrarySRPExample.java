import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
}

class BookRepository {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBookByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
}

class BookFormatter {
    public String formatBookInfo(Book book) {
        return String.format("Title: %s, Author: %s, ISBN: %s",
                book.getTitle(), book.getAuthor(), book.getIsbn());
    }
}

class BookLoanManager {
    public void loanBook(Book book) {
        System.out.println("Loaning out book: " + book.getTitle());
        // Logic untuk mencatat peminjaman buku
    }
}

public class LibrarySRPExample {
    public static void main(String[] args) {
        BookRepository bookRepo = new BookRepository();
        BookFormatter bookFormatter = new BookFormatter();
        BookLoanManager loanManager = new BookLoanManager();

        Book newBook = new Book("1984", "George Orwell", "9780451524935");
        bookRepo.addBook(newBook);

        Book foundBook = bookRepo.findBookByIsbn("9780451524935");
        if (foundBook != null) {
            System.out.println(bookFormatter.formatBookInfo(foundBook));
            loanManager.loanBook(foundBook);
        }
    }
}