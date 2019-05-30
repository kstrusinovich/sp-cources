package by.cources.spring.task1.Rusinovich;

import by.cources.spring.task1.spring.Wheel;
import org.springframework.beans.factory.annotation.Autowired;

public class BookReader {

    @Autowired
    private Book firstBook;
    @Autowired
    private Book secondBook;

    public BookReader() {
    }

    public Book getFirstBook() {
        return firstBook;
    }

    public void setFirstBook(Book firstBook) {
        this.firstBook = firstBook;
    }

    public Book getSecondBook() {
        return secondBook;
    }

    public void setSecondBook(Book secondBook) {
        this.secondBook = secondBook;
    }

    public void go() {
        firstBook.rotate();
        secondBook.rotate();
    }

}
