package com.uniovi.sdi2223209spring.repositories;

import com.uniovi.sdi2223209spring.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, String> {
    Teacher findByDni(String dni);
}
