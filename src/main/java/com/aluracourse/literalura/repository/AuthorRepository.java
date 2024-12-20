package com.aluracourse.literalura.repository;

import com.aluracourse.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    Optional<Author> findByName(String name);

    List<Author> findByDeathYearBefore(Integer date);
}
