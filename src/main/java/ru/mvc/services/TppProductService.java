package ru.mvc.services;

import com.fasterxml.jackson.annotation.JsonRootName;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.writer.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mvc.dto.AgreementList;
import ru.mvc.dto.TppRefProductClassDto;
import ru.mvc.dto.TppRefProductRegisterTypeDto;
import ru.mvc.exceptions.*;
import ru.mvc.handlers.ProductHandler;
import ru.mvc.handlers.RegisterHandler;
import ru.mvc.handlers.RegisterHandlerExt;
import ru.mvc.repositories.*;
import ru.mvc.requests.TppProductRequest;

import java.lang.reflect.Array;
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
    @Autowired RegisterHandlerExt registerHandlerExt;
    @Autowired TppProductRegisterRepo registerRepo;
    public TppProductService() {
    }
    public static ResponseEntity<?> getTppProductResponse(Long productId, TppRefProductRegisterTypeDto[] listReestr) {
        JSONObject jResponse = new JSONObject();
        JSONObject jSub = new JSONObject();
        JSONArray jSubRegs = new JSONArray();
        for(int i = 0; i < listReestr.length; i++){
            jSubRegs.add(listReestr); // TODO еще один массив для созданных реестров ID
        }
        jSub.put("instanceId", productId);
        jSub.put("registerId", jSubRegs);
        jResponse.put("data", jSub);
        return new ResponseEntity<String>(jResponse.toString(), HttpStatus.CREATED);
    }
    public ResponseEntity<?> process(TppProductRequest tppProductRequest) throws CheckProductException, CheckAgreementException, CheckProductClassException, CheckRegisterTypeException, CheckRegisterException {
        ResponseEntity<?> responseEntity = null;
        if (tppProductRequest.getInstanceId() == null || tppProductRequest.getInstanceId().toString().isBlank()) {
            var contractNumber = tppProductRequest.getContractNumber();
            var idProduct = productRepo.findByNumber(contractNumber);
            if (productRepo.findByNumber(contractNumber) != null) throw new CheckProductException(tppProductRequest,idProduct.getId());
            var numberAgr = tppProductRequest.getInstanceArrangement().get(0).getNumber();

            if (agreementRepo.findByNumber(numberAgr) != null) throw new CheckAgreementException(tppProductRequest);
            var listClass = productClassRepo.findByValue(tppProductRequest.getProductCode());
            TppRefProductRegisterTypeDto[] tppRefProductRegisterTypeDtoList = new TppRefProductRegisterTypeDto[100];
            for (int i = 0; i < listClass.size(); i++) {
                var tppRefProductRegisterTypeDto = registerTypeRepo.findByProductClassCode(listClass.get(i).getValue());
                var accountType = tppRefProductRegisterTypeDto.getAccountType();
                if (accountType.equals("Клиентский")) {
                    tppRefProductRegisterTypeDtoList[i] = tppRefProductRegisterTypeDto;
                }
                if (tppRefProductRegisterTypeDtoList.length == 0)
                    throw new CheckProductClassException(tppProductRequest);
                var product = productHandler.setProduct(tppProductRequest, tppRefProductRegisterTypeDto.getInternalId());
                productRepo.save(product);
                for (int y = 0; y < tppRefProductRegisterTypeDtoList.length; y++) {
                var register = registerHandlerExt.setRegister(tppProductRequest,tppRefProductRegisterTypeDtoList[y].getValue());
                registerRepo.save(register);
                responseEntity = getTppProductResponse(Long.valueOf(product.getId()),tppRefProductRegisterTypeDtoList);

            }

        }
        return responseEntity;
    }
}
