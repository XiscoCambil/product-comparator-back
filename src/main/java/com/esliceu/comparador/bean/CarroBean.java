package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.CarroDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 26/04/17.
 */
public class CarroBean extends BaseBean {

    @Autowired
    private CarroDao carroDao;

    public CarroDao getCarroDao() {
        return carroDao;
    }

    public void setCarroDao(CarroDao carroDao) {
        this.carroDao = carroDao;
    }
}
