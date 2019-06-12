package by.cources.spring.task6.service;

import by.cources.spring.task6.field.EditMode;
import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.model.Book;
import by.cources.spring.task6.repository.AuthorRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;

	private final BookService bookService;

	public AuthorServiceImpl(AuthorRepository authorRepository, BookService bookService) {
		this.authorRepository = authorRepository;
		this.bookService = bookService;
	}

	@Override
	@Transactional
	public List<Author> findAuthorsWithBookOlderThan(Long value) {
		return authorRepository.findWithBookOlderThan(value);
	}

	@Override
	@Transactional
	public List<Author> findAuthorsAll() {
		return authorRepository.findAll();
	}

	@Override
	@Transactional // (propagation = Propagation.REQUIRES_NEW)
	public void saveAuthor(String mode, Author author) throws Exception 
	{		
		// System.out.println(">>"+author.getBooks().size());
		
		if (mode.equals(EditMode.INSERT) || mode.equals(EditMode.UPDATE)) 
		{
			authorRepository.save(author);
		}
		if (mode.equals(EditMode.DELETE))
		{			
			authorRepository.delete(author);
		}

	}

	@Override
	public Author getForm(String mode, Long id) 
	{
		Author author = null;
		if (mode.equals(EditMode.INSERT))
		{
			author = new Author();
		}
		if (mode.equals(EditMode.UPDATE) || mode.equals(EditMode.DELETE)) 
		{
			author = authorRepository.findById(id).get();
		}

		return author;
	}

}
