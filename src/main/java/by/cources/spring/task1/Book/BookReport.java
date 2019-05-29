package by.cources.spring.task1.Book;

import org.springframework.beans.factory.annotation.Autowired;

public class BookReport {

    @Autowired
    private Book owner;

    public void findAll()
    {
        Book name = new Book();
        System.out.println(owner);
    }
}
