package com.example.toygry.Service;

import com.example.toygry.utils.KeycloakToken;
import com.example.toygry.utils.TokenUtils;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public KeycloakToken getToken(String token) {
        TokenUtils tokenUtils = new TokenUtils();

        return tokenUtils.tokenParser(token);
    }
}
