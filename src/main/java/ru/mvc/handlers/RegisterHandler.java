package ru.mvc.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mvc.dto.*;
import ru.mvc.repositories.*;
import ru.mvc.exceptions.ErrorMessage;
import ru.mvc.requests.TppProductRegisterRequest;
@Component
public class RegisterHandler {
    @Autowired  TppRefProductRegisterTypeRepo tppRefProductRegisterTypeRepo;
    @Autowired  AccountHandler accountHandler;
    @Autowired  TppProductRegisterDto tppProductRegisterDto;
    public TppProductRegisterDto setRegister(TppProductRegisterRequest tppProductRegisterRequest) throws ErrorMessage {
        var account = accountHandler.getAccount(tppProductRegisterRequest);
        tppProductRegisterDto = new TppProductRegisterDto();
        tppProductRegisterDto.setAccount(String.valueOf(account.getId()));
        tppProductRegisterDto.setAccountNumber(account.getAccountNumber());
        tppProductRegisterDto.setCurrencyCode(tppProductRegisterRequest.getCurrencyCode());
        tppProductRegisterDto.setProductId(tppProductRegisterRequest.getInstanceId());
        tppProductRegisterDto.getState(State.Открыт.getCode());
        tppProductRegisterDto.setType(tppRefProductRegisterTypeRepo.findByValue(tppProductRegisterRequest.getRegistryTypeCode()).getValue());
    return tppProductRegisterDto;
    }
    enum State {Закрыт("0"), Открыт("1"), Зарезервирован("2"), Удалён("3");

        private String code;
        State(String code){
            this.code = code;
        }
        public String getCode(){ return code;}
    }

}

