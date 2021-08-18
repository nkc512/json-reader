package com.nkc512.jsonreader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Book {
	@Id
	@Column(name = "bookID")
	Long bookID;
	@Column(name = "title", columnDefinition="VARCHAR(70000)")
	String title;
	@Lob
	@Column(name = "authors", columnDefinition="BLOB")
	String authors;
	@Lob
	@Column(name = "average_rating", columnDefinition="BLOB")
	String average_rating;

	String isbn;
	String language_code;
	String ratings_count;
	Long price;
	public Long getBookID() {
		return bookID;
	}
	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAverage_rating() {
		return average_rating;
	}
	public void setAverage_rating(String average_rating) {
		this.average_rating = average_rating;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getLanguage_code() {
		return language_code;
	}
	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}
	public String getRatings_count() {
		return ratings_count;
	}
	public void setRatings_count(String ratings_count) {
		this.ratings_count = ratings_count;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String author) {
		this.authors = author;
	}
	public Book(Long bookID, String title, String authors, String average_rating, String isbn, String language_code,
			String ratings_count, Long price) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.authors = authors;
		this.average_rating = average_rating;
		this.isbn = isbn;
		this.language_code = language_code;
		this.ratings_count = ratings_count;
		this.price = price;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "\"bookID\":"+ bookID + ",\n \"title\":" + title + ",\n \"authors\":" + authors + ",\n \"average_rating\":"
				+ average_rating + ",\n \"isbn\":" + isbn + ",\n \"language_code\":" + language_code + ",\n \"ratings_count\":"
				+ ratings_count + ",\n \"price\":" + price + "\n";
	}
	
}
