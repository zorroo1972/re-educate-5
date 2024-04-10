package ru.mvc.exceptions;

import ru.mvc.requests.TppProductRequest;

public class CheckAgreementException extends Exception {
    public TppProductRequest tppProductRequest;
    public CheckAgreementException() {}

    public CheckAgreementException(TppProductRequest tppProductRequest) {
        this.tppProductRequest = tppProductRequest;
    }

    public TppProductRequest getTppProductRequest() {
        return tppProductRequest;
    }

    public void setTppProductRequest(TppProductRequest tppProductRequest) {
        this.tppProductRequest = tppProductRequest;
    }
}
