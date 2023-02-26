package com.example.Weekly_Test.repository;

import com.example.Weekly_Test.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
