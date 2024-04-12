package ru.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.mvc.dto.TppProductDto;

import java.util.Optional;

@Component
public interface TppProductRepo extends CrudRepository<TppProductDto,Long> {
    TppProductDto findByNumber(String number);
    Optional<TppProductDto> findById(Long id);
}
