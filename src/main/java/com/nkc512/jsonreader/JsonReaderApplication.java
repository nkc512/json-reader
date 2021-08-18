package com.nkc512.jsonreader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nkc512.jsonreader.service.BookService;

@SpringBootApplication
public class JsonReaderApplication implements CommandLineRunner{

	@Autowired
	BookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(JsonReaderApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		bookService.setAllBooks();
	}

}
