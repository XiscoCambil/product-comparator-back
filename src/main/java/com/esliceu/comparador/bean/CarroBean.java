package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.CarroDao;
import com.esliceu.comparador.model.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by blackwidow on 26/04/17.
 */
public class CarroBean extends BaseBean {

    @Autowired
    private CarroDao carroDao;

    @Qualifier("carro")
    private Carro carro;

    public CarroDao getCarroDao() {
        return carroDao;
    }

    public void setCarroDao(CarroDao carroDao) {
        this.carroDao = carroDao;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
