/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.controllers;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.Collection;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.centrale.prweb.prwebspring.items.Book;
import org.centrale.prweb.prwebspring.repositories.BookRepository;
import org.centrale.prweb.prwebspring.repositories.BookRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookRepositoryCustomImpl bookRepositoryCustomImpl;
    
    private int getIntFromString(String value) {
        int intValue = -1;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.WARNING, null, ex);
        }
        return intValue;
    }
    @RequestMapping(value = "editbook.do", method = RequestMethod.POST)
    public ModelAndView handleEditBookPost(HttpServletRequest request) {
        ModelAndView returned;
        
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        
        if (id > 0) {
            //ID may exist
            Book book = bookRepository.getReferenceById(id);
            returned = new ModelAndView("book");
            returned.addObject("book", book);
        } else {
            returned = new ModelAndView("books");
            Collection<Book> myList = bookRepository.findAll();
            returned.addObject("booksList", myList);
        }
        return returned;
    }
    
    @RequestMapping(value = "savebook.do", method = RequestMethod.POST)
    public ModelAndView handleSaveBookPost(HttpServletRequest request) {
        ModelAndView returned;
        
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        
        String title = request.getParameter("Title");
        String authors = request.getParameter("Authors");
        
        String availableStr = request.getParameter("Available");
        int available = getIntFromString(availableStr);
        
        if (id > 0) {
            //ID may exist
            Book book = bookRepository.getReferenceById(id);
            book.setBookTitle(title);
            book.setBookAuthors(authors);
            if (available != -1) {
                book.setBookAvailable(available);
            }
            bookRepositoryCustomImpl.update(id, book);
        } else {
            bookRepositoryCustomImpl.create(title, authors);
        }
        
        returned = new ModelAndView("books");
        Collection<Book> myList = bookRepository.findAll();
        returned.addObject("booksList", myList);
        
        return returned;
    }
    
    @RequestMapping(value = "deletebook.do", method = RequestMethod.POST)
    public ModelAndView handleDeleteBookPost(HttpServletRequest request) {
        ModelAndView returned;
        
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        
        if (id > 0) {
            //ID may exist
            /**
            bookRepositoryCustomImpl.remove(id);
            */
            Book book = bookRepositoryCustomImpl.notAvailable(id);
            returned = new ModelAndView("book");
            returned.addObject("book", book);
        }
        
        returned = new ModelAndView("books");
        Collection<Book> myList = bookRepository.findAll();
        returned.addObject("booksList", myList);
        
        return returned;
    }
    
    @RequestMapping(value = "createbook.do", method = RequestMethod.POST)
    public ModelAndView handleCreateBookPost() {
        ModelAndView returned;
        
        Book newBook = new Book();
        returned = new ModelAndView("book");
        returned.addObject("book", newBook);
        
        return returned;
    }
    
    @RequestMapping(value="books.do", method=RequestMethod.POST)
    public ModelAndView handleBooksPost(HttpServletRequest request) {
        ModelAndView returned;
        
        returned = new ModelAndView("books");
        Collection<Book> myList = bookRepository.findAll();
        returned.addObject("booksList", myList);
        
        return returned;
    }
    
}

