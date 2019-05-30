package by.cources.spring.task2.spring.model;

public class Author 
{
  private Long id;
  
  private String name;
  
  private String dateOfBirth;
  

  public Long getId() {
	  return id;
  }

  public void setId(Long id) {
	  this.id = id;
  }

  public String getName() {
	  return name;
  }

  public void setName(String name) {
	  this.name = name;
  }

  public String getDateOfBirth() {
	  return dateOfBirth;
  }
  
  public void setDateOfBirth(String dateOfBirth) {
	  this.dateOfBirth = dateOfBirth;
  }

  @Override
  public String toString() {
	  return "Author [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
  }

}