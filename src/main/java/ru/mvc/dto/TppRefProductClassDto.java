package ru.mvc.dto;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "tpp_ref_product_class")
public class TppRefProductClassDto {
    @Id
    @Column(name = "internal_id", nullable = false)
    Long internalId;
    @Column(name = "gbi_code", nullable = false)
    String gbiCode;
    @Column(name = "gbi_name", nullable = false)
    String gbiName;
    @Column(name = "product_row_code", nullable = false)
    String productRowCode;
    @Column(name = "product_row_name", nullable = false)
    String productRowName;
    @Column(name = "subclass_code", nullable = false)
    String subclassCode;
    @Column(name = "subclass_name", nullable = false)
    String subclassName;
    @Column(name = "value", nullable = false)
    String value;

    public TppRefProductClassDto() {

    }

    public Long getInternalId() {
        return internalId;
    }

    public void setInternalId(Long internalId) {
        this.internalId = internalId;
    }

    public String getGbiCode() {
        return gbiCode;
    }

    public void setGbiCode(String gbiCode) {
        this.gbiCode = gbiCode;
    }

    public String getGbiName() {
        return gbiName;
    }

    public void setGbiName(String gbiName) {
        this.gbiName = gbiName;
    }

    public String getProductRowCode() {
        return productRowCode;
    }

    public void setProductRowCode(String productRowCode) {
        this.productRowCode = productRowCode;
    }

    public String getProductRowName() {
        return productRowName;
    }

    public void setProductRowName(String productRowName) {
        this.productRowName = productRowName;
    }

    public String getSubclassCode() {
        return subclassCode;
    }

    public void setSubclassCode(String subclassCode) {
        this.subclassCode = subclassCode;
    }

    public String getSubclassName() {
        return subclassName;
    }

    public void setSubclassName(String subclassName) {
        this.subclassName = subclassName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
