package com.esliceu.comparador.util;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;


/**
 * Created by blackwidow on 1/05/17.
 */
public class Token {

    private String accesToken;

    private String refreshToken;

    public Token() {
    }

    public Token(String accesToken, String refreshToken) {
        this.accesToken = accesToken;
        this.refreshToken = refreshToken;
    }

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
