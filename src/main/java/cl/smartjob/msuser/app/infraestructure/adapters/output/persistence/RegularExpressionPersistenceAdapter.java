package cl.smartjob.msuser.app.infraestructure.adapters.output.persistence;

import cl.smartjob.msuser.app.application.ports.output.RegularExpressionPersistencePort;
import cl.smartjob.msuser.app.domain.model.RegularExpression;
import cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.mapper.RegularExpressionPersistenceMapper;
import cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.repository.RegularExpressionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RegularExpressionPersistenceAdapter implements RegularExpressionPersistencePort {

    private final RegularExpressionRepository repository;
    private final RegularExpressionPersistenceMapper mapper;

    @Override
    public List<RegularExpression> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RegularExpression> findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public RegularExpression save(RegularExpression regularExpression) {
        return mapper.toDomain(
                repository.save(mapper
                        .toEntity(regularExpression)));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<RegularExpression> findOneByCode(String code) {
        return repository.findOneByCode(code)
                .map(mapper::toDomain);
    }
}
