package com.senlainc.errors;

public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException() {
        super("Model wasn't found");
    }
}
