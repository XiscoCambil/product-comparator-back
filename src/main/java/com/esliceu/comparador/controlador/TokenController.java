package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.BaseBean;
import com.esliceu.comparador.dao.UsuarioDao;
import com.esliceu.comparador.model.Usuario;
import com.esliceu.comparador.util.JWT;
import com.esliceu.comparador.util.Keys;
import com.esliceu.comparador.util.Sha512;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by blackwidow on 6/05/17.
 */
@RestController
public class TokenController extends BaseBean {

    @Qualifier("usuario")
    private Usuario usuario;

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value= "/token/crearToken", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> iniciarSesion(@RequestParam String email,
                                                 @RequestParam String password
    ) throws UnsupportedEncodingException {
        Sha512 sha512 = new Sha512();
        usuario = usuarioDao.findByEmailAndPassword(email, sha512.get_SHA_512_SecurePassword(password));
        if(usuario != null){
            JWT jwt = new JWT();
            return jwt.crearJWT((int)(long)usuario.getId(),usuario.getEmail(),new Date(),usuario.getIdLocalidad());
        }
        return null;
    }

    @RequestMapping("/token/validarToken")
    public int validateToken(@RequestParam String accesToken) throws UnsupportedEncodingException {
        JWT jwt = new JWT();
        int code =  jwt.validarJwt(accesToken);
        return code;
    }

    @RequestMapping("/token/refrescarToken")
    public HashMap<String,Object> refreshToken(@RequestParam String accesTokenCode,
                                             @RequestParam String refreshTokenCode) throws UnsupportedEncodingException {
        JWT jwt = new JWT();
        return jwt.refreshToken(accesTokenCode,refreshTokenCode);

    }

}
