package ru.mvc.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.mvc.dto.TppProductRegisterDto;
public interface TppProductRegisterRepo extends CrudRepository<TppProductRegisterDto,Long> {
  //  @Query("select t from tpp_product_register t where t.product_id =?1 and t.type = ?2")
    TppProductRegisterDto findByProductIdAndType(Long productId, String type);

}
