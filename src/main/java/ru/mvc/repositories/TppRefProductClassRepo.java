package ru.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mvc.dto.TppRefProductClassDto;
import java.util.List;

public interface TppRefProductClassRepo extends JpaRepository<TppRefProductClassDto,Long> {
    TppRefProductClassDto findByValue(String value);
}
