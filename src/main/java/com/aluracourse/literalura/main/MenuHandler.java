package com.aluracourse.literalura.main;

import com.aluracourse.literalura.service.AuthorService;
import com.aluracourse.literalura.service.BookService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuHandler {

    private final Scanner keyboardInput = new Scanner(System.in);
    private final BookService bookService;
    private final AuthorService authorService;

    public MenuHandler(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    public void menuOptions() {
        int option;

        do {
            displayMenu();
            option = readOption();
            executeOption(option);
        } while (option != 0);

        System.out.println("Thank you for using LiteraAlura! See you soon.");
    }

    // Method to display the menu
    private void displayMenu() {
        System.out.println("""
                ====== Welcome to LiteraAlura ======
                1. Search Book by Title
                2. List Registered Books
                3. List Registered Authors
                4. List Living Authors in a Given Year
                5. List Books by Language
                0. Exit
                ====================================
                Please choose an option:
                """);
    }

    // Method to read user input with validation
    private int readOption() {
        int option = -1;
        try {
            option = keyboardInput.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");
        } finally {
            keyboardInput.nextLine(); // Clear the buffer
        }
        return option;
    }

    // Method to execute user-selected options
    private void executeOption(int option) {
        switch (option) {
            case 1 -> bookService.searchBookByTitle();
            case 2 -> bookService.listRegisteredBooks();
            case 3 -> authorService.listRegisteredAuthors();
            case 4 -> authorService.listLivingAuthors();
            case 5 -> bookService.listBooksByLanguage();
            case 0 -> System.out.println("Exiting the application...");
            default -> System.out.println("Invalid option. Please try again.");
        }
        System.out.println(); // para dar un salto de linea
    }
}
