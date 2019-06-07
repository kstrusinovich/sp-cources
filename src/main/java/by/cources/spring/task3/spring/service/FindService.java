package by.cources.spring.task3.spring.service;

import by.cources.spring.task3.spring.model.Author;
import by.cources.spring.task3.spring.model.Book;
import by.cources.spring.task3.spring.model.Language;

import java.util.List;

/**
 * �����
 * 
 * @author Leonovich
 */
public interface FindService 
{
  List<Book> findBooksAll();

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsAll();

  List<Language> findLanguageAll();

  List<Author> findAuthorsWithBookOnLanguage(String languageName);

  List<Book> findBooksOnLanguage(String languageName);

  /**
   * ������, ����� ������� �� ����� languageName �������� ����� ������������ ����
   */
  List<Author> findAuthorsWithBooksOnLanguageAfterYear(String languageName, Long year);
  
}
