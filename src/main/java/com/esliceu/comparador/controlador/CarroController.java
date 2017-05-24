package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.CarroBean;
import com.esliceu.comparador.dao.ProductoCarroDao;
import com.esliceu.comparador.dao.ProductoDao;
import com.esliceu.comparador.dao.ProductoTiendaDao;
import com.esliceu.comparador.dao.UsuarioDao;
import com.esliceu.comparador.model.*;
import com.esliceu.comparador.util.AccesToken;
import com.esliceu.comparador.util.JWT;
import com.esliceu.comparador.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by blackwidow on 26/04/17.
 */
@RestController
public class CarroController extends CarroBean {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private ProductoTiendaDao productoTiendaDao;

    @Autowired
    private ProductoCarroDao productoCarroDao;


    @RequestMapping(value= "/usario/carros/obtenerCarrosUsuario", method = RequestMethod.POST)
    public @ResponseBody List<Carro> obtenerCarrosDeUsuario(@RequestBody Map<String,Object> json) throws IOException {

        AccesToken accesToken = validarToken(json);
        try {
            return usuarioDao.findOne((long) accesToken.getId()).getCarros();
        }catch (Exception e){
            httpServletResponse.sendError(300);
            return null;
        }
    }

    @RequestMapping(value= "/carro/obtenerProductosCarro", method = RequestMethod.POST)
    public @ResponseBody List<ProductoTienda> obtenerProductosCarro(@RequestBody Map<String,Object> json) throws UnsupportedEncodingException {

        JWT jwt = new JWT();
        HashMap<String,Object> map = new HashMap<>();
        List<ProductoTienda> productoEnCarro = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        AccesToken accesToken = jwt.decodificarJwt((String) json.get("accesToken"));
        Usuario usuario = usuarioDao.findOne((long)accesToken.getId());
        for(Carro carro : usuario.getCarros()){
            if(carro.getId() == (int) json.get("id_carro")){
                for(ProductoCarro productoCarro : getCarroDao().findById(carro.getId()).getProductos()) {
                    productoEnCarro.add(productoTiendaDao.findOne(productoCarro.getIdProductoTienda()));
                }
            }
        }

        return productoEnCarro;
    }

    @RequestMapping(value= "/usuario/carro/eliminarCarroUsuario", method = RequestMethod.POST)
    public @ResponseBody Object eliminarCarroUsuario(@RequestBody Map<String,Object> json) throws IOException {

        AccesToken accesToken = validarToken(json);
        try{
            int id_carro = (int) json.get("id_carro");
            List<Carro> carros = usuarioDao.findOne((long)accesToken.getId()).getCarros();
            for(Carro carro: carros){
                if(carro.getId() == id_carro){
                    for(ProductoCarro productoCarro : carro.getProductos()){
                        productoCarroDao.delete(productoCarro);
                    }
                    getCarroDao().delete(carro);
                    return 200;
                }
            }
        }catch (Exception e){
            httpServletResponse.sendError(300);
            return null;
        }
        return null;

    }

    @RequestMapping(value= "/usuario/carro/anadirCarroUsuario", method = RequestMethod.POST)
    public @ResponseBody Carro añadirCarroUsuario(@RequestBody Map<String,Object> json) throws IOException {
        AccesToken accesToken = validarToken(json);
        try {
            Carro carro = new Carro((long) accesToken.getId(), (String) json.get("nombre"));
            carro.setProductos(new ArrayList<>());
            getCarroDao().save(carro);
            return carro;
        }catch (Exception e){
            httpServletResponse.sendError(300);
            return null;
        }
    }

    @RequestMapping(value= "/usuario/carro/editarCarroUsuario", method = RequestMethod.POST)
    public @ResponseBody Object editarCarroUsuario(@RequestBody Map<String,Object> json) throws IOException {

        AccesToken accesToken = validarToken(json);
        try{
            List<Carro> carros = usuarioDao.findOne((long) accesToken.getId()).getCarros();
            int id_carro = (int) json.get("id_carro");
            for(Carro carro: carros){
                if(carro.getId() == id_carro){
                    carro.setNombre((String) json.get("nombre"));
                    getCarroDao().save(carro);
                    return 200;
                }
            }
        }catch (Exception e){
            httpServletResponse.sendError(300);
            return null;
        }
        return null;
    }

    @RequestMapping(value= "/usuario/carro/anadirProductoACarro", method = RequestMethod.POST)
    public @ResponseBody Object anadirProductoACarro(@RequestBody Map<String,Object> json) throws IOException {

        AccesToken accesToken = validarToken(json);
        try{
            for(Carro carro : usuarioDao.findOne((long)accesToken.getId()).getCarros()){
                int id_carro = (int) json.get("id_carro");
                Long id = carro.getId();
                if(id == id_carro) {
                    ProductoCarro productoCarro = new ProductoCarro( new Long((int)json.get("idProductoTienda")) ,id);
                    productoCarroDao.save(productoCarro);
                    return 200;
                }
            }
            httpServletResponse.sendError(300);
        }catch (Exception e){
            httpServletResponse.sendError(300);
        }
        return null;
    }

}
