package com.aluracourse.literalura.service;

import com.aluracourse.literalura.dto.BookResponseDTO;
import com.aluracourse.literalura.mapper.BookMapper;
import com.aluracourse.literalura.model.Author;
import com.aluracourse.literalura.model.Book;
import com.aluracourse.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

        if (bookDTO == null) {
            System.out.println("No se encontró ningún libro con el título: " + bookName);
            return; // Salir del método si no hay resultados
        }

        Author author = authorService.findOrCreateAuthor( bookDTO.authors().get(0) );

        Book book = BookMapper.toEntity(bookDTO);
        book.setAuthor(author);
        bookRepository.save(book);

        System.out.println(book);

    }

    public void listRegisteredBooks() {

        List<Book> books = bookRepository.findAll();

        if( !books.isEmpty()){
            books.forEach(System.out::println);
        }else{
            System.out.println("No hay libros agregados");
        }

    }

    public void listBooksByLanguage() {



    }


}
