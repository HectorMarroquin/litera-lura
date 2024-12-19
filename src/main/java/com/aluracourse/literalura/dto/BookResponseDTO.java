package com.aluracourse.literalura.dto;

import com.aluracourse.literalura.model.Author;
import com.aluracourse.literalura.model.BookLanguaje;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.ManyToOne;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookResponseDTO(

        @JsonAlias("title") String title,
        @JsonAlias("media_type") String mediaType,
        @JsonAlias("download_count") int downloadCount,
        @JsonAlias("languages") BookLanguaje lenguaje,
        @JsonAlias("authors") List<Author> author
) {}
