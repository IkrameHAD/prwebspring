/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.controllers;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.centrale.prweb.prwebspring.items.Person;
import org.centrale.prweb.prwebspring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    
    @Autowired
    private PersonRepository personRepository;
    
    @RequestMapping(value="index.do")
    public ModelAndView handleIndexGet() {
        return new ModelAndView("index");
    }
    
    @RequestMapping(value="login.do", method=RequestMethod.POST)
    public ModelAndView handleLoginPost(HttpServletRequest request) {
        ModelAndView returned;
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        if ((login != null) && (password != null)
                && (login.equals("admin")) && (password.equals("admin"))) {
            returned = new ModelAndView("users");
            Collection<Person> myList = personRepository.findAll();
            returned.addObject("usersList", myList);
        } else {
            returned = new ModelAndView("index");
        }
        return returned;
    }
}
