package ru.mvc.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.mvc.dto.AccountPoolDto;

public interface AccountPoolRepo extends CrudRepository<AccountPoolDto,Long> {
    AccountPoolDto findByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegistryTypeCode(String branchCode, String currencyCode, String mdmCode, String priorityCode, String registryTypeCode);

}
