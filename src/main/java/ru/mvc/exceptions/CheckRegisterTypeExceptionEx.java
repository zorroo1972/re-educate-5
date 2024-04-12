package ru.mvc.exceptions;

import ru.mvc.dto.TppRefProductRegisterTypeDto;
import ru.mvc.requests.TppProductRequest;

public class CheckRegisterTypeExceptionEx extends Exception {
    public TppProductRequest tppProductRequest;
    public TppRefProductRegisterTypeDto tppRefProductRegisterTypeDto;

    public CheckRegisterTypeExceptionEx() {
    }

    public CheckRegisterTypeExceptionEx(TppProductRequest tppProductRequest, TppRefProductRegisterTypeDto tppRefProductRegisterTypeDto) {
        this.tppProductRequest = tppProductRequest;
        this.tppRefProductRegisterTypeDto = tppRefProductRegisterTypeDto;
    }

    public TppProductRequest getTppProductRequest() {
        return tppProductRequest;
    }

    public TppRefProductRegisterTypeDto getTppRefProductRegisterTypeDto() {
        return tppRefProductRegisterTypeDto;
    }


}


