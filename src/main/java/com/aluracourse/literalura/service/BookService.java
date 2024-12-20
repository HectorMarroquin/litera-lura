package com.aluracourse.literalura.service;

import com.aluracourse.literalura.dto.BookResponseDTO;
import com.aluracourse.literalura.mapper.BookMapper;
import com.aluracourse.literalura.model.Author;
import com.aluracourse.literalura.model.Book;
import com.aluracourse.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class BookService {


    private GutexApiService gutexApiService;
    private BookRepository bookRepository;
    private AuthorService authorService;
    private Scanner scanner = new Scanner(System.in);

    public BookService(GutexApiService gutexApiService, BookRepository bookRepository, AuthorService authorService) {
        this.gutexApiService = gutexApiService;
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }



    public void searchBookByTitle() {

        System.out.println("Escriba el nombre del libro a buscar");
        String bookName = scanner.nextLine();
        BookResponseDTO bookDTO = gutexApiService.getBookByName( bookName );

        Author author = authorService.findOrCreateAuthor( bookDTO.authors().get(0) );

        Book book = BookMapper.toEntity(bookDTO);
        book.setAuthor(author);
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
