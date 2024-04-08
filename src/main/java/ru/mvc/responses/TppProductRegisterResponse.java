package ru.mvc.responses;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class TppProductRegisterResponse {
    private Date dateResponse;
    private String accountId;

    public TppProductRegisterResponse(Date dateResponse, String accountId) {
        this.dateResponse = dateResponse;
        this.accountId = accountId;
    }

    public TppProductRegisterResponse() {

    }

    public void setDateResponse() {
        this.dateResponse = new Date();
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getDateResponse() {
        return dateResponse;
    }

    public String getAccountId() {
        return accountId;
    }
}
