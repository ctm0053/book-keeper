package com.chillmoore.firstM1SpringProject.repository;

import com.chillmoore.firstM1SpringProject.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
