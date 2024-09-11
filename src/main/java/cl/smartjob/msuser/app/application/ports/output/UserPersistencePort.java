package cl.smartjob.msuser.app.application.ports.output;

import cl.smartjob.msuser.app.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserPersistencePort {
    Optional<User> findById(UUID id);
    List<User> findAll();
    User save(User user);
    void deleteById(UUID id);
    Optional<User> findOneByEmailAndIsActive(String email, Boolean active);
}
