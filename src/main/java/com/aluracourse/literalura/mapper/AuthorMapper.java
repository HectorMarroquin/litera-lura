package com.aluracourse.literalura.mapper;

import com.aluracourse.literalura.dto.AuthorReponseDTO;
import com.aluracourse.literalura.model.Author;

public class AuthorMapper {

    public static Author toEntity(AuthorReponseDTO authorDTO){

        Author author = new Author();
        author.setName( authorDTO.name());
        author.setBirthYear( authorDTO.birthYear());
        author.setDeathYear(author.getDeathYear() );

        return author;
    }

}
