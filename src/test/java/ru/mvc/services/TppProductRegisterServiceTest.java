package ru.mvc.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import ru.mvc.dto.TppProductRegisterDto;
import ru.mvc.exceptions.CheckRegisterException;
import ru.mvc.exceptions.CheckRegisterTypeException;
import ru.mvc.handlers.RegisterHandlerExt;
import ru.mvc.repositories.TppProductRegisterRepo;
import ru.mvc.requests.TppProductRegisterRequest;

import static org.mockito.Mockito.*;

class TppProductRegisterServiceTest {
    @Mock
    TppProductRegisterRepo registerRepo;
    @Mock
    RegisterHandlerExt registerHandlerExt;
    @InjectMocks
    TppProductRegisterService tppProductRegisterService;

    @Test
    @DisplayName("testGetTppProductRegisterResponse")
    void testGetTppProductRegisterResponse() {
        ResponseEntity<?> result = TppProductRegisterService.getTppProductRegisterResponse(Long.valueOf(1));
    }

    @Test
    @DisplayName("testProcess")
    void testProcess() throws CheckRegisterTypeException, CheckRegisterException {
        when(registerRepo.findByProductIdAndType(anyLong(), anyString())).thenReturn(new TppProductRegisterDto(null));
        when(registerHandlerExt.setRegister(any())).thenReturn(new TppProductRegisterDto(null));
        ResponseEntity<?> result = tppProductRegisterService.process(new TppProductRegisterRequest(Long.valueOf(1), "registryTypeCode", null, null, null, null, null, null, null, null, null));
    }
}
