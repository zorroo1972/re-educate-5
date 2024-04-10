package ru.mvc.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import ru.mvc.dto.AdditionalPropertiesVipDto;
import ru.mvc.dto.AgreementDto;
import ru.mvc.dto.AgreementList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
@Validated
public class TppProductRequest {
        private Long instanceId;
        @NotBlank private String productType;
        @NotBlank private String productCode;
        @NotBlank private String registerType;
        @NotBlank private String mdmCode;
        @NotBlank private String contractNumber;
        @NotNull private Date contractDate;
        @NotNull private Long priority;
         private Double interestRatePenalty;
         private Double minimalBalance;
         private Double thresholdAmount;
         private String accountingDetails;
         private String rateType;
         private Double taxPercentageRate;
         private Double technicalOverdraftLimitAmount;
        @NotNull private Long contractId;
        @NotBlank private String BranchCode;
        @NotBlank private String IsoCurrencyCode;
        @NotBlank private String urgencyCode;
         private Long ReferenceCode;
        public List<AdditionalPropertiesVipDto> additionalPropertiesVip = new ArrayList<>();
        public List<AgreementList> instanceArrangement = new ArrayList<>();


        public Long getInstanceId() {
                return instanceId;
        }

        public void setInstanceId(Long instanceId) {
                this.instanceId = instanceId;
        }

        public String getProductType() {
                return productType;
        }

        public void setProductType(String productType) {
                this.productType = productType;
        }

        public String getProductCode() {
                return productCode;
        }

        public void setProductCode(String productCode) {
                this.productCode = productCode;
        }

        public String getRegisterType() {
                return registerType;
        }

        public void setRegisterType(String registerType) {
                this.registerType = registerType;
        }

        public String getMdmCode() {
                return mdmCode;
        }

        public void setMdmCode(String mdmCode) {
                this.mdmCode = mdmCode;
        }

        public String getContractNumber() {
                return contractNumber;
        }

        public void setContractNumber(String contractNumber) {
                this.contractNumber = contractNumber;
        }

        public Date getContractDate() {
                return contractDate;
        }

        public void setContractDate(Date contractDate) {
                this.contractDate = contractDate;
        }

        public Long getPriority() {
                return priority;
        }

        public void setPriority(Long priority) {
                this.priority = priority;
        }

        public Double getInterestRatePenalty() {
                return interestRatePenalty;
        }

        public void setInterestRatePenalty(Double interestRatePenalty) {
                this.interestRatePenalty = interestRatePenalty;
        }

        public Double getMinimalBalance() {
                return minimalBalance;
        }

        public void setMinimalBalance(Double minimalBalance) {
                this.minimalBalance = minimalBalance;
        }

        public Double getThresholdAmount() {
                return thresholdAmount;
        }

        public void setThresholdAmount(Double thresholdAmount) {
                this.thresholdAmount = thresholdAmount;
        }

        public String getAccountingDetails() {
                return accountingDetails;
        }

        public void setAccountingDetails(String accountingDetails) {
                this.accountingDetails = accountingDetails;
        }

        public String getRateType() {
                return rateType;
        }

        public void setRateType(String rateType) {
                this.rateType = rateType;
        }

        public Double getTaxPercentageRate() {
                return taxPercentageRate;
        }

        public void setTaxPercentageRate(Double taxPercentageRate) {
                this.taxPercentageRate = taxPercentageRate;
        }

        public Double getTechnicalOverdraftLimitAmount() {
                return technicalOverdraftLimitAmount;
        }

        public void setTechnicalOverdraftLimitAmount(Double technicalOverdraftLimitAmount) {
                this.technicalOverdraftLimitAmount = technicalOverdraftLimitAmount;
        }

        public Long getContractId() {
                return contractId;
        }

        public void setContractId(Long contractId) {
                this.contractId = contractId;
        }

        public String getBranchCode() {
                return BranchCode;
        }

        public void setBranchCode(String branchCode) {
                BranchCode = branchCode;
        }

        public String getIsoCurrencyCode() {
                return IsoCurrencyCode;
        }

        public void setIsoCurrencyCode(String isoCurrencyCode) {
                IsoCurrencyCode = isoCurrencyCode;
        }

        public String getUrgencyCode() {
                return urgencyCode;
        }

        public void setUrgencyCode(String urgencyCode) {
                this.urgencyCode = urgencyCode;
        }

        public Long getReferenceCode() {
                return ReferenceCode;
        }

        public void setReferenceCode(Long referenceCode) {
                ReferenceCode = referenceCode;
        }

        public List<AdditionalPropertiesVipDto> getAdditionalPropertiesVip() {
                return additionalPropertiesVip;
        }

        public void setAdditionalPropertiesVipDtoList(List<AdditionalPropertiesVipDto> additionalPropertiesVip) {
                this.additionalPropertiesVip= additionalPropertiesVip;
        }

        public List<AgreementList> getInstanceArrangement() {
                return instanceArrangement;
        }

        public void setInstanceArrangement(List<AgreementList> instanceArrangement) {
                this.instanceArrangement = instanceArrangement;
        }

        public TppProductRequest( List<AdditionalPropertiesVipDto> additionalPropertiesVip, List<AgreementList> instanceArrangement) {
                this.additionalPropertiesVip = additionalPropertiesVip;
                this.instanceArrangement = instanceArrangement;
        }

        @Override
        public String toString() {
                return "TppProductRequest{" +
                        "instanceId=" + instanceId +
                        ", productType='" + productType + '\'' +
                        ", productCode='" + productCode + '\'' +
                        ", registerType='" + registerType + '\'' +
                        ", mdmCode='" + mdmCode + '\'' +
                        ", contractNumber='" + contractNumber + '\'' +
                        ", contractDate=" + contractDate +
                        ", priority=" + priority +
                        ", interestRatePenalty=" + interestRatePenalty +
                        ", minimalBalance=" + minimalBalance +
                        ", thresholdAmount=" + thresholdAmount +
                        ", accountingDetails='" + accountingDetails + '\'' +
                        ", rateType='" + rateType + '\'' +
                        ", taxPercentageRate=" + taxPercentageRate +
                        ", technicalOverdraftLimitAmount=" + technicalOverdraftLimitAmount +
                        ", contractId=" + contractId +
                        ", BranchCode='" + BranchCode + '\'' +
                        ", IsoCurrencyCode='" + IsoCurrencyCode + '\'' +
                        ", urgencyCode='" + urgencyCode + '\'' +
                        ", ReferenceCode=" + ReferenceCode +
                        ", additionalPropertiesVipDtoList=" + additionalPropertiesVip +
                        ", arrangementDtoList=" + instanceArrangement +
                        '}';
        }
}




