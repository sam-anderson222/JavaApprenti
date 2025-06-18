package com.examples.DataObjects;

// Returns the status of an operation, a message, and (if applicable) some data relating to the operator preformed.
public class Result<T> {
    private final T data;
   private final boolean status;

   public Result(T data, boolean status) {
       this.status = status;
       this.data = data;
   }

    public boolean getStatus() {
        return status;
    }

    public T getResult() {
        return data;
    }
}
