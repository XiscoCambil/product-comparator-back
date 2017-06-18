package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.EmpresaDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 24/04/17.
 */
public class EmpresaBean extends BaseBean{

    @Autowired
    private EmpresaDao empresaDao;

    public EmpresaDao getEmpresaDao() {
        return empresaDao;
    }

    public void setEmpresaDao(EmpresaDao empresaDao) {
        this.empresaDao = empresaDao;
    }
}
