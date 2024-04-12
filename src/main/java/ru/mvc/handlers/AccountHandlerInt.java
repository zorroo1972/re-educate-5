package ru.mvc.handlers;

import ru.mvc.dto.AccountDto;
import ru.mvc.requests.TppProductRequest;

public interface AccountHandlerInt {
    AccountDto getAccount(TppProductRequest tppProductRequest ,String registerType);
}
