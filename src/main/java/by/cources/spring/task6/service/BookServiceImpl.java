package by.cources.spring.task6.service;

import by.cources.spring.task6.field.EditMode;
import by.cources.spring.task6.model.Book;
import by.cources.spring.task6.repository.BookRepository;
import by.cources.spring.util.TextUtil;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Transactional
  @Override
  public List<Book> findBooksAll() {
    return TextUtil.toList(bookRepository.findAll());
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
  public void saveBook(String mode, Book book) throws Exception {

    if (mode.equals(EditMode.INSERT) || mode.equals(EditMode.UPDATE)) {
      bookRepository.save(book);
    }
    if (mode.equals(EditMode.DELETE)) {
      bookRepository.delete(book);
    }
  }

  @Override
  public Book findById(Long id) {
    return bookRepository.findById(id).get();
  }
}
