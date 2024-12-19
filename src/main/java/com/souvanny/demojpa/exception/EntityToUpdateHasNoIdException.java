package com.souvanny.demojpa.exception;

public class EntityToUpdateHasNoIdException extends RuntimeException {
    public EntityToUpdateHasNoIdException(String message) {
        super(message);
    }
}
