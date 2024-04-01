package ru.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.mvc.dto.AccountDto;

public interface AccountsRepo extends CrudRepository<AccountDto,Long> {
   // @Query("select a from account a where a.account_pool_id =?1 and a.bussy = false ")
    AccountDto findFirstByAccountPoolIdAndBussy(String accountPoolId, Boolean bussy);


}
