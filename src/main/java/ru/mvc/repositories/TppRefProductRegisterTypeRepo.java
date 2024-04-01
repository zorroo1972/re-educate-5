package ru.mvc.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.mvc.dto.TppRefProductRegisterTypeDto;

public interface TppRefProductRegisterTypeRepo extends CrudRepository<TppRefProductRegisterTypeDto,Long> {
   // @Query("select u from tpp_ref_product_register_type u where u.value = ?1")
   TppRefProductRegisterTypeDto findByValue(String value);

}
