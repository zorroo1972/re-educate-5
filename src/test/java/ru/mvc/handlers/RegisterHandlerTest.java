package ru.mvc.handlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.mvc.dto.AccountDto;
import ru.mvc.dto.TppProductRegisterDto;
import ru.mvc.dto.TppRefProductRegisterTypeDto;
import ru.mvc.exceptions.CheckRegisterException;
import ru.mvc.exceptions.CheckRegisterTypeException;
import ru.mvc.repositories.TppRefProductRegisterTypeRepo;
import ru.mvc.requests.TppProductRegisterRequest;

import static org.mockito.Mockito.*;

class RegisterHandlerTest {
    @Mock
    TppRefProductRegisterTypeRepo tppRefProductRegisterTypeRepo;
    @Mock
    AccountHandler accountHandler;
    @Mock
    TppProductRegisterDto tppProductRegisterDto;
    @Mock
    TppRefProductRegisterTypeDto tppRefProductRegisterTypeDto;
    @InjectMocks
    RegisterHandler registerHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("testSetRegister")
    void testSetRegister() throws CheckRegisterTypeException, CheckRegisterException {
        when(tppRefProductRegisterTypeRepo.findByValue(anyString())).thenReturn(new TppRefProductRegisterTypeDto());
        when(accountHandler.getAccount(any())).thenReturn(new AccountDto());
        when(tppRefProductRegisterTypeDto.getValue()).thenReturn("getValueResponse");
        TppProductRegisterDto result = registerHandler.setRegister(new TppProductRegisterRequest(Long.valueOf(1), "registryTypeCode", null, "currencyCode", null, null, null, null, null, null, null));

    }
}
