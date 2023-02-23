package com.uniovi.sdi2223209spring.validators;

import com.uniovi.sdi2223209spring.entities.Teacher;
import com.uniovi.sdi2223209spring.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Controller
public class TeacherValidator implements Validator {

    @Autowired
    private TeacherService teacherService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Teacher.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Teacher professor = (Teacher) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "Error.empty");
        String dni = professor.getDni();
        if(dni.length()!=9 || !Character.isAlphabetic(dni.charAt(dni.length()-1))){
            errors.rejectValue("dni", "Error.professor.dni.format");
        }
        if(! (teacherService.getTeacherByDni(dni)==null)){
            errors.rejectValue("dni", "Error.professor.dni.duplicate");
        }
    }
}
