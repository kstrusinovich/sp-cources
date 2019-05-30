package by.cources.spring.task2.spring.model;

public class Author {

    private int id;
    private String nameAuthor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    @Override
    public String toString(){
        return  "Author {id=" + id + ", name='" + nameAuthor + "\'}";
    }
}
