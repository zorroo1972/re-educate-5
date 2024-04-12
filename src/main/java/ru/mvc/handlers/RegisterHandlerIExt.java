package ru.mvc.handlers;

import ru.mvc.dto.TppProductRegisterDto;
import ru.mvc.exceptions.CheckRegisterTypeException;
import ru.mvc.exceptions.CheckRegisterTypeExceptionEx;
import ru.mvc.requests.TppProductRequest;

public interface RegisterHandlerIExt {
    TppProductRegisterDto setRegister(TppProductRequest tppProductRequest, Long productCodeId, String productValue) throws CheckRegisterTypeException, CheckRegisterTypeExceptionEx;
}
