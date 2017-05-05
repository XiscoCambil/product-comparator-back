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

    @Qualifier("token")
    private Token accesToken;

    @Qualifier("refreshToken")
    private RefreshToken refresToken;

    public JWT() throws UnsupportedEncodingException {
    }

    public HashMap<String,Object> crearJWT(int id, String email, Date ahora, int id_localidad) throws UnsupportedEncodingException {

        Date expiracion = new Date(ahora.getTime()+Keys.EXPIRACION_TOKEN);
        Date refreshExpiracion = new Date(expiracion.getTime()+Keys.EXPIRACION_REFRESH_TOKEN);

        accesToken = new Token(id,email,ahora,id_localidad,expiracion);
        HashMap<String,Object> tokens = new HashMap<>();

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

        tokens.put("acces_token",jwtAccesToken);
        tokens.put("refresh_token",jwtRefreshToken);

        return tokens;
    }

    public int validarJwt(String accesTokenCode) throws UnsupportedEncodingException {
        try {
           accesToken = decodificarJwt(accesTokenCode);
           if(accesToken.getFechaExp().getTime() < new Date().getTime()){
               return 502;
           }
        }catch (Exception e){
            return 500;
        }
        return 200;
    }

    public Token decodificarJwt(String accesTokenString) throws UnsupportedEncodingException {
        HashMap<String, Object> cuerpoToken;
        Jws<Claims> valoresToken;
        try {
            valoresToken = Jwts.parser()
                    .setSigningKey(Keys.SECRET_KEY.getBytes("UTF-8"))
                    .parseClaimsJws(accesTokenString);

            cuerpoToken = (LinkedHashMap<String, Object>) valoresToken.getBody().get("acces_token");

            accesToken = new Token((Integer) cuerpoToken.get("id"),(String) cuerpoToken.get("email"),new Date((Long) cuerpoToken.get("fecha")),
                    (Integer) cuerpoToken.get("id_localidad"), new Date((Long) cuerpoToken.get("fechaExp")));

        } catch (Exception e){
            return null;
        }

        return accesToken;
    }

    public HashMap<String,Object> refreshToken(String accesTokenCode,String refreshTokenCode) {
        LinkedHashMap<String, Object> cuerpoToken;
        Jws<Claims> valoresToken;
        HashMap<String,Object> newAccesToken;
        try {
            valoresToken = Jwts.parser()
                    .setSigningKey(Keys.SECRET_KEY.getBytes("UTF-8"))
                    .parseClaimsJws(refreshTokenCode);
            cuerpoToken = (LinkedHashMap<String, Object>) valoresToken.getBody().get("refresh_token");
            Date refreshExp = new Date((Long) cuerpoToken.get("refreshExp"));
            Date ahora = new Date();
            System.out.println(refreshExp.getTime());
            if (!cuerpoToken.get("acces_token").equals(accesTokenCode) || refreshExp.getTime() < ahora.getTime()) {
                return null;
            } else {
                JWT jwt = new JWT();
                Jws<Claims> valoresAccesToken = Jwts.parser()
                        .setSigningKey(Keys.SECRET_KEY.getBytes("UTF-8"))
                        .parseClaimsJws((String) cuerpoToken.get("acces_token"));
                cuerpoToken = (LinkedHashMap<String, Object>) valoresAccesToken.getBody().get("acces_token");
                newAccesToken = jwt.crearJWT((int)cuerpoToken.get("id"),(String) cuerpoToken.get("email"),new Date(),(int) cuerpoToken.get("id_localidad"));
            }
        }catch (Exception e){
            return null;
        }
        return newAccesToken;
    }

}
