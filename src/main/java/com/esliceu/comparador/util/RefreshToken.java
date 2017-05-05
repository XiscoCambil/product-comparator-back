package com.esliceu.comparador.util;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;

/**
 * Created by blackwidow on 5/05/17.
 */
public class RefreshToken {


    private String acces_token;

    private Date refreshExp;

    public RefreshToken() {
    }

    public RefreshToken(String acces_token, Date refreshExp) {
        this.acces_token = acces_token;
        this.refreshExp = refreshExp;
    }

    public String getAcces_token() {
        return acces_token;
    }

    public void setAcces_token(String acces_token) {
        this.acces_token = acces_token;
    }

    public Date getRefreshExp() {
        return refreshExp;
    }

    public void setRefreshExp(Date refreshExp) {
        this.refreshExp = refreshExp;
    }
}
