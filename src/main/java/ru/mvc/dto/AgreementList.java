package ru.mvc.dto;

import org.springframework.stereotype.Component;
import java.util.Date;
@Component
public class AgreementList {
    private String generalAgreementId;
    private String supplementaryAgreementId;

    private String agreementType;
    private Long shedulerJobId;
    private String number;

    private Date openingDate;

    private Date closingDate;

    private Date cancelDate;
    private Long validityDuration;

    private String cancellationReason;

    private String status;

    private Date interestCalculationDate;

    private Double interestRate;

    private Double coefficient;

    private String coefficientAction;

    private Double minimumInterestRate;

    private String minimumInterestRateCoefficient;

    private String minimumInterestRateCoefficientAction;

    private Double maximalInterestRate;

    private Double maximalInterestRateCoefficient;

    private String maximalInterestRateCoefficientAction;

    public AgreementList() {

    }
    public String getGeneralAgreementId() {
        return generalAgreementId;
    }

    public void setGeneralAgreementId(String generalAgreementId) {
        this.generalAgreementId = generalAgreementId;
    }
    public String getSupplementaryAgreementId() {
        return supplementaryAgreementId;
    }

    public void setSupplementaryAgreementId(String supplementaryAgreementId) {
        this.supplementaryAgreementId = supplementaryAgreementId;
    }

    public String getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

    public Long getShedulerJobId() {
        return shedulerJobId;
    }

    public void setShedulerJobId(Long shedulerJobId) {
        this.shedulerJobId = shedulerJobId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Long getValidityDuration() {
        return validityDuration;
    }

    public void setValidityDuration(Long validityDuration) {
        this.validityDuration = validityDuration;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getInterestCalculationDate() {
        return interestCalculationDate;
    }

    public void setInterestCalculationDate(Date interestCalculationDate) {
        this.interestCalculationDate = interestCalculationDate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public String getCoefficientAction() {
        return coefficientAction;
    }

    public void setCoefficientAction(String coefficientAction) {
        this.coefficientAction = coefficientAction;
    }

    public Double getMinimumInterestRate() {
        return minimumInterestRate;
    }

    public void setMinimumInterestRate(Double minimumInterestRate) {
        this.minimumInterestRate = minimumInterestRate;
    }

    public String getMinimumInterestRateCoefficient() {
        return minimumInterestRateCoefficient;
    }

    public void setMinimumInterestRateCoefficient(String minimumInterestRateCoefficient) {
        this.minimumInterestRateCoefficient = minimumInterestRateCoefficient;
    }

    public String getMinimumInterestRateCoefficientAction() {
        return minimumInterestRateCoefficientAction;
    }

    public void setMinimumInterestRateCoefficientAction(String minimumInterestRateCoefficientAction) {
        this.minimumInterestRateCoefficientAction = minimumInterestRateCoefficientAction;
    }

    public Double getMaximalInterestRate() {
        return maximalInterestRate;
    }

    public void setMaximalInterestRate(Double maximalInterestRate) {
        this.maximalInterestRate = maximalInterestRate;
    }

    public Double getMaximalInterestRateCoefficient() {
        return maximalInterestRateCoefficient;
    }

    public void setMaximalInterestRateCoefficient(Double maximalInterestRateCoefficient) {
        this.maximalInterestRateCoefficient = maximalInterestRateCoefficient;
    }

    public String getMaximalInterestRateCoefficientAction() {
        return maximalInterestRateCoefficientAction;
    }

    public void setMaximalInterestRateCoefficientAction(String maximalInterestRateCoefficientAction) {
        this.maximalInterestRateCoefficientAction = maximalInterestRateCoefficientAction;
    }

    @Override
    public String toString() {
        return "AgreementDto{" +
                ", generalAgreementId='" + generalAgreementId + '\'' +
                ", supplementaryAgreementId='" + supplementaryAgreementId + '\'' +
                ", agreementType='" + agreementType + '\'' +
                ", shedulerJobId=" + shedulerJobId +
                ", number='" + number + '\'' +
                ", openingDate=" + openingDate +
                ", closingDate=" + closingDate +
                ", cancelDate=" + cancelDate +
                ", validityDuration=" + validityDuration +
                ", cancellationReason='" + cancellationReason + '\'' +
                ", status='" + status + '\'' +
                ", interestCalculationDate=" + interestCalculationDate +
                ", interestRate=" + interestRate +
                ", coefficient=" + coefficient +
                ", coefficientAction='" + coefficientAction + '\'' +
                ", minimumInterestRate=" + minimumInterestRate +
                ", minimumInterestRateCoefficient='" + minimumInterestRateCoefficient + '\'' +
                ", minimumInterestRateCoefficientAction='" + minimumInterestRateCoefficientAction + '\'' +
                ", maximalInterestRate=" + maximalInterestRate +
                ", maximalInterestRateCoefficient=" + maximalInterestRateCoefficient +
                ", maximalInterestRateCoefficientAction='" + maximalInterestRateCoefficientAction + '\'' +
                '}';
    }
}
