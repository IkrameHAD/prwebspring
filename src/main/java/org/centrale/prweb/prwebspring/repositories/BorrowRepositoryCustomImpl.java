/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;


@Repository
public class BorrowRepositoryCustomImpl implements BorrowRepositoryCustom {
    
    @Autowired
    @Lazy
    private BorrowRepository repository;
}
