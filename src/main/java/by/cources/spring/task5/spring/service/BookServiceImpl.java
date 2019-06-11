package by.cources.spring.task5.spring.service;

import by.cources.spring.task5.spring.model.Author;
import by.cources.spring.task5.spring.model.Book;
import by.cources.spring.task5.spring.model.Language;
import by.cources.spring.task5.spring.repository.AuthorRepository;
import by.cources.spring.task5.spring.repository.BookRepository;
import by.cources.spring.task5.spring.repository.LanguageRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private final LanguageRepository languageRepository;

  public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, LanguageRepository languageRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
    this.languageRepository = languageRepository;
  }

  @Transactional
  @Override
  public List<Book> findBooksAll() {
    return toList(bookRepository.findAll());
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public Author saveAuthor(Author author) {
    return authorRepository.save(author);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public Book saveBook(Book book) {
    return bookRepository.save(book);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public Book saveBookOnly(Book book) {

    List<Language> languageList = languageRepository.findAll();
    Long idLanguage = book.getLanguage().getId();
    for(Language languageDB : languageList){
      if(idLanguage == languageDB.getId()){
        book.setLanguage(languageDB);
      }
    }
    List<Author> authorList = authorRepository.findAll();
    Long idAuthor = book.getAuthor().getId();
    for(Author authorDB : authorList){
      if(idAuthor == authorDB.getId()){
        book.setAuthor(authorDB);
      }
    }
    return bookRepository.save(book);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public Book saveBookAndNewLang(Book book) {

    List<Language> languageList = languageRepository.findAll();
    String nameLanguage = book.getLanguage().getLanguageName();
    for(Language languageDB : languageList){
      if(nameLanguage.equals(languageDB.getLanguageName())){
        book.setLanguage(languageDB);
      }
    }
    return bookRepository.save(book);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public Language saveLanguage(Language language) {
    return languageRepository.save(language);
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
  @Transactional
  public List<Language> findLanguagesAll() {
    return languageRepository.findAll();
  }

  @Override
  @Transactional
  public Language findLanguageById(Long value) {
    return languageRepository.findById(value);
  }

 /* @Override
  public Book saveBook(Book book) {
    return bookRepository.save(book);
  }*/

  private <T> List<T> toList(Iterable<T> items) {
    List<T> list = new ArrayList<>();
    for (T t : items) {
      list.add(t);
    }
    return list;
  }
}
