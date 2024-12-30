package com.aluracourse.literalura.repository;

import com.aluracourse.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT b.language FROM Book b GROUP BY b.language")
    List<String> groupByBooksLanguage();

    List<Book> findByLanguage(String language);
}
