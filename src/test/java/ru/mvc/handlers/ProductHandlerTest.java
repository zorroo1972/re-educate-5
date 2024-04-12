package ru.mvc.handlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.mvc.dto.*;
import ru.mvc.exceptions.CheckRegisterException;
import ru.mvc.exceptions.CheckRegisterTypeException;
import ru.mvc.repositories.TppRefProductRegisterTypeRepo;
import ru.mvc.requests.TppProductRegisterRequest;
import ru.mvc.requests.TppProductRequest;

import java.util.List;

import static org.mockito.Mockito.*;

class ProductHandlerTest {
    @Mock
    TppProductDto tppProductDto;
    @InjectMocks
    ProductHandler productHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    TppRefProductRegisterTypeRepo tppRefProductRegisterTypeRepo;
    @Mock
    AccountHandler accountHandler;
    @Mock
    TppRefProductRegisterTypeDto tppRefProductRegisterTypeDto;
    @InjectMocks
    RegisterHandler registerHandler;

    @Test
    @DisplayName("testSetProduct")
    void testSetRegister() throws CheckRegisterTypeException, CheckRegisterException {
        when(tppRefProductRegisterTypeRepo.findByValue(anyString())).thenReturn(new TppRefProductRegisterTypeDto());
        when(accountHandler.getAccount(any())).thenReturn(new AccountDto());
        when(tppRefProductRegisterTypeDto.getValue()).thenReturn("getValueResponse");
        TppProductRegisterDto result = registerHandler.setRegister(new TppProductRegisterRequest(Long.valueOf(1), "registryTypeCode", null, "currencyCode", null, null, null, null, null, null, null));


    }
}
