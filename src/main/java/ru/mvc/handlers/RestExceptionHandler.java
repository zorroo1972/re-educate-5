package ru.mvc.handlers;

import jakarta.persistence.*;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.mvc.exceptions.*;
import java.util.StringJoiner;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        var fields = new StringJoiner(",","[","]");
        JSONObject jResponse = new JSONObject();
        ex.getBindingResult().getFieldErrors().forEach((error) ->{
            String field = ((FieldError) error).getField();
            fields.add(field);
        });
        jResponse.put("Ошибка", "Имя обязательного параметра "+fields+ " не заполнено ");
        return new ResponseEntity<>(jResponse.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CheckRegisterException.class)
    public ResponseEntity<?> handle(CheckRegisterException ex) {
        JSONObject jResponse = new JSONObject();
        jResponse.put("Ошибка", "Параметр registryTypeCode тип регистра "
                + ex.getTppProductRegisterRequest().getRegistryTypeCode() + " уже существует для ЭП с ИД "
                + ex.getTppProductRegisterRequest().getInstanceId() + ".   ");
        return new ResponseEntity<String>(jResponse.toString(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CheckRegisterTypeException.class)
    public ResponseEntity<?> handle(CheckRegisterTypeException ex) {
        var schema = ex.getTppRefProductRegisterTypeDto().getClass().getAnnotation(Table.class).schema();
        var table = ex.getTppRefProductRegisterTypeDto().getClass().getAnnotation(Table.class).name();
        JSONObject jResponse = new JSONObject();
        jResponse.put("Ошибка", ": Код Продукта "+ex.getTppProductRegisterRequest().getRegistryTypeCode()+" не найдено в Каталоге продуктов "
                +schema+"."+table+" для данного типа Регистра "
                + ex.getTppProductRegisterRequest().getRegistryTypeCode() + ".   ");
        return new ResponseEntity<String>(jResponse.toString(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CheckAccountException.class)
    public ResponseEntity<?> handle(CheckAccountException ex) {
        JSONObject jResponse = new JSONObject();
        jResponse.put("Ошибка", ": Счет не найден ");
        return new ResponseEntity<String>(jResponse.toString(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CheckProductException.class)
    public ResponseEntity<?> handle(CheckProductException ex) {
        JSONObject jResponse = new JSONObject();
        jResponse.put("Ошибка", "Параметр ContractNumber № договора  "
                + ex.getTppProductRequest().getContractNumber() + " уже существует для ЭП с ИД "
                + ex.idProduct+ ".   ");
        return new ResponseEntity<String>(jResponse.toString(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CheckAgreementException.class)
    public ResponseEntity<?> handle(CheckAgreementException ex) {
        JSONObject jResponse = new JSONObject();
        jResponse.put("Ошибка", "Параметр № Дополнительного соглашения (сделки) Number "
                + ex.getTppProductRequest().instanceArrangement.get(0).getNumber() + " уже существует для ЭП с ИД "
                + ex.getTppProductRequest().getInstanceId() + ".   ");
        return new ResponseEntity<String>(jResponse.toString(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CheckProductClassException.class)
    public ResponseEntity<?> handle(CheckProductClassException ex) {
        JSONObject jResponse = new JSONObject();
        jResponse.put("Ошибка", "Текст: КодПродукта "
                + ex.getTppProductRequest().getProductCode() + " не найдено в Каталоге продуктов tpp_ref_product_class");
        return new ResponseEntity<String>(jResponse.toString(), HttpStatus.NOT_FOUND);
    }
}


