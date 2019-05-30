package by.cources.spring.task1.valery;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;

public class Book {
  private String bookName;

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  @Override
  public String toString() {
    return "Book{" +
            "bookName='" + bookName + '\'' +
            '}';
  }
=======
public class Book {

	private String name;
	private String autor;

	public Book(String name) {
		this.name = name;
	}
	
	public Book(String name, String autor) {
		super();
		this.name = name;
		this.autor = autor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", autor=" + autor + "]";
	}

>>>>>>> origin/master
}