package by.cources.spring.task2.spring.model;

public class Book {

  private Long id;
  private String name;
  private Long authorCode;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getAuthorCode() {
	return authorCode;
}

public void setAuthorCode(Long authorCode) {
	this.authorCode = authorCode;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Book [id=" + id + ", name='" + name + "; author code="+ authorCode + "]";
  }
}