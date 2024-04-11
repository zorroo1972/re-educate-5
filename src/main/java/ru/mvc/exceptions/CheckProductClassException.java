package ru.mvc.exceptions;

import ru.mvc.requests.TppProductRequest;

public class CheckProductClassException extends Exception {
    public TppProductRequest tppProductRequest;
    public CheckProductClassException() {}

    public CheckProductClassException(TppProductRequest tppProductRequest) {
        this.tppProductRequest = tppProductRequest;
    }

    public TppProductRequest getTppProductRequest() {
        return tppProductRequest;
    }

    public void setTppProductRequest(TppProductRequest tppProductRequest) {
        this.tppProductRequest = tppProductRequest;
    }
}
