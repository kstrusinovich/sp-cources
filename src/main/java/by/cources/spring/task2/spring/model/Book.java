package by.cources.spring.task2.spring.model;

public class Book {

  private Long id;
  
  private Long authorId;
  
  private String name;
  
  private int year;
  

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

public Long getAuthorId() {
	return authorId;
}

public void setAuthorId(Long authorId) {
	this.authorId = authorId;
}



public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

@Override
public String toString() {
	return "Book [id=" + id + ", authorId=" + authorId + ", name=" + name + ", year=" + year + "]";
}


  

}