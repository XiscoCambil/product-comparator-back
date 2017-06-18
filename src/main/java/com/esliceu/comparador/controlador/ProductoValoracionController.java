package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.ProductoValoracionBean;
import com.esliceu.comparador.model.Carro;
import com.esliceu.comparador.model.ProductoValoracion;
import com.esliceu.comparador.util.AccesToken;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by blackwidow on 26/04/17.
 */
@RestController
public class ProductoValoracionController extends ProductoValoracionBean {



    @RequestMapping(value= "/producto/valorarProducto", method = RequestMethod.POST)
    public @ResponseBody
    ProductoValoracion valorarProducto(@RequestBody Map<String,Object> json) throws IOException {
        AccesToken accesToken = validarToken(json);
        try {
            int id_producto = (int) json.get("id_producto");
            int valoracion = (int) json.get("valoracion");
            if (id_producto > 0) {
                ProductoValoracion pv = new ProductoValoracion(valoracion, id_producto,accesToken.getId());
                ProductoValoracion pv2 = getProductoValoracionDao().save(pv);
               return pv2;

            }
        } catch (Exception e) {
            httpServletResponse.sendError(300);
        }
        return null;
    }

    @RequestMapping(value= "/producto/comprobarValoracionUsuario", method = RequestMethod.POST)
    public @ResponseBody
    List<ProductoValoracion> comprobarValoracionUsuario(@RequestBody Map<String,Object> json) throws IOException {

        AccesToken accesToken = validarToken(json);
        try {
            List<ProductoValoracion> productoValoracion = getProductoValoracionDao().findByIdUsuario(accesToken.getId());
            if(productoValoracion != null){
                return productoValoracion;
            }
        }catch (Exception e){
            httpServletResponse.sendError(300);
        }
        return null;
    }

}
