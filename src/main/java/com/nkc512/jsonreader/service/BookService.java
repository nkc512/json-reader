package com.nkc512.jsonreader.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.nkc512.jsonreader.model.Book;
import com.nkc512.jsonreader.repository.BookRepository;

@Service
public class BookService {
	List<Book> bookList;
	Book book;
	@Autowired
	BookRepository bookRepository;

	public static final Logger LOGGER=LoggerFactory.getLogger(BookService.class);
	public void setAllBooks()
	{
		bookList=new ArrayList<>();
		try(JsonParser jParser = new JsonFactory().createParser(new File("src/main/resources/static/books.json"));) {

			if(jParser.nextToken() == JsonToken.START_ARRAY) {
				while(jParser.nextToken() != JsonToken.END_ARRAY) {
					book=new Book();
					while(jParser.nextToken() != JsonToken.END_OBJECT) {
						String fieldname= jParser.getCurrentName();
						jParser.nextToken();
						if("bookID".equals(fieldname))
						{
							
							book.setBookID(jParser.getLongValue());
						}
						else if("title".equals(fieldname))
						{
							book.setTitle(jParser.getText());
						}
						else if("authors".equals(fieldname))
						{
							
							book.setAuthors(jParser.getText());
						}
						else if("average_rating".equals(fieldname))
						{
							book.setAverage_rating(jParser.getText());
						}
						else if("isbn".equals(fieldname))
						{
							book.setIsbn(jParser.getText());
						}
						else if("language_code".equals(fieldname))
						{
							book.setLanguage_code(jParser.getText());
						}
						else if("ratings_count".equals(fieldname))
						{
							book.setRatings_count(jParser.getText());
						}
						else if("price".equals(fieldname))
						{
							book.setPrice(jParser.getLongValue());
						}
					}
					bookRepository.save(book);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.toString());
		}


	}
}
