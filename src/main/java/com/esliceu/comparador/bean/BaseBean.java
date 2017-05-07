package com.esliceu.comparador.bean;

import com.esliceu.comparador.util.HttpResponse;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 27/04/17.
 */
public class BaseBean {

    @Autowired
    public BeanFactory beanFactory;

    @Autowired
    private HttpResponse httpResponse;

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }
}
