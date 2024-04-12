package ru.mvc.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import ru.mvc.dto.*;
import ru.mvc.exceptions.*;
import ru.mvc.handlers.AgreementHandler;
import ru.mvc.handlers.ProductHandler;
import ru.mvc.handlers.RegisterHandlerExt;
import ru.mvc.repositories.*;
import ru.mvc.requests.TppProductRequest;
import java.util.List;

class TppProductServiceTest {
    @InjectMocks
    TppProductService tppProductService;


    @Test
    @DisplayName("testGetTppProductResponse")
    void testGetTppProductResponse() {
        ResponseEntity<?> result = TppProductService.getTppProductResponse(Long.valueOf(1), List.of(Long.valueOf(1)), Long.valueOf(1));
    }
}

