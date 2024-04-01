package ru.mvc.dto;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "account")
public class AccountDto {

    @Id
    @GeneratedValue
    Long id;
    @Column(name = "account_number", nullable = false)
    String accountNumber;
    @Column(name = "account_pool_id", nullable = false)
    String accountPoolId;
    @Column(name = "bussy", nullable = false)
    Boolean bussy;

    public AccountDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountPoolId() {
        return accountPoolId;
    }

    public void setAccountPoolId(String accountPoolId) {
        this.accountPoolId = accountPoolId;
    }

    public boolean getBussy() {
        return bussy;
    }

    public void setBussy(boolean bussy) {
        this.bussy = bussy;
    }
}
