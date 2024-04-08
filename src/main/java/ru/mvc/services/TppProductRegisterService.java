package ru.mvc.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mvc.exceptions.ErrorMessage;
import ru.mvc.handlers.RegisterHandler;
import ru.mvc.requests.TppProductRegisterRequest;
import ru.mvc.repositories.*;
import ru.mvc.responses.*;
import ru.mvc.exceptions.*;

@Service
@Component
@Transactional
public class TppProductRegisterService {
    @Autowired TppProductRegisterRepo registerRepo;
    @Autowired TppProductRepo productRepo;
    @Autowired TppRefProductRegisterTypeRepo registerTypeRepo;
    @Autowired RegisterHandler registerHandler;

    public TppProductRegisterService() {
    }
    public static TppProductRegisterResponse getTppProductRegisterResponse(Long registerId){
        TppProductRegisterResponse tppProductRegisterResponse = new TppProductRegisterResponse();
        tppProductRegisterResponse.setAccountId(String.valueOf(registerId));
        tppProductRegisterResponse.setDateResponse();
        return new ResponseEntity<>(tppProductRegisterResponse,HttpStatus.CREATED)
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Accept",MediaType.APPLICATION_JSON_VALUE)
                .body(tppProductRegisterResponse).getBody();
    }
    public TppProductRegisterResponse process(TppProductRegisterRequest tppProductRegisterRequest) throws ErrorMessage {

        var registerTypeCode = tppProductRegisterRequest.getRegistryTypeCode();
        if(registerRepo.findByProductIdAndType(tppProductRegisterRequest.getInstanceId(),registerTypeCode)!= null) throw new ResourceNotFoundException("jkk");
        var register = registerHandler.setRegister(tppProductRegisterRequest);
        registerRepo.save(register);
        return getTppProductRegisterResponse(Long.valueOf(register.getId()));
    }
}
