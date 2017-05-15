package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.SeguimientoProductoBean;
import com.esliceu.comparador.dao.ProductoDao;
import com.esliceu.comparador.model.Producto;
import com.esliceu.comparador.model.SeguimientoProducto;
import com.esliceu.comparador.util.AccesToken;
import com.esliceu.comparador.util.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by blackwidow on 26/04/17.
 */
@RestController
public class SeguimientoProductoController extends SeguimientoProductoBean {

    @Autowired
    private ProductoDao productoDao;

    @RequestMapping(value = "/usuario/seguimiento/obtenerTodosLosSeguimientos",method = RequestMethod.POST)
    public @ResponseBody  List<Producto> obtenerTodosLosSeguimientos(@RequestBody Map<String,Object> json) throws UnsupportedEncodingException {
        JWT jwt = new JWT();
        AccesToken accesToken = jwt.decodificarJwt((String) json.get("accesToken"));
        List<Producto> productos = new ArrayList<>();
        for (SeguimientoProducto seguimientoProducto : getSeguimientoProductoDao().findByIdUsuario((long) accesToken.getId())){
            productos.add(productoDao.findOne(seguimientoProducto.getIdProducto()));
        }
        return productos;
    }
}
