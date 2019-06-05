package by.cources.spring.task3.spring.service;

import by.cources.spring.task3.spring.model.Author;
import by.cources.spring.task3.spring.model.Book;
import by.cources.spring.task3.spring.repository.AuthorRepository;
import by.cources.spring.task3.spring.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import by.cources.spring.task3.spring.repository.LanguageRepository;
import org.springframework.stereotype.Service;

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
  public List<Book> findBooksOnLanguage(String value) {
    return bookRepository.findOnLanguage(value);
  }


  @Override
  public List<Author> findAuthorsLang(String value) { return authorRepository.findByLang(value);
  }

  private <T> List<T> toList(Iterable<T> items) {
    List<T> list = new ArrayList<>();
    for (T t : items) {
      list.add(t);
    }
    return list;
  }
}
