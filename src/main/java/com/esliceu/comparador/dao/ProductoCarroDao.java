package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.ProductoCarro;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by blackwidow on 26/04/17.
 */
public interface ProductoCarroDao extends CrudRepository<ProductoCarro,Long> {
    ProductoCarro findByIdCarro(Long id_carro);

}
