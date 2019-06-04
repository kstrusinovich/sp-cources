package by.cources.spring.task2.spring.model;

import java.util.Date;

public class Author {
    private Long id;
    private String name;
    private Date Bithday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBithday() {
        return Bithday;
    }

    public void setBithday(Date bithday) {
        Bithday = bithday;
    }

    @Override
    public String toString() {
        return "Author{id=" + id + ", name='" + name + "', Bithday='" + Bithday +"\'}";
    }
}
