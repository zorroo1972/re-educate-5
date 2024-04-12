package ru.mvc.services;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mvc.handlers.RegisterHandlerExt;
import ru.mvc.requests.TppProductRegisterRequest;
import ru.mvc.repositories.*;
import ru.mvc.exceptions.*;

@Service
@Component
@Transactional
public class TppProductRegisterService {
    @Autowired TppProductRegisterRepo registerRepo;
    @Autowired
    RegisterHandlerExt registerHandlerExt;

    public TppProductRegisterService() {
    }
    public static ResponseEntity<?>  getTppProductRegisterResponse(Long registerId) {
        /*
        TppProductRegisterResponse tppProductRegisterResponse = new TppProductRegisterResponse();
        tppProductRegisterResponse.setAccountId(String.valueOf(registerId));
        tppProductRegisterResponse.setDateResponse();

         */
        JSONObject jResponse = new JSONObject();
        JSONObject jSub = new JSONObject();
        jSub.put("accountId",registerId);
        jResponse.put("data",jSub);
        return new ResponseEntity<String>(jResponse.toString(), HttpStatus.CREATED);
    }
    public ResponseEntity<?>  process(TppProductRegisterRequest tppProductRegisterRequest) throws CheckRegisterException, CheckRegisterTypeException {
        var registerTypeCode = tppProductRegisterRequest.getRegistryTypeCode();
        if(registerRepo.findByProductIdAndType(tppProductRegisterRequest.getInstanceId(),registerTypeCode)!= null)
            throw new CheckRegisterException(tppProductRegisterRequest);
        var register = registerHandlerExt.setRegister(tppProductRegisterRequest);
        registerRepo.save(register);
        return getTppProductRegisterResponse(Long.valueOf(register.getId()));
    }
}
