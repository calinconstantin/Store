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
import ro.calin.Store.utils.Constants;
import ro.calin.Store.utils.Tools;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenService tokenService;
    @Autowired
    TokenRepository tokenRepository;

    public ArrayList<String> CreateUser(CreateUserDTO newUser){

        ArrayList<String> response = new ArrayList<>();

//____________EMAIL________________________________________________
        if(Tools.checkNullEmpty(newUser.getEmail()))
            response.add(Constants.errorCodeNullEmail);
        else if(Tools.checkMail(newUser.getEmail()) && newUser.getEmail().length()>5 && newUser.getEmail().length()<30)
            {
                for (User thisUser : userRepository.findAll())
                    if (thisUser.getEmail().equals(newUser.getEmail()))
                        response.add(Constants.errorCodeEmailExists);
                response.add(Constants.correctEmail);
                if(response.get(0).matches(Constants.errorCodeEmailExists))
                    response.remove(1);
            }else
                response.add(Constants.errorCodeEmail);

//__________FULL_NAME________________________________________________
        if(Tools.checkNullEmpty(newUser.getFullName()))
            response.add(Constants.errorCodeNullUsername);
        else
            if(Tools.checkLetter(newUser.getFullName()) && newUser.getFullName().length()>5 && newUser.getFullName().length()<30 )
                response.add(Constants.correctUsername);
            else
                response.add(Constants.errorCodeUsername);

//_________PASSWORD___________________________________________________
        if(Tools.checkNullEmpty(newUser.getPassword()))
            response.add(Constants.errorCodeNullPassword);
        else
            if(Tools.checkLetterDigits(newUser.getPassword()) && newUser.getPassword().length()>5 && newUser.getPassword().length()<30)
                response.add(Constants.correctPassword);
            else
                response.add(Constants.errorCodePassword);

//________PHONE_NUMBER__________________________________________________
        if(Tools.checkNullEmpty(newUser.getPhone()))
            response.add(Constants.errorCodeNullPhone);
        else
        if(Tools.checkDigits(newUser.getPhone()) && newUser.getPhone().length()>3 && newUser.getPhone().length()<=10)
            response.add(Constants.correctPhone);
        else
            response.add(Constants.errorCodePhone);

        if(response.get(0).equals(Constants.correctEmail)    &&  response.get(1).equals(Constants.correctUsername) &&
           response.get(2).equals(Constants.correctPassword) &&  response.get(3).equals(Constants.correctPhone)     )
        {
             response.add(Constants.userCreated);
             User user = new User();
             user.setEmail(newUser.getEmail());
             user.setFullName(newUser.getFullName());
             user.setPassword(newUser.getPassword());
             user.setPhone(newUser.getPhone());
             userRepository.save(user);
        }
        else
             response.add(Constants.userNotCreated);

    return response;
    }

    public String DeleteUser(DeleteUserDTO deleteUser){
        if(deleteUser.getAcceptAccountDeleting().equals("OK"))
        for(User thisUser: userRepository.findAll())
            {
            if(thisUser.getEmail().equals(deleteUser.getEmail()) &&
               thisUser.getPassword().equals(deleteUser.getPassword()))
                {
                thisUser.setDeleted(true);
                userRepository.save(thisUser);
                return Constants.userDeleted;
                }
            }
        return Constants.userNotDeleted;
    }

    public String LogIn(LogInDTO logIn){
        for(User thisUser: userRepository.findAll())
        {
            if(thisUser.isDeleted() && thisUser.getEmail().equals(logIn.getEmail()))
                return Constants.logInDeleted;
            if(thisUser.getEmail().equals(logIn.getEmail()) &&
                thisUser.getPassword().equals(logIn.getPassword())  )
            {
                tokenService.generateToken(thisUser);
                return Constants.logInOK;
            }
        }
        return Constants.logInNOK;
    }

    public String LogOff(String tokenValue){
        for(Token thisToken : tokenRepository.findAll())
            if(tokenValue.equals('"'+thisToken.getToken()+'"'))
            {
                thisToken.setStatus("INACTIVE");
                tokenRepository.save(thisToken);
                return Constants.logOffOK;
            }
        return Constants.logOffNOK;
    }
}
