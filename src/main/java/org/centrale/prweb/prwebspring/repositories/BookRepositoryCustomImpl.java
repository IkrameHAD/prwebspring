/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.repositories;

import java.util.Optional;
import org.centrale.prweb.prwebspring.items.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;


@Repository
public class BookRepositoryCustomImpl implements BookRepositoryCustom {
    
    @Autowired
    @Lazy
    private BookRepository repository;
    
    @Override
    public Book update(int id, Book book) {
        if ((id > 0) && (book != null)) {
            Book item = repository.getReferenceById(id);
            item.setBookTitle(book.getBookTitle());
            item.setBookAuthors(book.getBookAuthors());
            repository.saveAndFlush(book);
            return book;
        }
        return null; 
    }
    
    @Override
    public void remove(int id) {
        if (id > 0) {
            Book book = repository.getReferenceById(id);
            repository.delete(book);
        }
    }
    
    @Override
    public Book create(String title, String authors) {
        //Save to database
        Book item = new Book();
        item.setBookTitle(title);
        item.setBookAuthors(authors);
        repository.saveAndFlush(item);
        
        //Retreive persisted object
        Optional<Book> result = repository.findById(item.getBookId());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
    
    @Override
    public Book notAvailable(int id) {
        if (id > 0) {
            Book book = repository.getReferenceById(id);
            book.setBookAvailable(0);
            repository.saveAndFlush(book);
            return book;
        }
        return null;
    }
}
