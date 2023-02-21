package com.uniovi.sdi2223209spring.repositories;

import com.uniovi.sdi2223209spring.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByDni(String dni);
}
