package by.cources.spring.task6.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

class TextBoxValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        errors.rejectValue("publishedIn", "Enter published_in");
    }
}