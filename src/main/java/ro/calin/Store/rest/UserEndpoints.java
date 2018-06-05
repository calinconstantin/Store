package ro.calin.Store.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import ro.calin.Store.models.User;
import ro.calin.Store.service.UserService;

@RestController
@CrossOrigin
@RequestMapping(value="/user")
public class UserEndpoints {

    @Autowired
    UserService userService;

    @RequestMapping(value="/create", method =RequestMethod.POST)
    public ResponseEntity<?> CreateUser (@RequestBody User user){
        return ResponseEntity.ok(userService.CreateUser(user));
    }

    @RequestMapping(value="/delete", method =RequestMethod.POST)
    public ResponseEntity<?> DeleteUser (@RequestBody User user){
        return ResponseEntity.ok(userService.DeleteUser(user));
    }

    @RequestMapping(value="/logIn", method =RequestMethod.POST)
    public ResponseEntity<?> LogIn (@RequestBody User user){
        return ResponseEntity.ok(userService.LogIn(user));
    }

    @RequestMapping(value="/logOff", method =RequestMethod.POST)
    public ResponseEntity<?> LogOff (@RequestBody User user){
        return ResponseEntity.ok(userService.LogOff(user));
    }
}
