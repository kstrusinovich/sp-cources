package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.repository.AuthorRepository;

import java.util.List;

public class AuthorService {

    private AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> fiendAll(){
        return repository.findAll();
    }

    public Author fiendById(Long id){
        return repository.findById(id);
    }
}
