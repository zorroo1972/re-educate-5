package ru.mvc.dto;

import org.springframework.stereotype.Component;
@Component
public class AdditionalPropertiesVipDto {
    private String key;
    private String value;
    private String name;

    public AdditionalPropertiesVipDto() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AdditionalPropertiesVipDto{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
