package ru.mvc.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import ru.mvc.exceptions.CheckRegisterException;
import ru.mvc.exceptions.CheckRegisterTypeException;
import ru.mvc.requests.TppProductRegisterRequest;
import ru.mvc.services.TppProductRegisterService;

import static org.mockito.Mockito.*;

class TppProductRegisterControllerTest {
    @Mock
    TppProductRegisterService tppProductRegisterService;
    @InjectMocks
    TppProductRegisterController tppProductRegisterController;


    @Test
    @DisplayName("testCreateTppProductRegister")
    void testCreateTppProductRegister() throws CheckRegisterTypeException, CheckRegisterException {
    }
}

