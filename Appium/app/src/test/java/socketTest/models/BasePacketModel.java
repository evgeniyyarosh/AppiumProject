package com.smartnavigationsystems.ourschoolbus.sockets.models;

import com.google.gson.Gson;

/**
 * Created by syn on 23.08.16.
 */
public class BasePacketModel<T> {
    private boolean success;
    private T data;
    private String error;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
