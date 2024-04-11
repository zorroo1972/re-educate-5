package ru.mvc.handlers;

import ru.mvc.dto.TppProductRegisterDto;
import ru.mvc.exceptions.CheckRegisterException;
import ru.mvc.exceptions.CheckRegisterTypeException;
import ru.mvc.requests.TppProductRequest;

public interface RegisterHandlerExt {
    TppProductRegisterDto setRegister(TppProductRequest tppProductRequest, String typeReestr) throws CheckRegisterException, CheckRegisterTypeException;
}
