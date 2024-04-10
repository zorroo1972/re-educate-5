package ru.mvc.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mvc.dto.TppProductDto;
import ru.mvc.requests.TppProductRequest;

@Component
public class ProductHandler {
    @Autowired  TppProductDto tppProductDto;
    public TppProductDto setProduct(TppProductRequest tppProductRequest) {
        tppProductDto = new TppProductDto();
    return tppProductDto;
    }
    enum State {Закрыт("0"), Открыт("1"), Зарезервирован("2"), Удалён("3");

        private String code;
        State(String code){
            this.code = code;
        }
        public String getCode(){ return code;}
    }

}

