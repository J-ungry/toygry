package com.example.toygry.utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;

import java.util.Base64;
import java.util.Map;

@Slf4j
@NoArgsConstructor
public class TokenUtils {

    public KeycloakToken tokenParser(String token) {
        String tokenPayload = token.split("\\.")[1];
        Base64.Decoder decoder = Base64.getDecoder();

        String payload = new String(decoder.decode(tokenPayload));
        JsonParser jsonParser = new BasicJsonParser();
        Map<String, Object> tokenMap = jsonParser.parseMap(payload);

        return new KeycloakToken(
                tokenMap.get("name").toString(),
                tokenMap.get("preferred_username").toString(),
                tokenMap.get("email").toString());

    }
}
