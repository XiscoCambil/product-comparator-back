package com.esliceu.comparador.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static com.esliceu.comparador.util.Keys.*;

/**
 * Created by blackwidow on 1/05/17.
 */
public class Token {

    Algorithm algorithm = Algorithm.HMAC256(Keys.SECRET_KEY);

    public Token() throws UnsupportedEncodingException {
    }

    public String createToken(){
        return JWT.create()
                .withClaim("nombre","xiscoJWT")
                .withIssuer("auth0")
                .sign(algorithm);
    }

    public Object decodeToken(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getToken();
        }catch (JWTCreationException jwt){
            return jwt.getMessage();
        }

    }


}
