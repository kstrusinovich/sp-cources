package by.cources.spring.task1.Rusinovich;

import by.cources.spring.task1.spring.Car;
import org.springframework.beans.factory.annotation.Autowired;

public class Book {

    @Autowired
    private BookReader owner;

    public BookReader getOwner(){ return owner; }

    public void setOwner(BookReader owner) {
        this.owner = owner;
    }

    public void rotate(){
        System.out.println(owner);
    }

}
