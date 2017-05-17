package com.esliceu.comparador.bean;

import com.esliceu.comparador.util.AccesToken;
import com.esliceu.comparador.util.JWT;
import com.esliceu.comparador.util.Token;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by blackwidow on 27/04/17.
 */
public class BaseBean {

    @Autowired
    public BeanFactory beanFactory;

    @Autowired
    public HttpServletResponse httpServletResponse;

    public AccesToken validarToken(Map<String,Object> json) throws IOException {
        JWT jwt = new JWT();
        Token token = new Token((String) json.get("accesToken"), null);
        int code = jwt.validarJwt(token);
        if(code != 200){
           return null;
        }
        return jwt.decodificarJwt(token.getAccesToken());
    }
}
