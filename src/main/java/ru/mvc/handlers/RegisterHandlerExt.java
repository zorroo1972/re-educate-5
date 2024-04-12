package ru.mvc.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mvc.dto.TppProductRegisterDto;
import ru.mvc.exceptions.CheckAccountException;
import ru.mvc.exceptions.CheckRegisterTypeExceptionEx;
import ru.mvc.repositories.TppRefProductRegisterTypeRepo;
import ru.mvc.requests.TppProductRequest;
@Component
    public class RegisterHandlerExt extends RegisterHandler implements RegisterHandlerIExt {
    @Autowired TppProductRegisterDto tppProductRegisterDto;
    @Autowired TppRefProductRegisterTypeRepo tppRefProductRegisterTypeRepo;
    @Autowired AccountHandlerExt accountHandlerExt;

        @Override
        public TppProductRegisterDto setRegister(TppProductRequest tppProductRequest, Long productCodeId, String productValue) throws  CheckRegisterTypeExceptionEx {
            var registerType = tppRefProductRegisterTypeRepo.findByProductClassCode(tppProductRequest.getProductCode());
            if (registerType == null) throw new CheckRegisterTypeExceptionEx(tppProductRequest,tppRefProductRegisterTypeDto);
            var account = accountHandlerExt.getAccount(tppProductRequest,productValue);
            if (account == null) throw new CheckAccountException();
            tppProductRegisterDto = new TppProductRegisterDto();
            tppProductRegisterDto.setAccount(String.valueOf(account.getId()));
            tppProductRegisterDto.setAccountNumber(account.getAccountNumber());
            tppProductRegisterDto.setCurrencyCode(tppProductRequest.getIsoCurrencyCode());
            tppProductRegisterDto.setProductId(tppProductRequest.getInstanceId());
            tppProductRegisterDto.setState(State.Открыт.getCode());
            tppProductRegisterDto.setType(tppProductRequest.getRegisterType());
            return tppProductRegisterDto;
        }
    }