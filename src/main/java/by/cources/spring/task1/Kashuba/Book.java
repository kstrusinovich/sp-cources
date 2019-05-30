package by.cources.spring.task1.Kashuba;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {

    private String page;
    private String name;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "page='" + page + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
