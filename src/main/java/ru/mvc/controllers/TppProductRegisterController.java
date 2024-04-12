package ru.mvc.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mvc.exceptions.*;
import ru.mvc.services.TppProductRegisterService;
import ru.mvc.requests.TppProductRegisterRequest;

@Validated
@RestController
@RequestMapping(value = "corporate-settlement-account", produces = MediaType.APPLICATION_JSON_VALUE)
public class TppProductRegisterController {
    @Autowired  TppProductRegisterService tppProductRegisterService;
    public TppProductRegisterController(TppProductRegisterService tppProductRegisterService) {
        this.tppProductRegisterService = tppProductRegisterService;
    }
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createTppProductRegister(@Valid @RequestBody TppProductRegisterRequest request) throws CheckRegisterException, CheckRegisterTypeException {
        return tppProductRegisterService.process(request);
    }
}
