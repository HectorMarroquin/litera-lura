package com.aluracourse.literalura.service;

import com.aluracourse.literalura.dto.BookResponseDTO;
import com.aluracourse.literalura.mapper.BookMapper;
import com.aluracourse.literalura.model.Book;
import com.aluracourse.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class BookService {


    @Autowired
    private GutexApiService gutexApiService;
    @Autowired
    private BookRepository bookRepository;

    private Scanner scanner = new Scanner(System.in);

    public void searchBookByTitle() {

        System.out.println("Escriba el nombre del libro a buscar");
        String bookName = scanner.nextLine();
        BookResponseDTO bookDTO = gutexApiService.getBookByName( bookName );
        System.out.println(bookDTO);
        Book book = BookMapper.toEntity(bookDTO);
        bookRepository.save(book);

    }

    public void listRegisteredBooks() {
    }

    public void listRegisteredAuthors() {
    }

    public void listLivingAuthors() {
    }

    public void listBooksByLanguage() {
    }
}
