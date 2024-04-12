package ru.mvc.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mvc.dto.AccountDto;
import ru.mvc.dto.AccountPoolDto;
import ru.mvc.dto.TppProductDto;
import ru.mvc.dto.TppProductRegisterDto;
import ru.mvc.exceptions.CheckAccountException;
import ru.mvc.exceptions.CheckRegisterException;
import ru.mvc.exceptions.CheckRegisterTypeException;
import ru.mvc.requests.TppProductRequest;

@Component
public class ProductHandler {
    @Autowired
    TppProductDto tppProductDto;

    public TppProductDto setProduct(TppProductRequest tppProductRequest, Long productCodeId) {
        tppProductDto = new TppProductDto();
        tppProductDto.setClientId(Long.valueOf(1));
        tppProductDto.setProductCodeId(productCodeId);
        tppProductDto.setClientId(Long.valueOf(tppProductRequest.getMdmCode()));
        tppProductDto.setNso(ProductType.valueOf(tppProductRequest.getProductType()));
        tppProductDto.setInterestRateType(String.valueOf(RateType.valueOf(tppProductRequest.getRateType())));
        tppProductDto.setNumber(tppProductRequest.getContractNumber());
        tppProductDto.setState(State.Открыт.getCode());
        tppProductDto.setPriority(Long.valueOf(tppProductRequest.getPriority()));
        tppProductDto.setThresholdAmount(tppProductRequest.getThresholdAmount());
        tppProductDto.setType(tppProductRequest.getProductType());
        tppProductDto.setTaxRate(tppProductRequest.getTaxPercentageRate());
        return tppProductDto;
    }

    enum RateType {
        дифференцированная("0"), прогрессивная("1");
        private String code;

        RateType(String code) {
            this.code = code;

        }

        public String getCode() {
            return code;
        }
    }

    enum State {
        Закрыт("0"), Открыт("1"), Зарезервирован("2"), Удалён("3");
        private String code;
        State(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }
}


