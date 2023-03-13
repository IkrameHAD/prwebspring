/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.controllers;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.centrale.prweb.prwebspring.items.Person;
import org.centrale.prweb.prwebspring.repositories.PersonRepository;
import org.centrale.prweb.prwebspring.repositories.PersonRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonRepositoryCustomImpl personRepositoryCustomImpl;
    
    private int getIntFromString(String value) {
        int intValue = -1;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.WARNING, null, ex);
        }
        return intValue;
    }
    @RequestMapping(value = "edituser.do", method = RequestMethod.POST)
    public ModelAndView handleEditUserPost(HttpServletRequest request) {
        ModelAndView returned;
        
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        
        if (id > 0) {
            //ID may exist
            Person person = personRepository.getReferenceById(id);
            returned = new ModelAndView("user");
            returned.addObject("user", person);
        } else {
            returned = new ModelAndView("users");
            Collection<Person> myList = personRepository.findAll();
            returned.addObject("usersList", myList);
        }
        return returned;
    }
    
    private Date getDateFromString(String aDate, String format) {
        Date returnedValue = null;
        try {
            //try to convert
            SimpleDateFormat aFormater = new SimpleDateFormat(format);
            returnedValue = aFormater.parse(aDate);
        } catch (ParseException ex) {
        }
        
        if (returnedValue != null) {
            Calendar aCalendar = Calendar.getInstance();
            aCalendar.setTime(returnedValue);
        }
        return returnedValue;
    }
    
    @RequestMapping(value = "saveuser.do", method = RequestMethod.POST)
    public ModelAndView handleSaveUserPost(HttpServletRequest request) {
        ModelAndView returned;
        
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        
        String firstname = request.getParameter("FirstName");
        String lastname = request.getParameter("LastName");
        
        String birthdateStr = request.getParameter("Birthdate");
        Date birthdate = getDateFromString(birthdateStr, "yyyy-MM-dd");
        
        if (id > 0) {
            //ID may exist
            Person person = personRepository.getReferenceById(id);
            person.setPersonFirstname(firstname);
            person.setPersonLastname(lastname);
            person.setPersonBirthdate(birthdate);
            personRepositoryCustomImpl.update(id, person);
        } else {
            personRepositoryCustomImpl.create(firstname, lastname, birthdate);
        }
        
        returned = new ModelAndView("users");
        Collection<Person> myList = personRepository.findAll();
        returned.addObject("usersList", myList);
        
        return returned;
    }
    
    @RequestMapping(value = "deleteuser.do", method = RequestMethod.POST)
    public ModelAndView handleDeleteUserPost(HttpServletRequest request) {
        ModelAndView returned;
        
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        
        if (id > 0) {
            //ID may exist
            personRepositoryCustomImpl.remove(id);
        }
        
        returned = new ModelAndView("users");
        Collection<Person> myList = personRepository.findAll();
        returned.addObject("usersList", myList);
        
        return returned;
    }
    
    @RequestMapping(value = "createuser.do", method = RequestMethod.POST)
    public ModelAndView handleCreateUserPost() {
        ModelAndView returned;
        
        Person newPerson = new Person();
        returned = new ModelAndView("user");
        returned.addObject("user", newPerson);
        
        return returned;
    }
    
    @RequestMapping(value="users.do", method=RequestMethod.POST)
    public ModelAndView handleUsersPost(HttpServletRequest request) {
        ModelAndView returned;
        
        returned = new ModelAndView("users");
        Collection<Person> myList = personRepository.findAll();
        returned.addObject("usersList", myList);
        
        return returned;
    }
    
}
