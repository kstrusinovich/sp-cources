package by.cources.spring.task4.spring.service;

import by.cources.spring.task4.spring.model.Author;
import by.cources.spring.task4.spring.model.Book;
import by.cources.spring.task4.spring.model.Language;
import by.cources.spring.task4.spring.repository.AuthorRepository;
import by.cources.spring.task4.spring.repository.BookRepository;
import by.cources.spring.task4.spring.repository.LanguageRepository;
import by.cources.spring.util.TextUtil;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService
{
  private final BookRepository bookRepository;
  
  private final AuthorRepository authorRepository;
  
  private final LanguageRepository languageRepository;

  
  public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository,
		  LanguageRepository languageRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
    this.languageRepository = languageRepository;
  }

  @Transactional
  @Override
  public List<Book> findBooksAll() {
    return TextUtil.toList(bookRepository.findAll());
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

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public Book saveBookAndLanguage(Author author, String bookName, Long year, 
		  String languageName, boolean isDoubles)
  {	  
	  //
	  Language language = languageRepository.getByName(languageName);
	  if (language==null || isDoubles)
	  {
		  language = new Language();
		  language.setName(languageName); 
	  }
	  
	  Book book = new Book();
	  book.setAuthor(author);
	  book.setName(bookName);
	  book.setPublishedIn(year);   
	  book.setLanguage(language);
    
	  bookRepository.save(book);    
	  
	  System.out.println("   Saved book with id = " + book.getId() + " & language with id = " + language.getId());
	  
	  return bookRepository.save(book);
  }
   
  @Override
  public List<Language> findLanguagesAll() 
  {
	  return TextUtil.toList(languageRepository.findAll());	
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public Author saveAuthor(String lastName, String firstName, LocalDate dateOfBirth) 
  {
	  Author author = new Author();
	  author.setLastName(lastName);
	  author.setFirstName(firstName);
	  author.setDateOfBirth(dateOfBirth);
	  authorRepository.save(author);
	  System.out.println("   Saved author with id = " + author.getId());
	  return author;
  }
  
}