package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.Producto;
import com.mysql.jdbc.log.Log;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
public interface ProductoDao extends CrudRepository<Producto,Long> {


    Producto findByCodigoBarras(String codigo_de_barras);
    Producto findByValorEnergetico(int valor_energetico);
    List<Producto> findByProteinas(Double proteinas);
    List<Producto>  findByCarbohidratos(Double carboHidratos);
    List<Producto> findByGrasas(Double grasas);
    List<Producto> findByIdCategoria(Long id_categoria);

}
