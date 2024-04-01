package ru.mvc.dto;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "tpp_ref_product_register_type")
public class TppRefProductRegisterTypeDto {
    @Id
    @GeneratedValue
    Long internalId;
    @Column(name = "account_type", nullable = false)
    String accountType;
    @Column(name = "product_class_code", nullable = false)
    String productClassCode;
    @Column(name = "register_type_end_date", nullable = false)
    String registerTypeEndDate;
    @Column(name = "register_type_name", nullable = false)
    String registerTypeName;
    @Column(name = "register_type_start_date", nullable = false)
    String registerTypeStartDate;
    @Column(name = "value", nullable = false)
    String value;

    public TppRefProductRegisterTypeDto() {
    }

    public Long getInternalId() {
        return internalId;
    }

    public void setInternalId(Long internalId) {
        this.internalId = internalId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getProductClassCode() {
        return productClassCode;
    }

    public void setProductClassCode(String productClassCode) {
        this.productClassCode = productClassCode;
    }

    public String getRegisterTypeEndDate() {
        return registerTypeEndDate;
    }

    public void setRegisterTypeEndDate(String registerTypeEndDate) {
        this.registerTypeEndDate = registerTypeEndDate;
    }

    public String getRegisterTypeName() {
        return registerTypeName;
    }

    public void setRegisterTypeName(String registerTypeName) {
        this.registerTypeName = registerTypeName;
    }

    public String getRegisterTypeStartDate() {
        return registerTypeStartDate;
    }

    public void setRegisterTypeStartDate(String registerTypeStartDate) {
        this.registerTypeStartDate = registerTypeStartDate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
