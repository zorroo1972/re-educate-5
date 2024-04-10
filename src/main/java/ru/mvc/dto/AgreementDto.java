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
    @Column(name = "general_agreementId", nullable = false)
    private String generalAgreementId;
    @Column(name = "supplementary_agreement_id", nullable = false)
    private String supplementaryAgreementId;
    @Column(name = "agreement_type", nullable = false)
    private String agreementType;
    @Column(name = "sheduler_job_id", nullable = false)
    private Long shedulerJobId;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "opening_date", nullable = false)
    private Date openingDate;
    @Column(name = "closing_date", nullable = false)
    private Date closingDate;
    @Column(name = "client_id", nullable = false)
    private Date cancelDate;
    @Column(name = "validity_duration", nullable = false)
    private Long validityDuration;
    @Column(name = "cancellation_reason", nullable = false)
    private String cancellationReason;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "interest_calculation_date", nullable = false)
    private Date interestCalculationDate;
    @Column(name = "interest_rate", nullable = false)
    private Double interestRate;
    @Column(name = "coefficient", nullable = false)
    private Double coefficient;
    @Column(name = "coefficient_action", nullable = false)
    private String coefficientAction;
    @Column(name = "minimum_interest_rate", nullable = false)
    private Double minimumInterestRate;
    @Column(name = "minimum_interest_rate_coefficient", nullable = false)
    private String minimumInterestRateCoefficient;
    @Column(name = "minimum_interest_rate_coefficient_action", nullable = false)
    private String minimumInterestRateCoefficientAction;
    @Column(name = "maximal_interest_rate", nullable = false)
    private Double maximalInterestRate;
    @Column(name = "maximal_interest_rate_coefficient", nullable = false)
    private Double maximalInterestRateCoefficient;
    @Column(name = "maximal_interest_rate_coefficient_action", nullable = false)

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


}
