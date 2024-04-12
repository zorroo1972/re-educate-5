package ru.mvc.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.mvc.dto.TppRefProductRegisterTypeDto;

import java.util.List;

public interface TppRefProductRegisterTypeRepo extends CrudRepository<TppRefProductRegisterTypeDto,Long> {
   TppRefProductRegisterTypeDto findByValue(String value);
   List<TppRefProductRegisterTypeDto> findByProductClassCodeAndAccountType (String productClassCode, String accountType);
   List<TppRefProductRegisterTypeDto> findByProductClassCode(String productClassCode);

}
