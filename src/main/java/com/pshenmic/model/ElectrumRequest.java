package com.pshenmic.model;

import java.util.List;

public abstract class ElectrumRequest {
        String id;
        String method;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
