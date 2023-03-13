/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.repositories;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import org.centrale.prweb.prwebspring.items.Book;
import org.centrale.prweb.prwebspring.items.Borrow;
import org.centrale.prweb.prwebspring.items.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;


@Repository
public class BorrowRepositoryCustomImpl implements BorrowRepositoryCustom {
    
    @Autowired
    @Lazy
    private BorrowRepository repository;
    
    @Override
    public Borrow returnBook(Borrow item, Date date) {
        if ((item != null) && (date != null)) {
            item.setBorrowReturn(date);
            repository.saveAndFlush(item);
            return item;
        }
        return null;
    }
    
    @Override
    public Borrow returnBook(Borrow item) {
        Calendar aCalendar = Calendar.getInstance();
        Date date = aCalendar.getTime();
        return returnBook(item, date);
    }
    
    @Override
    public Borrow returnBook(int borrowId) {
        if (borrowId > 0) {
            Borrow item = repository.getReferenceById(borrowId);
            if (item != null) {
                return returnBook(item);
            }
        }
        return null;
    }
    
    @Override
    public Borrow create(Person user, Book book) {
        //Save to database
        Borrow item = new Borrow();
        item.setBookId(book);
        item.setPersonId(user);
        Date currentDate = new Date();
        item.setBorrowDate(currentDate);
        repository.saveAndFlush(item);
        
        //Retreive persisted object
        Optional<Borrow> result = repository.findById(item.getBorrowId());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
