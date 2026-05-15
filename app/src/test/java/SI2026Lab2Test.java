import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SI2026Lab2Test {

    @Test
    void searchBookEveryStatementTest() {

        Library library = new Library();

        library.addBook(new Book(
                "Clean Code",
                "Robert Martin",
                "Programming"
        ));

        // Test 1 - exception path
        assertThrows(IllegalArgumentException.class, () -> {
            library.searchBookByTitle("");
        });

        // Test 2 - return results
        List<Book> found = library.searchBookByTitle("Clean Code");

        assertNotNull(found);
        assertEquals(1, found.size());

        // Test 3 - return null
        List<Book> notFound = library.searchBookByTitle("Harry Potter");

        assertNull(notFound);
    }

    @Test
    void borrowBookEveryBranchTest() {

        Library library = new Library();

        library.addBook(new Book(
                "The Hobbit",
                "Tolkien",
                "Fantasy"
        ));

        // Test 1 - empty title/author
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });

        // Test 2 - successful borrow
        library.borrowBook("The Hobbit", "Tolkien");

        // Test 3 - already borrowed
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("The Hobbit", "Tolkien");
        });

        // Test 4 - book not found
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Harry Potter", "Rowling");
        });
    }

    @Test
    void borrowBookMultipleConditionTest() {

        Library library = new Library();

        library.addBook(new Book(
                "The Hobbit",
                "Tolkien",
                "Fantasy"
        ));

        // A = true, B = true
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });

        // A = true, B = false
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Tolkien");
        });

        // A = false, B = true
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("The Hobbit", "");
        });

        // A = false, B = false
        library.borrowBook("The Hobbit", "Tolkien");
    }

    @Test
    void searchBookMultipleConditionTest() {

        Library library = new Library();

        Book availableBook = new Book(
                "Clean Code",
                "Robert Martin",
                "Programming"
        );

        Book borrowedBook = new Book(
                "Java",
                "James Gosling",
                "Programming"
        );

        borrowedBook.setBorrowed(true);

        library.addBook(availableBook);
        library.addBook(borrowedBook);

        // A = true, B = true
        List<Book> result1 = library.searchBookByTitle("Clean Code");
        assertNotNull(result1);

        // A = true, B = false
        List<Book> result2 = library.searchBookByTitle("Java");
        assertNull(result2);

        // A = false, B = true
        List<Book> result3 = library.searchBookByTitle("Python");
        assertNull(result3);

        // A = false, B = false
        List<Book> result4 = library.searchBookByTitle("JavaScript");
        assertNull(result4);
    }
}