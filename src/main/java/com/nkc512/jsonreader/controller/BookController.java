package com.nkc512.jsonreader.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nkc512.jsonreader.model.Book;
import com.nkc512.jsonreader.repository.BookRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
public class BookController {
	@Autowired
	BookRepository bookRepository;

	Logger LOGGER= LoggerFactory.getLogger(BookController.class);
	@GetMapping("")
	public ResponseEntity<List<Book>> getAllBookEntity()
	{
		return ResponseEntity.ok(bookRepository.findAll());
	}
	@GetMapping("/{bookId}")
	public ResponseEntity<List<Book>> getBookEntity(@PathVariable("bookId") Long bookId)
	{
		return ResponseEntity.ok(bookRepository.findByBookID(bookId));
	}
	@GetMapping("/search/{title}")
	public ResponseEntity<List<Book>> getBookEntityContainingTitle(@PathVariable("title") String title)
	{
		LOGGER.info("Title fetched from url:"+"%"+title+"%");
		return ResponseEntity.ok(bookRepository.findByTitleContainingIgnoreCase(title));
	}
}
