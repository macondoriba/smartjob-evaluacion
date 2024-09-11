package cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.mapper;

import cl.smartjob.msuser.app.domain.model.RegularExpression;
import cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.entity.RegularExpressionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy =  ReportingPolicy.IGNORE)
public interface RegularExpressionPersistenceMapper {
    RegularExpressionEntity toEntity(RegularExpression domain);
    RegularExpression toDomain(RegularExpressionEntity entity);

}
