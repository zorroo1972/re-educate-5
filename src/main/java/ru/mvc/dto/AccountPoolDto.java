package ru.mvc.dto;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "account_pool")
public class AccountPoolDto {

    @Id
    @GeneratedValue
    Long id;
    @Column(name = "branch_code", nullable = false)
    String branchCode;
    @Column(name = "currency_code", nullable = false)
    String currencyCode;
    @Column(name = "mdm_code", nullable = false)
    String mdmCode;
    @Column(name = "priority_code", nullable = false)
    String priorityCode;
    @Column(name = "registry_type_code", nullable = false)
    String registryTypeCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCoder(String currencyCoder) {
        this.currencyCode = currencyCode;
    }


    public String getMdmCode() {
        return mdmCode;
    }

    public void setMdmCode(String mdmCode) {
        this.mdmCode = mdmCode;
    }

    public String getPriorityCode() {
        return priorityCode;
    }

    public void setPriorityCode(String priorityCode) {
        this.priorityCode = priorityCode;
    }

    public String getRegistryTypeCode() {
        return registryTypeCode;
    }

    public void setRegistryTypeCode(String registryTypeCode) {
        this.registryTypeCode = registryTypeCode;
    }
}
