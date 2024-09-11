package cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.mapper;

import cl.smartjob.msuser.app.domain.model.User;
import cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy =  ReportingPolicy.IGNORE)
public interface UserPersistenceMapper {
    UserEntity toEntity(User domain);
    User toDomain(UserEntity entity);

}
