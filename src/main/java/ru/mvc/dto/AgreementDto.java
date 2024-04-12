package ru.mvc.dto;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Entity
@Table(name = "agreement", schema = "public")
public class AgreementDto {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "general_agreementId")
    private String generalAgreementId;
    @Column(name = "supplementary_agreement_id")
    private String supplementaryAgreementId;
    @Column(name = "agreement_type", nullable = false)
    private String agreementType;
    @Column(name = "sheduler_job_id")
    private Long shedulerJobId;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "opening_date", nullable = false)
    private Date openingDate;
    @Column(name = "closing_date")
    private Date closingDate;
    @Column(name = "cancel_date")
    private Date cancelDate;
    @Column(name = "validity_duration")
    private Long validityDuration;
    @Column(name = "cancellation_reason")
    private String cancellationReason;
    @Column(name = "status")
    private String status;
    @Column(name = "interest_calculation_date")
    private Date interestCalculationDate;
    @Column(name = "interest_rate")
    private Double interestRate;
    @Column(name = "coefficient")
    private Double coefficient;
    @Column(name = "coefficient_action")
    private String coefficientAction;
    @Column(name = "minimum_interest_rate")
    private Double minimumInterestRate;
    @Column(name = "minimum_interest_rate_coefficient")
    private String minimumInterestRateCoefficient;
    @Column(name = "minimum_interest_rate_coefficient_action")
    private String minimumInterestRateCoefficientAction;
    @Column(name = "maximal_interest_rate")
    private Double maximalInterestRate;
    @Column(name = "maximal_interest_rate_coefficient")
    private Double maximalInterestRateCoefficient;
    @Column(name = "maximal_interest_rate_coefficient_action")
    private String maximalInterestRateCoefficientAction;

    public AgreementDto(Long id, String generalAgreementId, String supplementaryAgreementId, String agreementType, Long shedulerJobId, String number, Date openingDate, Date closingDate, Date cancelDate, Long validityDuration, String cancellationReason, String status, Date interestCalculationDate, Double interestRate, Double coefficient, String coefficientAction, Double minimumInterestRate, String minimumInterestRateCoefficient, String minimumInterestRateCoefficientAction, Double maximalInterestRate, Double maximalInterestRateCoefficient, String maximalInterestRateCoefficientAction) {
        this.id = id;
        this.generalAgreementId = generalAgreementId;
        this.supplementaryAgreementId = supplementaryAgreementId;
        this.agreementType = agreementType;
        this.shedulerJobId = shedulerJobId;
        this.number = number;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.cancelDate = cancelDate;
        this.validityDuration = validityDuration;
        this.cancellationReason = cancellationReason;
        this.status = status;
        this.interestCalculationDate = interestCalculationDate;
        this.interestRate = interestRate;
        this.coefficient = coefficient;
        this.coefficientAction = coefficientAction;
        this.minimumInterestRate = minimumInterestRate;
        this.minimumInterestRateCoefficient = minimumInterestRateCoefficient;
        this.minimumInterestRateCoefficientAction = minimumInterestRateCoefficientAction;
        this.maximalInterestRate = maximalInterestRate;
        this.maximalInterestRateCoefficient = maximalInterestRateCoefficient;
        this.maximalInterestRateCoefficientAction = maximalInterestRateCoefficientAction;
    }

    public AgreementDto() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGeneralAgreementId(String generalAgreementId) {
        this.generalAgreementId = generalAgreementId;
    }

    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

    public void setShedulerJobId(Long shedulerJobId) {
        this.shedulerJobId = shedulerJobId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public void setValidityDuration(Long validityDuration) {
        this.validityDuration = validityDuration;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInterestCalculationDate(Date interestCalculationDate) {
        this.interestCalculationDate = interestCalculationDate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public void setCoefficientAction(String coefficientAction) {
        this.coefficientAction = coefficientAction;
    }

    public void setMinimumInterestRate(Double minimumInterestRate) {
        this.minimumInterestRate = minimumInterestRate;
    }

    public void setMinimumInterestRateCoefficient(String minimumInterestRateCoefficient) {
        this.minimumInterestRateCoefficient = minimumInterestRateCoefficient;
    }

    public void setMinimumInterestRateCoefficientAction(String minimumInterestRateCoefficientAction) {
        this.minimumInterestRateCoefficientAction = minimumInterestRateCoefficientAction;
    }

    public void setMaximalInterestRate(Double maximalInterestRate) {
        this.maximalInterestRate = maximalInterestRate;
    }

    public void setMaximalInterestRateCoefficient(Double maximalInterestRateCoefficient) {
        this.maximalInterestRateCoefficient = maximalInterestRateCoefficient;
    }

    public void setMaximalInterestRateCoefficientAction(String maximalInterestRateCoefficientAction) {
        this.maximalInterestRateCoefficientAction = maximalInterestRateCoefficientAction;
    }

    public Long getId() {
        return id;
    }
}
