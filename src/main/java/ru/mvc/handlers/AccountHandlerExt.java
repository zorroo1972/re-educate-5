package ru.mvc.handlers;

import org.springframework.stereotype.Component;
import ru.mvc.dto.AccountDto;
import ru.mvc.dto.AccountPoolDto;
import ru.mvc.exceptions.CheckAccountException;
import ru.mvc.requests.TppProductRequest;

@Component
public class AccountHandlerExt extends AccountHandler implements AccountHandlerInt {
    @Override
    public AccountDto getAccount(TppProductRequest tppProductRequest, String registerType) {
        AccountPoolDto accountPool = accountPoolRepo.findByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegistryTypeCode(
                tppProductRequest.getBranchCode(),
                tppProductRequest.getIsoCurrencyCode(),
                tppProductRequest.getMdmCode(),
                tppProductRequest.getPriority(),
                registerType);
        if(accountPool == null) throw new CheckAccountException();
        var account = accountsRepo.findByBussyAndAccountPoolId(String.valueOf(accountPool.getId()));
        account.setBussy(true);
        accountsRepo.save(account);
        return account;
    }
}



