package ru.mvc.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mvc.requests.TppProductRequest;
import ru.mvc.services.TppProductService;
import ru.mvc.exceptions.*;

@Validated
@RestController
@RequestMapping(value = "corporate-settlement-instance", produces = MediaType.APPLICATION_JSON_VALUE)
public class TppProductController {
    @Autowired  TppProductService tppProductService;
    public TppProductController(TppProductService tppRegisterService) {
        this.tppProductService = tppProductService;
    }
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createTppProduct(@Valid @RequestBody TppProductRequest request) throws CheckProductException, CheckAgreementException, CheckProductClassException {
        return tppProductService.process(request);
    }
}
