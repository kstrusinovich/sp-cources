package by.cources.spring.task3.spring.service;

import by.cources.spring.task3.spring.model.Author;
import by.cources.spring.task3.spring.model.Book;
import by.cources.spring.task3.spring.model.Language;
import by.cources.spring.task3.spring.repository.AuthorRepository;
import by.cources.spring.task3.spring.repository.BookRepository;
import by.cources.spring.task3.spring.repository.LanguageRepository;
import by.cources.spring.util.TextUtil;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FindServiceImpl implements FindService 
{
	/**  **/
	private final BookRepository bookRepository;
	
	/**  **/
	private final AuthorRepository authorRepository;
	
	/**  **/
	private final LanguageRepository languageRepository;
	
	
	public FindServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository,		
			LanguageRepository languageRepository) 
	{
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.languageRepository = languageRepository;
	}
	
	@Transactional
	@Override
	public List<Book> findBooksAll() 
	{
		return TextUtil.toList(bookRepository.findAll());
	}

	@Override
	@Transactional
	public List<Author> findAuthorsWithBookOlderThan(Long value) 
	{
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
	public List<Language> findLanguageAll() 	
	{
		return languageRepository.findAll();
	}

	@Override
	public List<Author> findAuthorsWithBookOnLanguage(String languageName) 
	{
		return authorRepository.findAuthorsWithBookOnLanguage(languageName);
		
	}

	@Override
	public List<Book> findBooksOnLanguage(String languageName) {
		return bookRepository.findByLanguage(languageName);
	}
	
	@Override
	public List<Author> findAuthorsWithBooksOnLanguageAfterYear(String languageName, Long year) 
	{
		return authorRepository.findAuthorsWithBooksOnLanguageAfterYear(languageName, year);		
	}

}