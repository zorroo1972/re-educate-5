package ru.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.mvc.dto.TppProductRegisterDto;

@Component
public interface TppProductRepo extends CrudRepository<TppProductRegisterDto,Long> {

}
