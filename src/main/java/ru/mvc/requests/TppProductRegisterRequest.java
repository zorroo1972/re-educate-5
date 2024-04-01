package ru.mvc.requests;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class TppProductRegisterRequest{
        @NotNull(message = "Не задано значение параметра %s .")
        private Long instanceId;
        @NotNull(message = "Не задано значение параметра %s .")
        private  String registryTypeCode;
        @NotNull(message = "Не задано значение параметра %s .")
        private  String accountType;
        @NotNull(message = "Не задано значение параметра %s .")
        private  String currencyCode;
        @NotNull(message = "Не задано значение параметра %s .")
        private  String branchCode;
        @NotNull(message = "Не задано значение параметра %s .")
        private  String priorityCode;
        @NotNull(message = "Не задано значение параметра %s .")
        private  String mdmCode;
        @NotNull(message = "Не задано значение параметра %s .")
        private  String clientCode;
        @NotNull(message = "Не задано значение параметра %s .")
        private  String trainRegion;
        @NotNull(message = "Не задано значение параметра %s .")
        private  String counter;
        @NotNull(message = "Не задано значение параметра %s .")
        private  String salesCode;

        private TppProductRegisterRequest() {
        }

        public TppProductRegisterRequest(Long instanceId) {
                this.instanceId = instanceId;
        }

        public Long getInstanceId() {
                return instanceId;
        }

        public void setInstanceId(Long instanceId) {
                this.instanceId = instanceId;
        }

        public String getRegistryTypeCode() {
                return registryTypeCode;
        }

        public void setRegistryTypeCode(String registryTypeCode) {
                this.registryTypeCode = registryTypeCode;
        }

        public String getAccountType() {
                return accountType;
        }

        public void setAccountType(String accountType) {
                this.accountType = accountType;
        }

        public String getCurrencyCode() {
                return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
                this.currencyCode = currencyCode;
        }

        public String getBranchCode() {
                return branchCode;
        }

        public void setBranchCode(String branchCode) {
                this.branchCode = branchCode;
        }

        public String getPriorityCode() {
                return priorityCode;
        }

        public void setPriorityCode(String priorityCode) {
                this.priorityCode = priorityCode;
        }

        public String getMdmCode() {
                return mdmCode;
        }

        public void setMdmCode(String mdmCode) {
                this.mdmCode = mdmCode;
        }

        public String getClientCode() {
                return clientCode;
        }

        public void setClientCode(String clientCode) {
                this.clientCode = clientCode;
        }

        public String getTrainRegion() {
                return trainRegion;
        }

        public void setTrainRegion(String trainRegion) {
                this.trainRegion = trainRegion;
        }

        public String getCounter() {
                return counter;
        }

        public void setCounter(String counter) {
                this.counter = counter;
        }

        public String getSalesCode() {
                return salesCode;
        }

        public void setSalesCode(String salesCode) {
                this.salesCode = salesCode;
        }
}
