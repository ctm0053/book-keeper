package com.chillmoore.firstM1SpringProject.repository;

import com.chillmoore.firstM1SpringProject.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
