package com.aluracourse.literalura.service;

import com.aluracourse.literalura.dto.AuthorReponseDTO;
import com.aluracourse.literalura.mapper.AuthorMapper;
import com.aluracourse.literalura.model.Author;
import com.aluracourse.literalura.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author findOrCreateAuthor(AuthorReponseDTO authorDTO){

        Optional<Author> existingAuthor = authorRepository.findByName( authorDTO.name() );

        return existingAuthor.orElseGet(() ->{
            // Si no existe, crearlo y guardarlo
            Author newAuthor = AuthorMapper.toEntity( authorDTO );
            return  authorRepository.saveAndFlush( newAuthor );
        });

    }

    public void listRegisteredAuthors() {

        List<Author> authors = authorRepository.findAll();

        if( !authors.isEmpty()){
            authors.forEach(System.out::println);
        }else{
            System.out.println("No hay autores registrados");
        }

    }

    public void listLivingAuthors() {

    }

}
