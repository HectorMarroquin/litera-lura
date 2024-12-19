package com.aluracourse.literalura.dto;

import com.aluracourse.literalura.model.Book;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiGutexResponseDTO(
        @JsonAlias("results") List<Book> books
) {}