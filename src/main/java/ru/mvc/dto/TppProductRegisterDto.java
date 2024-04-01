package ru.mvc.dto;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "tpp_product_register")
public class TppProductRegisterDto {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "account", nullable = false)
    private String account;
    @Column(name = "account_number", nullable = false)
    private String accountNumber;
    @Column(name = "currency_code", nullable = false)
    private String currencyCode;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "state", nullable = false)
    private  String state;
    @Column(name = "type", nullable = false)
    private String type;


    public TppProductRegisterDto(TppProductRegisterBld tppProductRegisterBld) {
    }
    @Component
    public static class TppProductRegisterBld {
        private Long account;
        private String accountNumber;
        private String currencyCode;
        private Long productId;
        private String state;
        private String type;

        private TppProductRegisterBld account(Long val) {
            account = val;
            return this;
        }

        private TppProductRegisterBld accountNumber(String val) {
            accountNumber = val;
            return this;
        }

        private TppProductRegisterBld currencyCode(String val) {
            currencyCode = val;
            return this;
        }

        private TppProductRegisterBld productId(Long val) {
            productId = val;
            return this;
        }

        private TppProductRegisterBld state(String val) {
            state = val;
            return this;
        }

        private TppProductRegisterBld type(String val) {
            type = val;
            return this;
        }

        public TppProductRegisterDto build() {
            return new TppProductRegisterDto(this);
        }

        private void TppProductRegister(TppProductRegisterBld builder) {
            account = builder.account;
            accountNumber = builder.accountNumber;
            currencyCode = builder.currencyCode;
            productId = builder.productId;
            state = builder.state;
            type = builder.type;
        }

        public Long getAccount() {
            return account;
        }

        public void setAccount(Long account) {
            this.account = account;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public TppProductRegisterDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getState(String code) {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
