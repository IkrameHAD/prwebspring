/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.prweb.prwebspring.repositories;

import org.centrale.prweb.prwebspring.items.Book;

public interface BookRepositoryCustom {
    public Book update(int id, Book book);
    public void remove(int id);
    public Book create(String title, String authors);
}
