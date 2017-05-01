package com.esliceu.comparador.controlador;

import com.auth0.jwt.JWT;
import com.esliceu.comparador.bean.UsuarioBean;
import com.esliceu.comparador.model.Usuario;
import com.esliceu.comparador.util.Token;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
@RestController
public class UsuarioController extends UsuarioBean{


    @RequestMapping("/ObtenerTodosUsuarios")
    public Object obtenerTodosUsuarios() throws UnsupportedEncodingException {
        Token token = new Token();
        String code =  token.createToken();
        System.out.println(code);
        return token.decodeToken(code);
    }


    @RequestMapping(value= "/usuario/insertarUsuario", method = RequestMethod.POST)
    @ResponseBody
    public String insertarUsuario(@RequestParam String nombre,
                                  @RequestParam String apellidos,
                                  @RequestParam Long telefono,
                                  @RequestParam(required=true) String email,
                                  @RequestParam(required=true) String password,
                                  @RequestParam(required=true) Long id_localidad){



       try {
           getUsuarioDao().save(new Usuario(nombre, apellidos, telefono, email, password, id_localidad));
       }catch (DataIntegrityViolationException e){
           return e.getMessage();
       }
       /*
       catch (DataException de){
           return "ha habido un error en la inserccion";
       }catch (MySQLIntegrityConstraintViolationException cve){
           return "Este email ya a sido introducido";
       }
*/
       return "insertado correctamente";
    }

   /* @RequestMapping("/ObtenerMarcaPorNombre")
    public Marca obtenerMarcaPorNombre(@RequestParam(required = true) String nombre){
        return getMarcaDao().findByNombre(nombre);
    }
    */

}
