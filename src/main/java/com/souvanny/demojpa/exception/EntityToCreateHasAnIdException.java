package com.souvanny.demojpa.exception;

public class EntityToCreateHasAnIdException extends RuntimeException {
    public EntityToCreateHasAnIdException(String message) {
        super(message);
    }
}