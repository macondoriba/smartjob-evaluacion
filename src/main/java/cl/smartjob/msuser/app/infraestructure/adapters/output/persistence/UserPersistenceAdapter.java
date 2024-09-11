package cl.smartjob.msuser.app.infraestructure.adapters.output.persistence;

import cl.smartjob.msuser.app.application.ports.output.UserPersistencePort;
import cl.smartjob.msuser.app.domain.model.User;
import cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.mapper.UserPersistenceMapper;
import cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository repository;
    private final UserPersistenceMapper mapper;

    @Override
    public List<User> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public User save(User user) {
        return mapper.toDomain(
                repository.save(mapper
                        .toEntity(user)));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<User> findOneByEmailAndIsActive(String email, Boolean active) {
        return repository.findOneByEmailAndIsActive(email, active)
                .map(mapper::toDomain);
    }


}
