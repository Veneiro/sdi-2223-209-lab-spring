package com.uniovi.sdi2223209spring.repositories;

import com.uniovi.sdi2223209spring.entities.Mark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MarksRepository extends CrudRepository<Mark, Long> {

}
