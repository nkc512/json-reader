package com.nkc512.jsonreader.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nkc512.jsonreader.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    public ArrayList<Book> findByBookID(Long bookId);

    //@Query("Select c from #{#entityName} c where c.title like (:title)")
    public ArrayList<Book> findByTitleContainingIgnoreCase(@Param("title")String title);
}
