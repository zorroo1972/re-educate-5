package ru.mvc.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mvc.dto.AccountDto;
import ru.mvc.dto.AccountPoolDto;
import ru.mvc.exceptions.*;
import ru.mvc.repositories.AccountPoolRepo;
import ru.mvc.repositories.AccountsRepo;
import ru.mvc.requests.TppProductRegisterRequest;

@Component
public class AccountHandler {
    @Autowired  AccountsRepo accountsRepo;
    @Autowired  AccountPoolRepo accountPoolRepo;
    public AccountDto getAccount(TppProductRegisterRequest tppProductRegisterRequest) {
    AccountPoolDto accountPool = accountPoolRepo.findByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegistryTypeCode(
                tppProductRegisterRequest.getBranchCode(),
                tppProductRegisterRequest.getCurrencyCode(),
                tppProductRegisterRequest.getMdmCode(),
                tppProductRegisterRequest.getPriorityCode(),
                tppProductRegisterRequest.getRegistryTypeCode());
    if(accountPool == null) throw new CheckAccountException();
    var account = accountsRepo.findByBussyAndAccountPoolId(String.valueOf(accountPool.getId()));
        // TODO
    //account.setBussy(true);
    //accountsRepo.save(account);
    return account;
    }
}
