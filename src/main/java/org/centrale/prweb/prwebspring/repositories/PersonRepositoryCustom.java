/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.prweb.prwebspring.repositories;

import java.util.Date;
import org.centrale.prweb.prwebspring.items.Person;

/**
 *
 * @author T480
 */
public interface PersonRepositoryCustom {
    
    public Person update(int id, Person person);
    public void remove(int id);
    public Person create(String firstname, String lastname, Date birthdate);
}
