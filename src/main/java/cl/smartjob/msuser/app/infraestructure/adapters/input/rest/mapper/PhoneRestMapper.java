package cl.smartjob.msuser.app.infraestructure.adapters.input.rest.mapper;

import cl.smartjob.msuser.app.domain.model.Phone;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request.PhoneRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy =  ReportingPolicy.IGNORE)
public interface PhoneRestMapper {
    Phone toDomain(PhoneRequest request);
}