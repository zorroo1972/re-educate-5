package ru.mvc.exceptions;

import ru.mvc.requests.TppProductRequest;

public class CheckProductException extends Exception {
    public TppProductRequest tppProductRequest;
    public CheckProductException() {}

    public CheckProductException(TppProductRequest tppProductRequest) {
        this.tppProductRequest = tppProductRequest;
    }

    public TppProductRequest getTppProductRequest() {
        return tppProductRequest;
    }

    public void setTppProductRequest(TppProductRequest tppProductRequest) {
        this.tppProductRequest = tppProductRequest;
    }
}
