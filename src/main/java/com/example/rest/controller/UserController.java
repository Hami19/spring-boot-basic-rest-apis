package com.example.rest.controller;

import com.example.rest.dao.UserDAO;
import com.example.rest.entity.User;
import com.example.rest.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value="/user", method= RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserDAO user) {
        try {
            User u = new User();
            u.setFirstName(user.getFirstName())
                    .setLastName(user.getLastName())
                    .setEmailId(user.getEmailId());

            return new ResponseEntity<>(userService.createUser(u), HttpStatus.CREATED);
        }
        catch (Exception ex) {
            logger.trace("Got Exception on createUser");
            logger.debug(ex.getMessage());
            throw ex;
        }
    }

    @RequestMapping(value="/user", method= RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        try {
            return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
        }
        catch (Exception ex) {
            logger.trace("Got Exception on getUsers");
            logger.debug(ex.getMessage());
            throw ex;
        }
    }

    @RequestMapping(value="/user/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>("User Deleted", HttpStatus.OK);
        }
        catch (Exception ex) {
            logger.trace("Got Exception on getUsers");
            logger.debug(ex.getMessage());
            throw ex;
        }
    }

    @RequestMapping(value="/user/{id}", method= RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserDAO userDAO) {
        try {
            ModelMapper mapper = new ModelMapper();
            User u = mapper.map(userDAO, User.class);
            return new ResponseEntity<>(userService.updateUser(id, u), HttpStatus.OK);
        }
        catch (Exception ex) {
            logger.trace("Got Exception on getUsers");
            logger.debug(ex.getMessage());
            throw ex;
        }
    }
}
