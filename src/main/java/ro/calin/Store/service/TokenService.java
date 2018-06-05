package ro.calin.Store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.calin.Store.models.Token;
import ro.calin.Store.models.User;
import ro.calin.Store.repository.TokenRepository;
import ro.calin.Store.utils.TokenGenerator;

@Service
public class TokenService {

    @Autowired
    TokenRepository tokenRepository;
    public Token generateToken(User user){
        Token token = new Token();
        token.setStatus("ACTIVE");
        token.setLifeSpan(60*60*24);
        token.setToken(new TokenGenerator().nextString());
        token.setUser(user);

        tokenRepository.save(token);
        return token;
    }

    public boolean isTokenValid(String tokenCode){
        for(Token t:tokenRepository.findAll()) {
            if (t.getToken().equals(tokenCode) && t.getStatus().equals("ACTIVE"))
                return  true;
        }
        return false;
    }

}
