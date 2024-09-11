package cl.smartjob.msuser.app.application.usecase;

import cl.smartjob.msuser.app.application.ports.input.RegularExpressionRestServicePort;
import cl.smartjob.msuser.app.application.ports.output.RegularExpressionPersistencePort;
import cl.smartjob.msuser.app.domain.model.RegularExpression;
import cl.smartjob.msuser.app.domain.exception.RegularExpressionException;
import cl.smartjob.msuser.app.infraestructure.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegularExpressionUseCase implements RegularExpressionRestServicePort {

    private final RegularExpressionPersistencePort port;

    @Override
    public RegularExpression save(RegularExpression expression) {
        if(port.findOneByCode(expression.getCode()).isPresent()){
            try {
                throw new Exception(String.format(Constants.REGULAR_EXPRESSION_CODE_ALREADY_EXISTS, expression.getCode()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return port.save(expression);
    }

    @Override
    public List<RegularExpression> findAll() {
        return port.findAll();
    }

    @Override
    public RegularExpression findById(UUID id) {
        return port.findById(id)
                .orElseThrow(RegularExpressionException::new);
    }

    @Override
    public RegularExpression update(UUID id, RegularExpression expression) {
        return port.findById(id).map(savedExpression -> {
            savedExpression.setId(expression.getId());
            savedExpression.setCode(expression.getCode());
            savedExpression.setExpression(expression.getExpression());
            savedExpression.setCreated(expression.getCreated());
            savedExpression.setModified(expression.getModified());
            return port.save(savedExpression);
        }).orElseThrow(RegularExpressionException::new);
    }

    @Override
    public void deleteById(UUID id) {
        if(port.findById(id).isEmpty()){
            throw new RegularExpressionException();
        }
        port.deleteById(id);
    }
}
