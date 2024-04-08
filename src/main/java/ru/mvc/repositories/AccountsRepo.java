package ru.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mvc.dto.AccountDto;

import java.util.List;

public interface AccountsRepo extends JpaRepository<AccountDto,Long> {
    @Query(value = "SELECT * FROM ACCOUNT a WHERE coalesce(bussy,false) = false  and account_pool_id = ?1 limit 1", nativeQuery = true)

    AccountDto findByBussyAndAccountPoolId(String accountPoolId);
}
