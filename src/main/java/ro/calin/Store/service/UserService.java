package ro.calin.Store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.calin.Store.models.CreateUserDTO;
import ro.calin.Store.models.Token;
import ro.calin.Store.models.User;
import ro.calin.Store.modelsDTO.CreateUserResponseDTO;
import ro.calin.Store.modelsDTO.DeleteUserDTO;
import ro.calin.Store.modelsDTO.LogInDTO;
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

    public CreateUserResponseDTO CreateUser(CreateUserDTO newUser){
        CreateUserResponseDTO response = new CreateUserResponseDTO();

        if(newUser.getEmail()==null || newUser.getEmail().isEmpty())
            response.setEmailNull(true);
        else
            {
                for(User thisUser : userRepository.findAll())
                    if(thisUser.getEmail().equals(newUser.getEmail()))
                        response.setEmailExists(true);

                if(!response.isEmailExists())
                if(newUser.getEmail().length()>=6 && newUser.getEmail().length()<=20)
                    {
                        if(!newUser.getEmail().matches("[a-zA-Z]+") ||
                           !newUser.getEmail().matches("[0-9]+") )
                        response.setEmailNok(true);
                    }
                else
                    response.setEmailNok(true);
            }

        if(newUser.getFullName()==null || newUser.getFullName().isEmpty())
            response.setFullNameNull(true);
        else
            {
                if(newUser.getFullName().length()<=20)
                {
                    if(!newUser.getFullName().matches("[a-zA-Z]+") ||
                       !newUser.getFullName().matches("[0-9]+") ||
                       !newUser.getFullName().matches(" "))
                    response.setFullNameNok(true);
                }
                else
                    response.setFullNameNok(true);
            }

        if(newUser.getPassword()==null || newUser.getPassword().isEmpty())
            response.setPasswordNull(true);
        else
            {
                if(newUser.getPassword().length()>=6 && newUser.getPassword().length()<=20)
                {
                    if(!newUser.getPassword().matches("[a-zA-Z]+") ||
                       !newUser.getPassword().matches("[0-9]+"))
                        response.setPasswordNok(true);
                }
                else
                    response.setPasswordNok(true);
            }

        if(newUser.getPhone()==null || newUser.getPhone().isEmpty())
            response.setPhoneNull(true);
        else
            {
                if(newUser.getPhone().length()==10)
                {
                    if(!newUser.getPhone().matches("[0-9]+"))
                        response.setPhoneNok(true);
                }
                else
                    response.setPhoneNok(true);
            }

    return response;
    }

    public boolean DeleteUser(DeleteUserDTO deleteUser){
        for(User thisUser: userRepository.findAll())
            {
            if(thisUser.getEmail().equals(deleteUser.getEmail()) &&
               thisUser.getPassword().equals(deleteUser.getPassword())  )
            if(deleteUser.getAcceptAccountDeleting().equals("OK"))
                {
                thisUser.setDeleted(true);
                return true;
                }
            }
        return false;
    }

    public Token LogIn(LogInDTO logIn){
        for(User thisUser: userRepository.findAll()){
            if(thisUser.getEmail().equals(logIn.getEmail()) &&
               thisUser.getPassword().equals(logIn.getPassword())  )
                return tokenService.generateToken(thisUser);
        }
        return null;
    }

    public boolean LogOff(Token setInactive){

        for(Token thisToken : tokenRepository.findAll())
            if(thisToken.getId().equals(setInactive.getId()))
            {
                thisToken.setStatus("INACTIVE");
                return true;
            }
        return false;
    }
}
