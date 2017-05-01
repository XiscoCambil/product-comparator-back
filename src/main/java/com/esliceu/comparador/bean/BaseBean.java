package com.esliceu.comparador.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 27/04/17.
 */
public class BaseBean {

    @Autowired
    public BeanFactory beanFactory;
}
