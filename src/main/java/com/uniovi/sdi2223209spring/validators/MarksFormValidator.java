package com.uniovi.sdi2223209spring.validators;

import com.uniovi.sdi2223209spring.entities.Mark;
import com.uniovi.sdi2223209spring.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MarksFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Mark mark = (Mark) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Error.empty");
        if (mark.getScore() > 10 || mark.getScore() < 0)
            errors.rejectValue("score", "Error.mark.score.value");
        if (mark.getDescription().length() < 20)
            errors.rejectValue("description", "Error.mark.description.length");
    }

}
