package ru.mvc.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mvc.requests.TppProductRegisterRequest;

public class CheckRegisterException extends Exception {
    public TppProductRegisterRequest tppProductRegisterRequest;
    public CheckRegisterException() {}

    public CheckRegisterException(TppProductRegisterRequest tppProductRegisterRequest) {
        this.tppProductRegisterRequest = tppProductRegisterRequest;
    }

    public TppProductRegisterRequest getTppProductRegisterRequest() {
        return tppProductRegisterRequest;
    }

    public void setTppProductRegisterRequest(TppProductRegisterRequest tppProductRegisterRequest) {
        this.tppProductRegisterRequest = tppProductRegisterRequest;
    }
}
