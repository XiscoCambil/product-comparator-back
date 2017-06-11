package com.esliceu.comparador.controlador;


import com.esliceu.comparador.bean.UsuarioBean;
import com.esliceu.comparador.model.Carro;
import com.esliceu.comparador.model.Usuario;
import com.esliceu.comparador.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by blackwidow on 24/04/17.
 */
@RestController
public class UsuarioController extends UsuarioBean {

    @Autowired
    @Qualifier("usuario")
    private Usuario usuario;

    @Autowired
    @Qualifier("jwt")
    private JWT jwt;


    @RequestMapping(value = "/usuario/obtenerLocalidadUsuario", method = RequestMethod.POST)
    public @ResponseBody  int obtenerLocalidadUsuario(@RequestBody Map<String,Object> json) throws IOException {
        AccesToken accesToken = validarToken(json);
        try{
            return getUsuarioDao().findOne((long)(int)accesToken.getId()).getIdLocalidad();
        }catch (Exception e){
            httpServletResponse.sendError(300);
        }
        return 0;
    }


    @RequestMapping(value = "/usuario/insertarUsuario", method = RequestMethod.POST)
    public
    @ResponseBody
    Object insertarUsuario(@RequestBody Usuario usuario) {

        try {
            if (usuario.getEmail() == null || usuario.getPassword() == null || usuario.getIdLocalidad() == 0) {
                httpServletResponse.sendError(Keys.ERROR_GENERICO_CODE);
                return null;
            }
            if (getUsuarioDao().findByEmail(usuario.getEmail()) != null) {
                httpServletResponse.sendError(Keys.EMAIL_REPETIDO_CODE);
                return null;
            }
            Sha512 sha512 = new Sha512();
            String hashPassword = sha512.get_SHA_512_SecurePassword(usuario.getPassword());
            try {
                getUsuarioDao().save(new Usuario(usuario.getNombre(), usuario.getApellidos(),
                        usuario.getTelefono(), usuario.getEmail(), hashPassword, usuario.getIdLocalidad()));
            } catch (DataIntegrityViolationException e) {
                return null;
            }
            return 200;
        } catch (Exception e) {

            return null;

        }
    }




}
