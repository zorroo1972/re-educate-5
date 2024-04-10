package ru.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mvc.dto.AgreementDto;

public interface AgreementRepo extends JpaRepository<AgreementDto,Long> {
    AgreementDto findByNumber(String number);
}
