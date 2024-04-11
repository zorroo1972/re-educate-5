package ru.mvc.exceptions;

import ru.mvc.requests.TppProductRequest;

public class CheckProductException extends Exception {
    public TppProductRequest tppProductRequest;
    public Long idProduct;
    public CheckProductException() {}

    public CheckProductException(TppProductRequest tppProductRequest, Long idProduct) {
        this.tppProductRequest = tppProductRequest;
        this.idProduct = idProduct;
    }

    public TppProductRequest getTppProductRequest() {
        return tppProductRequest;
    }

    public Long getIdProduct() {
        return idProduct;
    }
}
