package com.esliceu.comparador.controlador;


import com.esliceu.comparador.bean.UsuarioBean;
import com.esliceu.comparador.model.Carro;
import com.esliceu.comparador.model.Usuario;
import com.esliceu.comparador.util.AccesToken;
import com.esliceu.comparador.util.JWT;
import com.esliceu.comparador.util.Sha512;
import com.esliceu.comparador.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
@RestController
public class UsuarioController extends UsuarioBean{

    @Autowired
    private Usuario usuario;

    @RequestMapping(value= "/usuario/obtenerUsuario", method = RequestMethod.POST)
    public Usuario obtenerTodosUsuarios(@RequestBody Token token) throws UnsupportedEncodingException {
        JWT jwt = new JWT();
        AccesToken accesToken = jwt.decodificarJwt(token.getAccesToken());
        return getUsuarioDao().findOne((long)accesToken.getId());
    }


    @RequestMapping(value= "/usuario/insertarUsuario", method = RequestMethod.POST)
    public @ResponseBody Object insertarUsuario(@RequestBody Usuario usuario){

        if(usuario.getEmail() == null || usuario.getPassword() == null || usuario.getIdLocalidad() == 0){
            return 500;
        }
        Sha512 sha512 = new Sha512();
        String hashPassword = sha512.get_SHA_512_SecurePassword(usuario.getPassword());
       try {
           getUsuarioDao().save(new Usuario(usuario.getNombre(), usuario.getApellidos(),
                   usuario.getTelefono(), usuario.getEmail(), hashPassword, usuario.getIdLocalidad()));
       }catch (DataIntegrityViolationException e){
           return 500;
       }
       return 200;
    }


   /* @RequestMapping("/ObtenerMarcaPorNombre")
    public Marca obtenerMarcaPorNombre(@RequestParam(required = true) String nombre){
        return getMarcaDao().findByNombre(nombre);
    }
    */

}
