package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.SeguimientoProductoBean;
import com.esliceu.comparador.dao.ProductoDao;
import com.esliceu.comparador.dao.SeguimientoProductoDao;
import com.esliceu.comparador.dao.UsuarioDao;
import com.esliceu.comparador.model.Producto;
import com.esliceu.comparador.model.SeguimientoProducto;
import com.esliceu.comparador.util.AccesToken;
import com.esliceu.comparador.util.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @Autowired
    private SeguimientoProductoDao seguimientoProductoDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "/usuario/seguimiento/obtenerTodosLosSeguimientos", method = RequestMethod.POST)
    public @ResponseBody List<SeguimientoProducto> obtenerTodosLosSeguimientos(@RequestBody Map<String, Object> json) throws IOException {
        AccesToken accesToken = validarToken(json);
        try {
            return getSeguimientoProductoDao().findByIdUsuario((long) accesToken.getId());
        } catch (Exception e) {
            httpServletResponse.sendError(300);
            return null;
        }
    }

    @RequestMapping(value = "/usuario/seguimiento/realizarSeguimiento", method = RequestMethod.POST)
    public @ResponseBody Producto realizarSeguimiento(@RequestBody Map<String, Object> json) throws IOException {
        AccesToken accesToken = validarToken(json);
        long id_producto = (long) (int) json.get("id_producto");
        try {
            getSeguimientoProductoDao().save(new SeguimientoProducto(id_producto, accesToken.getId()));
            return productoDao.findOne(id_producto);
        } catch (Exception e) {
            httpServletResponse.sendError(300);
            return null;
        }
    }


    @RequestMapping(value = "/usuario/seguimiento/eliminarSeguimiento",method = RequestMethod.POST)
    public @ResponseBody Object eliminarSeguimiento(@RequestBody Map<String,Object> json) throws IOException {
        AccesToken accesToken = validarToken(json);
        long id_producto = (long)(int)json.get("id_producto");
        try {
            for(SeguimientoProducto seguimientoProducto : usuarioDao.findOne((long) accesToken.getId()).getSeguimientoProductos()){
                if(seguimientoProducto.getIdProducto() == id_producto){
                    getSeguimientoProductoDao().delete(seguimientoProducto);
                    return 200;
                }
            }
            throw new Exception();
        }catch (Exception e){
            httpServletResponse.sendError(300);
            return null;
        }

    }

}
