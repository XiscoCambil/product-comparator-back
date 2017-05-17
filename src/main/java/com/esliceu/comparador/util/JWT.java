package com.esliceu.comparador.util;



import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.UnsupportedEncodingException;

import java.util.*;
import java.util.Date;


/**
 * Created by blackwidow on 4/05/17.
 */
public class JWT {

    @Qualifier("accesToken")
    private AccesToken accesToken;

    @Qualifier("refreshToken")
    private RefreshToken refresToken;

    @Qualifier("token")
    private Token token;

    public JWT() throws UnsupportedEncodingException {
    }

    public Token crearJWT(int id, String email, Date ahora, int id_localidad) throws UnsupportedEncodingException {

        Date expiracion = new Date(ahora.getTime()+Keys.EXPIRACION_TOKEN);
        Date refreshExpiracion = new Date(expiracion.getTime()+Keys.EXPIRACION_REFRESH_TOKEN);

        accesToken = new AccesToken(id,email,ahora,id_localidad,expiracion);

        String jwtAccesToken = Jwts.builder()
                .claim("acces_token", accesToken)
                .signWith(
                        SignatureAlgorithm.HS256,
                        Keys.SECRET_KEY.getBytes("UTF-8")
                )
                .compact();

        refresToken = new RefreshToken(jwtAccesToken,refreshExpiracion);

        String jwtRefreshToken = Jwts.builder()
                .claim("refresh_token", refresToken)
                .signWith(
                        SignatureAlgorithm.HS256,
                        Keys.SECRET_KEY.getBytes("UTF-8")
                )
                .compact();

        return new Token(jwtAccesToken,jwtRefreshToken);
    }

    public int validarJwt(Token token) throws UnsupportedEncodingException {
        try {
           accesToken = decodificarJwt(token.getAccesToken());
           if(accesToken.getFechaExp().getTime() < new Date().getTime()){
               return 302;
           }
        }catch (Exception e){
            return 300;
        }
        return 200;
    }

    public AccesToken decodificarJwt(String accesTokenString) throws UnsupportedEncodingException {
        HashMap<String, Object> cuerpoToken;
        Jws<Claims> valoresToken;
        try {
            valoresToken = Jwts.parser()
                    .setSigningKey(Keys.SECRET_KEY.getBytes("UTF-8"))
                    .parseClaimsJws(accesTokenString);

            cuerpoToken = (LinkedHashMap<String, Object>) valoresToken.getBody().get("acces_token");

            accesToken = new AccesToken((Integer) cuerpoToken.get("id"),(String) cuerpoToken.get("email"),new Date((Long) cuerpoToken.get("fecha")),
                    (Integer) cuerpoToken.get("id_localidad"), new Date((Long) cuerpoToken.get("fechaExp")));

        } catch (Exception e){
            return null;
        }

        return accesToken;
    }

    public Token refreshToken(Token token) {
        LinkedHashMap<String, Object> cuerpoToken;
        Jws<Claims> valoresRefreshToken;
        try {
            valoresRefreshToken = Jwts.parser()
                    .setSigningKey(Keys.SECRET_KEY.getBytes("UTF-8"))
                    .parseClaimsJws(token.getRefreshToken());
            cuerpoToken = (LinkedHashMap<String, Object>) valoresRefreshToken.getBody().get("refresh_token");
            Date refreshExp = new Date((Long) cuerpoToken.get("refreshExp"));
            Date ahora = new Date();
            if (!cuerpoToken.get("acces_token").equals(token.getAccesToken()) || refreshExp.getTime() < ahora.getTime()) {
                return null;
            } else {
                JWT jwt = new JWT();
                Jws<Claims> valoresAccesToken = Jwts.parser()
                        .setSigningKey(Keys.SECRET_KEY.getBytes("UTF-8"))
                        .parseClaimsJws((String) cuerpoToken.get("acces_token"));
                cuerpoToken = (LinkedHashMap<String, Object>) valoresAccesToken.getBody().get("acces_token");
                token = jwt.crearJWT((int)cuerpoToken.get("id"),(String) cuerpoToken.get("email"),new Date(),(int) cuerpoToken.get("id_localidad"));
            }
            return token;
        }catch (Exception e){
            return null;
        }
    }

}
