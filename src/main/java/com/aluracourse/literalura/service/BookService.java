package com.aluracourse.literalura.service;

import com.aluracourse.literalura.dto.BookResponseDTO;
import com.aluracourse.literalura.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class BookService {


    @Autowired
    private GutexApiService gutexApiService;
    private Scanner scanner = new Scanner(System.in);

    public void searchBookByTitle() {

        System.out.println("Escriba el nombre del libro a buscar");
        String bookName = scanner.nextLine();

        BookResponseDTO book = gutexApiService.getBookByName( bookName );

        System.out.println(book);

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
