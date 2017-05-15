package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.CarroBean;
import com.esliceu.comparador.dao.ProductoCarroDao;
import com.esliceu.comparador.dao.ProductoDao;
import com.esliceu.comparador.dao.ProductoTiendaDao;
import com.esliceu.comparador.dao.UsuarioDao;
import com.esliceu.comparador.model.*;
import com.esliceu.comparador.util.AccesToken;
import com.esliceu.comparador.util.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private ProductoDao productoDao;

    @Autowired
    private ProductoTiendaDao productoTiendaDao;

    @Autowired
    private ProductoCarroDao productoCarroDao;


    @RequestMapping(value= "/usario/carros/obtenerCarrosUsuario", method = RequestMethod.POST)
    public @ResponseBody List<Carro> obtenerCarrosDeUsuario(@RequestBody Map<String,Object> json) throws UnsupportedEncodingException {

        JWT jwt = new JWT();
        AccesToken accesToken = jwt.decodificarJwt((String) json.get("accesToken"));

        return usuarioDao.findOne((long)accesToken.getId()).getCarros();
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

    @RequestMapping(value= "/carro/eliminarCarroUsuario", method = RequestMethod.POST)
    public @ResponseBody Object eliminarCarroUsuario(@RequestBody Map<String,Object> json) throws UnsupportedEncodingException {

        JWT jwt = new JWT();
        AccesToken accesToken = jwt.decodificarJwt((String) json.get("accesToken"));
        Long id_carro = (long)(int)json.get("id_carro");
        List<Carro> carros = usuarioDao.findOne((long)accesToken.getId()).getCarros();
        for(Carro carro: carros){
            if(carro.getId() == id_carro){
                for(ProductoCarro productoCarro : carro.getProductos()){
                    productoCarroDao.delete(productoCarro);
                }
                getCarroDao().delete(carro);
                break;
            }
        }
        return 200;
    }

}
