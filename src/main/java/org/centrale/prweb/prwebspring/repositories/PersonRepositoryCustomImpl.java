/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.repositories;

import java.util.Date;
import java.util.Optional;
import org.centrale.prweb.prwebspring.items.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;


@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {
    
    @Autowired
    @Lazy
    private PersonRepository repository;
    
    @Override
    public Person update(int id, Person person) {
        if ((id > 0) && (person != null)) {
            Person item = repository.getReferenceById(id);
            item.setPersonFirstname(person.getPersonFirstname());
            item.setPersonLastname(person.getPersonLastname());
            item.setPersonBirthdate(person.getPersonBirthdate());
            repository.saveAndFlush(person);
            return person;
        }
        return null; 
    }
    
    @Override
    public void remove(int id) {
        if (id > 0) {
            Person person = repository.getReferenceById(id);
            repository.delete(person);
        }
    }
    
    @Override
    public Person create(String firstName, String lastName, Date birthdate) {
        //Save to database
        Person item = new Person();
        item.setPersonFirstname(firstName);
        item.setPersonLastname(lastName);
        if (birthdate != null) {
            item.setPersonBirthdate(birthdate);
        }
        repository.saveAndFlush(item);
        
        //Retreive persisted object
        Optional<Person> result = repository.findById(item.getPersonId());
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
