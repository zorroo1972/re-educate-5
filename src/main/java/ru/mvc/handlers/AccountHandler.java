package ru.mvc.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mvc.dto.AccountDto;
import ru.mvc.dto.AccountPoolDto;
import ru.mvc.exceptions.ErrorMessage;
import ru.mvc.exceptions.ResourceNotFoundException;
import ru.mvc.repositories.AccountPoolRepo;
import ru.mvc.repositories.AccountsRepo;
import ru.mvc.requests.TppProductRegisterRequest;

import java.util.List;

@Component
public class AccountHandler {
    @Autowired  AccountsRepo accountsRepo;
    @Autowired  AccountPoolRepo accountPoolRepo;
    public AccountDto getAccount(TppProductRegisterRequest tppProductRegisterRequest) throws ErrorMessage {
    AccountPoolDto accountPool = accountPoolRepo.findByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegistryTypeCode(
                tppProductRegisterRequest.getBranchCode(),
                tppProductRegisterRequest.getCurrencyCode(),
                tppProductRegisterRequest.getMdmCode(),
                tppProductRegisterRequest.getPriorityCode(),
                tppProductRegisterRequest.getRegistryTypeCode());
    if(accountPool == null) throw new ResourceNotFoundException("nnnnnn");
    var account = accountsRepo.findByBussyAndAccountPoolId(String.valueOf(accountPool.getId()));
    //account.setBussy(true);
    //accountsRepo.save(account);
    return account;
    }
}
