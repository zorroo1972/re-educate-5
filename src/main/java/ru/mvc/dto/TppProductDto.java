package ru.mvc.dto;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Table(name = "tpp_product", schema = "public")
public class TppProductDto {
    @Id
    @GeneratedValue
    Long id;
    @Column(name = "client_id", nullable = false)
    private Long clientId;
    @Column(name = "date_of_conclusion", nullable = false)
    private Date dateOfConclusion;
    @Column(name = "days", nullable = false)
    private Long days;
    @Column(name = "end_date_time", nullable = false)
    private Date endDateTime;
    @Column(name = "interest_rate_type", nullable = false)
    private String interestRateType;
    @Column(name = "nso", nullable = false)
    private Double nso;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "penalty_rate", nullable = false)
    private Double penaltyRate;
    @Column(name = "priority", nullable = false)
    private Long priority;
    @Column(name = "product_code_id", nullable = false)
    private Long productCodeId;
    @Column(name = "reasone_close", nullable = false)
    private String reasoneClose;
    @Column(name = "requisite_type", nullable = false)
    private String requisiteType;
    @Column(name = "start_date_time", nullable = false)
    private Date startDateTime;
    @Column(name = "state", nullable = false)
    private String state;
    @Column(name = "tax_rate", nullable = false)
    private Double taxRate;
    @Column(name = "threshold_amount", nullable = false)
    private Double thresholdAmount;
    @Column(name = "type", nullable = false)
    private String type;
    public TppProductDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getDateOfConclusion() {
        return dateOfConclusion;
    }

    public void setDateOfConclusion(Date dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getInterestRateType() {
        return interestRateType;
    }

    public void setInterestRateType(String interestRateType) {
        this.interestRateType = interestRateType;
    }

    public Double getNso() {
        return nso;
    }

    public void setNso(Double nso) {
        this.nso = nso;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getPenaltyRate() {
        return penaltyRate;
    }

    public void setPenaltyRate(Double penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Long getProductCodeId() {
        return productCodeId;
    }

    public void setProductCodeId(Long productCodeId) {
        this.productCodeId = productCodeId;
    }

    public String getReasoneClose() {
        return reasoneClose;
    }

    public void setReasoneClose(String reasoneClose) {
        this.reasoneClose = reasoneClose;
    }

    public String getRequisiteType() {
        return requisiteType;
    }

    public void setRequisiteType(String requisiteType) {
        this.requisiteType = requisiteType;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getThresholdAmount() {
        return thresholdAmount;
    }

    public void setThresholdAmount(Double thresholdAmount) {
        this.thresholdAmount = thresholdAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
