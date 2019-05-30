package by.cources.spring.task1.Rusinovich;

import by.cources.spring.task1.spring.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Book {

    @Autowired
    @Qualifier("bookReader1")
    private BookReader owner;

    public BookReader getOwner() {
        return owner;
    }

    public void setOwner(BookReader owner) {
        this.owner = owner;
    }

    public void rotate() {
        System.out.println(owner);
    }

}
