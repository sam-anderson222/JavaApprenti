package com.examples.DataObjects;

// Result class for returning the result of operations done in the program.
public class Result<T> {
    private T data;
    private boolean status;

    public Result(T data, boolean status) {
        this.data = data;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public boolean getStatus() {
        return status;
    }
}
