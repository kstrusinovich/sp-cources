package by.cources.spring.task6.service;

import by.cources.spring.task6.field.EditMode;
import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.model.Book;
import by.cources.spring.task6.repository.AuthorRepository;
import by.cources.spring.task6.repository.BookRepository;
import by.cources.spring.util.TextUtil;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;


@Service
public class BookServiceImpl implements BookService 
{
	private final BookRepository bookRepository;
  
	private final AuthorRepository authorRepository;
    
  
  public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) 
  {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  @Transactional
  @Override
  public List<Book> findBooksAll() 
  {
    return TextUtil.toList(bookRepository.findAll());
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public Author saveAuthor(Author author) {
    return authorRepository.save(author);
  }

  @Override
  @Transactional
  public List<Author> findAuthorsWithBookOlderThan(Long value) {
    return authorRepository.findWithBookOlderThan(value);
  }

  @Override
  @Transactional
  public List<Book> findBooksWithBookOlderThan(Long value) {
    return bookRepository.findOlderThan(value);
  }

  @Override
  @Transactional
  public List<Book> findBooksWithBookName(String value) {
    return bookRepository.findByName(value);
  }

  @Override
  @Transactional
  public List<Author> findAuthorsAll() {
    return authorRepository.findAll();
  }

  @Override
  public void saveBook(String mode, Book book, BindingResult result) throws Exception 
  {
	  if (result.hasErrors())
	  {
		  // for (ObjectError error : result.getAllErrors())
		  //   LOGGER.error(error.toString());	      
	      throw new Exception(result.getAllErrors().toString());	      
	  }
	  
	  try 
	  {
		  if (mode.equals(EditMode.INSERT) || mode.equals(EditMode.UPDATE))
		  {
			  bookRepository.save(book);
		  }
		  if (mode.equals(EditMode.DELETE))
		  {
			  bookRepository.delete(book);
		  }
		  
	  } catch (Exception ex){
		  throw new Exception(result.getAllErrors().toString());
	  }
	 
  }

  @Override
  public Book getForm(String mode, Long id)
  {	
	  Book book = null;
	  if (mode.equals(EditMode.INSERT))
	  {
		  book = new Book();
		  book.setAuthor(new Author());
		  
	  }
	  if (mode.equals(EditMode.UPDATE))
	  {
		  book = bookRepository.findById(id).get();
	  }
	  if (mode.equals(EditMode.DELETE))
	  {
		  book = bookRepository.findById(id).get();
	  }
	  	  
	  return book;
  }

}
