package com.org.EventsServices.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.EventsServices.ldap.model.UserModel;
import com.org.EventsServices.ldap.repository.ApacheDSRepository;

@RestController
public class UserManagement {

    private final static Logger logger = LoggerFactory.getLogger(UserManagement.class);

    @Autowired
    ApacheDSRepository apacheDSRepository;

    @Autowired
    ApplicationContext context;
    
    @GetMapping("/")
    @ResponseBody
    public String health() {
       
            return "application is up !";
    }

/*    @GetMapping("/")
    @ResponseBody
    public String bonsoir(@RequestParam(name = "id", required = false) String id, HttpServletRequest request) {
        if (id != null)
            return "Bonsoir " + id + " !";
        else
            return "Bonsoir!";
    }

    @ResponseBody
    @GetMapping("/error2")
    public String errorMessage(HttpServletRequest request, HttpServletResponse response) {

        return "Error occurred, please see the server logs.";
    }

*/
    @ResponseBody
    @GetMapping("/users")
    public Iterable<UserModel> getAllUsers() {
        return apacheDSRepository.findAll();
    }

   
}
