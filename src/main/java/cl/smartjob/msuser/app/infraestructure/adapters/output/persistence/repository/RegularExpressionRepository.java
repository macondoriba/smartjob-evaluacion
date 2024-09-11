package cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.repository;

import cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.entity.RegularExpressionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RegularExpressionRepository extends JpaRepository<RegularExpressionEntity, UUID> {
    Optional<RegularExpressionEntity> findOneByCode(String code);
}
