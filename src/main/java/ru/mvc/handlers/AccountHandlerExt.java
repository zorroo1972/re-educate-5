package ru.mvc.handlers;

import ru.mvc.dto.AccountDto;
import ru.mvc.requests.TppProductRequest;

public interface AccountHandlerExt {
    AccountDto getAccount(TppProductRequest tppProductRequest);
}
