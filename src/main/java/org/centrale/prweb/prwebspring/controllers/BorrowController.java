/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.centrale.prweb.prwebspring.items.Book;
import org.centrale.prweb.prwebspring.items.Borrow;
import org.centrale.prweb.prwebspring.items.Person;
import org.centrale.prweb.prwebspring.repositories.BookRepository;
import org.centrale.prweb.prwebspring.repositories.BorrowRepository;
import org.centrale.prweb.prwebspring.repositories.BorrowRepositoryCustomImpl;
import org.centrale.prweb.prwebspring.repositories.PersonRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BorrowController {
   
    @Autowired
    private PersonRepository personRepository; 
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowRepositoryCustomImpl borrowRepositoryCustomImpl;
    @Autowired
    private BorrowRepository borrowRepository;
    
    private int getIntFromString(String value) {
        int intValue = -1;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.WARNING, null, ex);
        }
        return intValue;
    }
    
    @RequestMapping(value = "returnborrow.do", method = RequestMethod.POST)
    public ModelAndView handleReturn(HttpServletRequest request) {
        ModelAndView returned = new ModelAndView("ajax");
        JSONObject returnedObject = new JSONObject();
        
        String borrowStr = request.getParameter("id");
        int borrowId = getIntFromString(borrowStr);
        
        Borrow borrow = borrowRepository.returnBook(borrowId);
        if (borrow != null) {
            returnedObject.append("id", borrow.getBorrowId());
        } else {
            returned.setStatus(HttpStatus.BAD_REQUEST);   
        }
        returned.addObject("theResponse", returnedObject.toString());
        
        return returned;  
    }
        
    @RequestMapping(value = "addborrow.do", method = RequestMethod.POST)
    public ModelAndView handleAddBorrow(HttpServletRequest request) {
        String userStr = request.getParameter("userID");
        int userID = getIntFromString(userStr);
        Person user = personRepository.getReferenceById(userID);
        
        String bookStr = request.getParameter("bookID");
        int bookID = getIntFromString(bookStr);
        Book book = bookRepository.getReferenceById(bookID);
        
        Borrow borrow = borrowRepository.create(user, book);
        if(!user.getBorrowCollection().contains(borrow)){
           user.getBorrowCollection().add(borrow);
           personRepository.saveAndFlush(user);
        }
        if(!book.getBorrowCollection().contains(borrow)){
           book.getBorrowCollection().add(borrow);
           bookRepository.saveAndFlush(book);
        }

        // Refresh user data (bookCollection)
        user = personRepository.getReferenceById(userID);
        
        ModelAndView returned = new ModelAndView("user");
        returned.addObject("user", user);
        returned.addObject("booksList", bookRepository.findAll());
        
        return returned; 
    }
}
