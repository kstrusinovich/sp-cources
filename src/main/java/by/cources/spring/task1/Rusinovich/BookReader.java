package by.cources.spring.task1.Rusinovich;

import by.cources.spring.task1.spring.Wheel;
import org.springframework.beans.factory.annotation.Autowired;

public class BookReader {

    private Book firstBook;
    private Book secondBook;

    public Book getFirstBook() {
        return firstBook;
    }

    public void setFirstBook(Wheel firstBook) {
        this.firstBook = firstBook;
    }

    public Book getSecondBook() {
        return secondBook;
    }

    public void setSecondWheel(Wheel secondWheel) {
        this.secondBook = secondBook;
    }

    public void go() {
        firstBook.rotate();
        secondBook.rotate();
    }

}
