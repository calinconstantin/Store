package ro.calin.Store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.calin.Store.models.Token;
import ro.calin.Store.models.User;
import ro.calin.Store.repository.TokenRepository;
import ro.calin.Store.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenService tokenService;
    @Autowired
    TokenRepository tokenRepository;

    public boolean CreateUser(User user){
        if(user.getEmail()!=null)
            if(user.getFullName()!=null)
                if(user.getPassword()!=null)
                    if(user.getPhone()!=null)
                    {
                        userRepository.save(user);
                        return true;
                    }
    return false;
    }

    public boolean DeleteUser(User user){
        boolean userExists = false;
        for(User thisUser : userRepository.findAll())
            if(user.getId().equals(thisUser.getId()))
            {thisUser.setDeleted(true);
            userExists=true;}
    return userExists;
    }

    public Token LogIn(User user){
        for(User u: userRepository.findAll()){
            if(u.getEmail().equals(user.getEmail())&&u.getPassword().equals(user.getPassword()))
                return tokenService.generateToken(u);
        }
        return null;
    }

    public boolean LogOff(User user){
        boolean userIsLogged=false;
        for(Token thisToken : tokenRepository.findAll())
            if(thisToken.getUser().getId().equals(user.getId()))
            {
                thisToken.setStatus("INACTIVE");
                userIsLogged=true;
            }
        return userIsLogged;
    }
}
