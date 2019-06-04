package by.cources.spring.task2.spring.service;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.JdbcTemplateAuthorRepository;
import by.cources.spring.task2.spring.repository.JdbcTemplateBookRepository;

import java.util.List;

public class BookAuthorServiceImpl implements BookAuthorService{

    private JdbcTemplateBookRepository bookRepository;
    private JdbcTemplateAuthorRepository authorRepository;

    public BookAuthorServiceImpl(JdbcTemplateBookRepository bookRepository, JdbcTemplateAuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAllBooks(){
        return bookRepository.findAllBooks();
    }

    @Override
    public Book findBookById(Long id){
        return bookRepository.findBookById(id);
    }

    @Override
    public List<Author> findAllAuthors(){
        return authorRepository.findAllAuthors();
    }

    @Override
    public Author findAuthorById(int id){
        return authorRepository.findAuthorById(id);
    }

    @Override
    public List<Author> findAuthorsWithBookOlder(Long publicationYear){
        return authorRepository.findAuthorsWithBookOlder(publicationYear);
    }
}
