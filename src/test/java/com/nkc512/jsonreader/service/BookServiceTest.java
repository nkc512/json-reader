package com.nkc512.jsonreader.service;


import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class BookServiceTest {
	
	@Autowired
	BookService bookService;
	private static Logger LOGGER=LoggerFactory.getLogger(BookServiceTest.class);
	
	@BeforeEach
	public void init()
	{
		bookService=new BookService();
		bookService.setAllBooks();
		LOGGER.info("init called");
		System.out.println("init called");
	}
}
