package ru.mvc.services;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mvc.dto.AgreementList;
import ru.mvc.exceptions.CheckAgreementException;
import ru.mvc.exceptions.CheckProductException;
import ru.mvc.handlers.ProductHandler;
import ru.mvc.repositories.*;
import ru.mvc.requests.TppProductRequest;

import java.util.Arrays;

@Service
@Component
@Transactional
public class TppProductService {
    @Autowired TppProductRepo productRepo;
    @Autowired AgreementRepo agreementRepo;
    @Autowired ProductHandler productHandler;
    public TppProductService() {
    }
    public static ResponseEntity<?>  getTppProductResponse(Long registerId) {
        JSONObject jResponse = new JSONObject();
        JSONObject jSub = new JSONObject();
        jSub.put("accountId",registerId);
        jResponse.put("data",jSub);
        return new ResponseEntity<String>(jResponse.toString(), HttpStatus.CREATED);
    }
    public ResponseEntity<?>  process(TppProductRequest tppProductRequest) throws CheckProductException, CheckAgreementException {
        if (tppProductRequest.getInstanceId() == null||tppProductRequest.getInstanceId().toString().isBlank()) {
            var contractNumber = tppProductRequest.getContractNumber();
            if (productRepo.findByNumber(contractNumber) != null)
                throw new CheckProductException(tppProductRequest);
// TODO заменить getContractNumber()

            var numberAgr = tppProductRequest.getInstanceArrangement().get(0).getNumber();
            System.out.println(numberAgr);
            if(agreementRepo.findByNumber(numberAgr)!= null) throw new CheckAgreementException(tppProductRequest);

          //  var product = productHandler.setProduct(tppProductRequest);
           // productRepo.save(product);
            //return getTppProductResponse(Long.valueOf(product.getId()));
            return null;
        }
        return null;
    }
}
