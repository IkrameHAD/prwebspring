/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.prweb.prwebspring.repositories;

import java.util.Date;
import org.centrale.prweb.prwebspring.items.*;

/**
 *
 * @author T480
 */
public interface BorrowRepositoryCustom {
    public Borrow returnBook(Borrow item, Date date);
    public Borrow returnBook(Borrow item);
    public Borrow returnBook(int borrowId);
    public Borrow create(Person user, Book book);
}
