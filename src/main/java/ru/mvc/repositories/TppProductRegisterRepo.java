package ru.mvc.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.mvc.dto.TppProductRegisterDto;
public interface TppProductRegisterRepo extends CrudRepository<TppProductRegisterDto,Long> {
    TppProductRegisterDto findByProductIdAndType(Long productId, String type);

}
