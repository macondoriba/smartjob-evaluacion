package cl.smartjob.msuser.app.application.ports.input;

import cl.smartjob.msuser.app.domain.model.RegularExpression;

import java.util.List;
import java.util.UUID;

public interface RegularExpressionRestServicePort {
    RegularExpression save (RegularExpression request);
    List<RegularExpression> findAll();
    RegularExpression findById(UUID id);
    RegularExpression update(UUID id, RegularExpression expression);
    void deleteById(UUID id);
}
