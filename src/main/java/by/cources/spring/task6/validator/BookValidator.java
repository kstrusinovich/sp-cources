package by.cources.spring.task6.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.cources.spring.task6.model.Book;

@Component
public class BookValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishedIn", "publishedIn.validate.emailEmpty");
    }
}
