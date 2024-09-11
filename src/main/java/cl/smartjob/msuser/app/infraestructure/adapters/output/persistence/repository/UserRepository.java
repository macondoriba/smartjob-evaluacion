package cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.repository;

import cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findOneByEmailAndIsActive(String email, Boolean active);
}
