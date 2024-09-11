package cl.smartjob.msuser.app.application.ports.output;

import cl.smartjob.msuser.app.domain.model.RegularExpression;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RegularExpressionPersistencePort {
    List<RegularExpression> findAll();
    Optional<RegularExpression> findById(UUID id);
    RegularExpression save(RegularExpression expression);
    void deleteById(UUID id);
    Optional<RegularExpression> findOneByCode(String code);
}
