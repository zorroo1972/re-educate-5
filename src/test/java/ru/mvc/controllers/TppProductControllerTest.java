package ru.mvc.controllers;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.mvc.exceptions.*;
import ru.mvc.services.TppProductService;
class TppProductControllerTest {
    @Mock
    TppProductService tppProductService;
    @InjectMocks
    TppProductController tppProductController;


    @Test
    @DisplayName("testCreateTppProduct")
    void testCreateTppProduct() throws CheckProductException, CheckRegisterTypeExceptionEx, CheckAgreementException, CheckProductIdException, CheckRegisterTypeException, CheckProductClassException, CheckRegisterException {
    }

    @Test
    @DisplayName("testCreateTppProduct")
    void createTppProduct() {
    }
}
