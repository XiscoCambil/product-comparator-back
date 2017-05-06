package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.BaseBean;
import com.esliceu.comparador.dao.UsuarioDao;
import com.esliceu.comparador.model.Usuario;
import com.esliceu.comparador.util.JWT;
import com.esliceu.comparador.util.Sha512;
import com.esliceu.comparador.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by blackwidow on 6/05/17.
 */
@RestController
public class TokenController extends BaseBean {

    @Qualifier("token")
    private Token token;

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value= "/token/crearToken", method = RequestMethod.POST)
    public @ResponseBody Token iniciarSesion(@RequestBody Usuario usuario)
            throws UnsupportedEncodingException {
        if(usuario.getEmail() != null && usuario.getPassword() != null) {
            Sha512 sha512 = new Sha512();
            usuario = usuarioDao.findByEmailAndPassword(usuario.getEmail(), sha512.get_SHA_512_SecurePassword(usuario.getPassword()));
            if (usuario != null) {
                JWT jwt = new JWT();
                token = jwt.crearJWT((int) (long) usuario.getId(), usuario.getEmail(), new Date(), usuario.getIdLocalidad());
            }
        }
        return token;
    }

    @RequestMapping(value = "/token/validarToken",method = RequestMethod.POST)
    public @ResponseBody int validateToken(@RequestBody Token token) throws UnsupportedEncodingException {
        JWT jwt = new JWT();
        int code =  jwt.validarJwt(token);
        return code;
    }

    @RequestMapping(value = "/token/refrescarToken",method = RequestMethod.POST)
    public @ResponseBody Token refreshToken(@RequestBody Token token) throws UnsupportedEncodingException {
        JWT jwt = new JWT();
        return jwt.refreshToken(token);

    }

}
