package ru.mvc.exceptions;

import ru.mvc.dto.TppRefProductRegisterTypeDto;
import ru.mvc.requests.TppProductRegisterRequest;
import ru.mvc.requests.TppProductRequest;

public class CheckRegisterTypeException extends Exception {
    public TppProductRegisterRequest tppProductRegisterRequest;
    public TppRefProductRegisterTypeDto tppRefProductRegisterTypeDto;

    public CheckRegisterTypeException() {
    }

    public CheckRegisterTypeException(TppProductRegisterRequest tppProductRegisterRequest, TppRefProductRegisterTypeDto tppRefProductRegisterTypeDto) {
        this.tppProductRegisterRequest = tppProductRegisterRequest;
        this.tppRefProductRegisterTypeDto = tppRefProductRegisterTypeDto;
    }

    public TppProductRegisterRequest getTppProductRegisterRequest() {
        return tppProductRegisterRequest;
    }

    public void setTppProductRegisterRequest(TppProductRegisterRequest tppProductRegisterRequest) {
        this.tppProductRegisterRequest = tppProductRegisterRequest;
    }

    public TppRefProductRegisterTypeDto getTppRefProductRegisterTypeDto() {
        return tppRefProductRegisterTypeDto;
    }

    public void setTppRefProductRegisterTypeDto(TppRefProductRegisterTypeDto tppRefProductRegisterTypeDto) {
        this.tppRefProductRegisterTypeDto = tppRefProductRegisterTypeDto;
    }
}


