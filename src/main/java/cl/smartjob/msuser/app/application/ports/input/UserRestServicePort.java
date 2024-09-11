package cl.smartjob.msuser.app.application.ports.input;

import cl.smartjob.msuser.app.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserRestServicePort {
    User save (String token, User request);
    List<User> findAll();
    User findById(UUID id);
    User update(UUID id, User user);
    void deleteById(UUID id);
}
