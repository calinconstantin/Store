package ro.calin.Store.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.calin.Store.models.CreateUserDTO;
import ro.calin.Store.models.Token;
import ro.calin.Store.modelsDTO.DeleteUserDTO;
import ro.calin.Store.modelsDTO.LogInDTO;
import ro.calin.Store.service.UserService;

@RestController
@CrossOrigin
@RequestMapping(value="/user")
public class UserEndpoints {

    @Autowired
    UserService userService;

    @RequestMapping(value="/create", method =RequestMethod.POST)
    public ResponseEntity<?> CreateUser (@RequestBody CreateUserDTO newUser){
        return ResponseEntity.ok(userService.CreateUser(newUser));
    }

    @RequestMapping(value="/delete", method =RequestMethod.POST)
    public ResponseEntity<?> DeleteUser (@RequestBody DeleteUserDTO deleteUser){
        return ResponseEntity.ok(userService.DeleteUser(deleteUser));
    }

    @RequestMapping(value="/logIn", method =RequestMethod.POST)
    public ResponseEntity<?> LogIn (@RequestBody LogInDTO logInUser){
        return ResponseEntity.ok(userService.LogIn(logInUser));
    }

    @RequestMapping(value="/logOff", method =RequestMethod.POST)
    public ResponseEntity<?> LogOff (@RequestBody String token){
        return ResponseEntity.ok(userService.LogOff(token));
    }
}

