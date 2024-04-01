package ru.mvc.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mvc.exceptions.ErrorMessage;
import ru.mvc.handlers.RegisterHandler;
import ru.mvc.requests.TppProductRegisterRequest;
import ru.mvc.repositories.*;
import ru.mvc.dto.TppProductRegisterDto;
import ru.mvc.responses.*;

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
    public static TppProductRegisterResponse getTppProductRegisterResponse(Long accountId){
        TppProductRegisterResponse tppProductRegisterResponse = new TppProductRegisterResponse();
        tppProductRegisterResponse.setAccountId(String.valueOf(accountId));
        return tppProductRegisterResponse;
    }
    public TppProductRegisterResponse process(TppProductRegisterRequest tppProductRegisterRequest) throws ErrorMessage {
        var product = productRepo.findById(tppProductRegisterRequest.getInstanceId());
        if (product.isPresent()){
            throw new ErrorMessage("oooooooooooooooooooooooo");
        }
        var registerTypeCode = tppProductRegisterRequest.getRegistryTypeCode();
        if(registerRepo.findByProductIdAndType(tppProductRegisterRequest.getInstanceId(),registerTypeCode)!= null) throw new ErrorMessage();
        //if(registerRepo.findById(tppProductRegisterRequest.getInstanceId())!= null) throw new ErrorMessage("rrrrrrrrr");
        if (registerTypeRepo.findByValue(registerTypeCode) == null) throw new ErrorMessage();
        var register = registerHandler.setRegister(tppProductRegisterRequest);
        registerRepo.save(register);
        return getTppProductRegisterResponse(Long.valueOf(register.getAccount()));
    }
}
