package ru.mvc.handlers;

import org.springframework.stereotype.Component;
import ru.mvc.dto.AgreementDto;
import ru.mvc.dto.AgreementList;


@Component
public class AgreementHandler {

    public AgreementDto setAgreement(AgreementList agr, String clientId) {
        AgreementDto agreementDto = new AgreementDto();
        agreementDto.setGeneralAgreementId(agr.getGeneralAgreementId());
        agreementDto.setCoefficient(agr.getCoefficient());
        agreementDto.setAgreementType(agr.getAgreementType());
        agreementDto.setInterestRate(agr.getInterestRate());
        agreementDto.setNumber(agr.getNumber());
        agreementDto.setStatus(State.Открыт.getCode());
        agreementDto.setOpeningDate(agr.getOpeningDate());
        agreementDto.setInterestCalculationDate(agr.getInterestCalculationDate());
        agreementDto.setMaximalInterestRate(agr.getMaximalInterestRate());
        agreementDto.setMinimumInterestRate(agr.getMinimumInterestRate());
        agreementDto.setCoefficientAction(Action.повышающий.getCode());
        agreementDto.setMaximalInterestRateCoefficientAction(Action.повышающий.getCode());
        return agreementDto;
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
    enum Action {
        повышающий("+"), понижающий("-");
        private String code;
        Action(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }

}


