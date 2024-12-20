package com.aluracourse.literalura;

import com.aluracourse.literalura.main.MenuHandler;
import com.aluracourse.literalura.service.AuthorService;
import com.aluracourse.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {


	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		MenuHandler menuHandler = new MenuHandler( bookService, authorService );
		menuHandler.menuOptions();
	}
}
