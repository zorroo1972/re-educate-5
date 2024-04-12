package ru.mvc.exceptions;

import ru.mvc.requests.TppProductRequest;

public class CheckProductIdException extends Exception {
    TppProductRequest tppProductRequest;
    public CheckProductIdException() {}

    public CheckProductIdException(TppProductRequest tppProductRequest, Long idProduct) {
        this.tppProductRequest = tppProductRequest;
    }

    public CheckProductIdException(TppProductRequest tppProductRequest) {
    }

    public TppProductRequest getTppProductRequest() {
        return tppProductRequest;
    }
    
}
