package ru.mvc.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.mvc.dto.AccountPoolDto;

public interface AccountPoolRepo extends CrudRepository<AccountPoolDto,Long> {
    /*
    @Query("select ap\n" +
            " from account_pool ap\n" +
            " where \n" +
            "    ap.branch_code = ?1 and\n" +
            "    ap.currency_code = ?2 and\n" +
            "    ap.mdm_code = ?3 and\n" +
            "    ap.priority_code = ?4 and\n" +
            "    ap.registry_type_code = ?5")

     */
    AccountPoolDto findByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegistryTypeCode(String branchCode, String currencyCode, String mdmCode, String priorityCode, String registryTypeCode);

}
