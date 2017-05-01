package com.esliceu.comparador.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by blackwidow on 22/04/17.
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable {

    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
