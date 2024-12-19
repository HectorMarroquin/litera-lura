package com.aluracourse.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookResponseDTO(

        @JsonAlias("title") String title,
        @JsonAlias("media_type") String mediaType,
        @JsonAlias("download_count") int downloadCount,
        @JsonAlias("languages") String language,
        @JsonAlias("authors") List<AuthorReponseDTO> authors
) {}