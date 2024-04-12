package ru.mvc.services;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mvc.dto.AgreementList;
import ru.mvc.dto.TppRefProductRegisterTypeDto;
import ru.mvc.exceptions.*;
import ru.mvc.handlers.AgreementHandler;
import ru.mvc.handlers.ProductHandler;
import ru.mvc.handlers.RegisterHandlerExt;
import ru.mvc.repositories.*;
import ru.mvc.requests.TppProductRequest;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
@Transactional
public class TppProductService {
    @Autowired TppProductRepo productRepo;
    @Autowired AgreementRepo agreementRepo;
    @Autowired TppRefProductClassRepo productClassRepo;
    @Autowired TppRefProductRegisterTypeRepo registerTypeRepo;
    @Autowired ProductHandler productHandler;
    @Autowired TppProductRegisterRepo registerRepo;
    @Autowired RegisterHandlerExt registerHandlerExt ;
    @Autowired AgreementHandler ageementHandler;
    public TppProductService() {
    }
    public static ResponseEntity<?> getTppProductResponse(Long productId, List<Long> registrIdList, Long agreementId) {
        JSONObject jResponse = new JSONObject();
        JSONObject jSub = new JSONObject();
        JSONArray jSubRegs = new JSONArray();
        JSONArray jSubAgrs = new JSONArray();
        if (registrIdList != null) {
            for (int i = 0; i < registrIdList.size(); i++) {
                jSubRegs.add(registrIdList.get(i));
            }
        }
        jSubAgrs.add(agreementId);
        jSub.put("instanceId", productId);
        jSub.put("registerId", jSubRegs);
        jSub.put("supplementaryAgreementId", jSubAgrs);
        jResponse.put("data", jSub);
        return new ResponseEntity<String>(jResponse.toString(), HttpStatus.CREATED);
    }
    public ResponseEntity<?> process(TppProductRequest tppProductRequest) throws CheckProductException, CheckAgreementException, CheckProductClassException, CheckRegisterTypeException, CheckRegisterException, CheckRegisterTypeExceptionEx, CheckProductIdException {
        ResponseEntity<?> responseEntity = null;
        if (tppProductRequest.getInstanceId() == null || tppProductRequest.getInstanceId().toString().isBlank()) {
            var contractNumber = tppProductRequest.getContractNumber();
            var idProduct = productRepo.findByNumber(contractNumber);
            if (productRepo.findByNumber(contractNumber) != null) throw new CheckProductException(tppProductRequest,idProduct.getId());
            var numberAgr = tppProductRequest.getInstanceArrangement().get(0).getNumber();
            if (agreementRepo.findByNumber(numberAgr) != null) throw new CheckAgreementException(tppProductRequest);
            var productClass = productClassRepo.findByValue(tppProductRequest.getProductCode());
            var productCodeId = productClass.getInternalId();
            List<TppRefProductRegisterTypeDto> tppRefProductRegisterTypeDtoList;
            tppRefProductRegisterTypeDtoList = registerTypeRepo.findByProductClassCodeAndAccountType(productClass.getValue(), "Клиентский");
            if (tppRefProductRegisterTypeDtoList.size() == 0)
                    throw new CheckProductClassException(tppProductRequest);
            var product = productHandler.setProduct(tppProductRequest, productCodeId);
            productRepo.save(product);
            List<Long> registrIdList = new ArrayList<Long>();
            for (int y = 0; y < tppRefProductRegisterTypeDtoList.size(); y++) {
                var register = registerHandlerExt.setRegister(tppProductRequest, productCodeId, tppRefProductRegisterTypeDtoList.get(y).getValue() );
                registerRepo.save(register);
                registrIdList.add(register.getId());
            }
            responseEntity = getTppProductResponse(Long.valueOf(product.getId()),registrIdList, null);
            }
        else {
            if (productRepo.findById(tppProductRequest.getInstanceId()) == null) throw new CheckProductIdException(tppProductRequest);
            var numberAgr = tppProductRequest.getInstanceArrangement().get(0).getNumber();
            if (agreementRepo.findByNumber(numberAgr) != null) throw new CheckAgreementException(tppProductRequest);
            var agreement = ageementHandler.setAgreement(tppProductRequest.instanceArrangement.get(0), tppProductRequest.getMdmCode());
            agreementRepo.save(agreement);
            responseEntity = getTppProductResponse(null,null, agreement.getId());

        }
        return responseEntity;
    }
}
