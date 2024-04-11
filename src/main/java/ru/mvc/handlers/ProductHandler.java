package ru.mvc.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mvc.dto.AccountDto;
import ru.mvc.dto.AccountPoolDto;
import ru.mvc.dto.TppProductDto;
import ru.mvc.dto.TppProductRegisterDto;
import ru.mvc.exceptions.CheckAccountException;
import ru.mvc.exceptions.CheckRegisterException;
import ru.mvc.exceptions.CheckRegisterTypeException;
import ru.mvc.requests.TppProductRegisterRequest;
import ru.mvc.requests.TppProductRequest;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductHandler {
    @Autowired
    TppProductDto tppProductDto;

    public TppProductDto setProduct(TppProductRequest tppProductRequest, Long codeId) {
        tppProductDto = new TppProductDto();
        tppProductDto.setClientId(Long.valueOf(1));
        tppProductDto.setProductCodeId(codeId);
        tppProductDto.setClientId(Long.valueOf(tppProductRequest.getMdmCode()));
        tppProductDto.setNso(ProductType.valueOf(tppProductRequest.getProductType()));
        tppProductDto.setInterestRateType(String.valueOf(RateType.valueOf(tppProductRequest.getRateType())));
        tppProductDto.setNumber(tppProductRequest.getContractNumber());
        tppProductDto.setState(State.Открыт.getCode());
        tppProductDto.setPriority(tppProductRequest.getPriority());
        tppProductDto.setThresholdAmount(tppProductRequest.getThresholdAmount());
        tppProductDto.setType(tppProductRequest.getProductType());
        tppProductDto.setTaxRate(tppProductRequest.getTaxPercentageRate());
        return tppProductDto;
    }

    enum RateType {
        дифференцированная("0"), прогрессивная("1");
        private String code;

        RateType(String code) {
            this.code = code;

        }

        public String getCode() {
            return code;
        }
    }

    enum State {
        Закрыт("0"), Открыт("1"), Зарезервирован("2"), Удалён("3");
        private String code;
        State(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }
    class RegisterHandlerExt extends RegisterHandler implements ru.mvc.handlers.RegisterHandlerExt {
        @Autowired AccountHandlerExt accountHandlerExt;
        @Override
        public TppProductRegisterDto setRegister(TppProductRequest tppProductRequest,String typeReestr) throws CheckRegisterException, CheckRegisterTypeException {
            var registerType = tppRefProductRegisterTypeRepo.findByValue(tppProductRequest.getProductCode());
            if (registerType == null) throw new CheckRegisterTypeException(tppProductRequest,tppRefProductRegisterTypeDto);
            var account = accountHandlerExt.getAccount(tppProductRequest);
            if (account == null) throw new CheckAccountException();
            tppProductRegisterDto = new TppProductRegisterDto();
            tppProductRegisterDto.setAccount(String.valueOf(account.getId()));
            tppProductRegisterDto.setAccountNumber(account.getAccountNumber());
            tppProductRegisterDto.setCurrencyCode(tppProductRequest.getIsoCurrencyCode());
            tppProductRegisterDto.setProductId(tppProductRequest.getInstanceId());
            tppProductRegisterDto.setState(State.Открыт.getCode().toString());
            tppProductRegisterDto.setType(typeReestr);
            return tppProductRegisterDto;
        }
    }
    class AccountHandlerExt extends AccountHandler implements ru.mvc.handlers.AccountHandlerExt {
        @Override
        public AccountDto getAccount(TppProductRequest tppProductRequest) {
            AccountPoolDto accountPool = accountPoolRepo.findByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegistryTypeCode(
                    tppProductRequest.getBranchCode(),
                    tppProductRequest.getIsoCurrencyCode(),
                    tppProductRequest.getMdmCode(),
                    String.valueOf(tppProductRequest.getPriority()),
                    tppProductRequest.getRegisterType());
            if(accountPool == null) throw new CheckAccountException();
            var account = accountsRepo.findByBussyAndAccountPoolId(String.valueOf(accountPool.getId()));
            // TODO
            //account.setBussy(true);
            //accountsRepo.save(account);
            return account;
        }
    }
}


