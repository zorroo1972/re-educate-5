package ru.mvc.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mvc.dto.AccountDto;
import ru.mvc.exceptions.ErrorMessage;
import ru.mvc.repositories.AccountPoolRepo;
import ru.mvc.repositories.AccountsRepo;
import ru.mvc.requests.TppProductRegisterRequest;
@Component
public class AccountHandler {
    @Autowired  AccountsRepo accountsRepo;
    @Autowired  AccountPoolRepo accountPoolRepo;
    public AccountDto getAccount(TppProductRegisterRequest tppProductRegisterRequest) throws ErrorMessage {
    var accountPool = accountPoolRepo.findByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegistryTypeCode(
                tppProductRegisterRequest.getBranchCode(),
                tppProductRegisterRequest.getCurrencyCode(),
                tppProductRegisterRequest.getMdmCode(),
                tppProductRegisterRequest.getPriorityCode(),
                tppProductRegisterRequest.getRegistryTypeCode());
    if(accountPool == null) throw new ErrorMessage();
    var account = accountsRepo.findFirstByAccountPoolIdAndBussy(String.valueOf(accountPool.getId()), false);
    account.setBussy(true);
        accountsRepo.save(account);
    return account;
    }
}
