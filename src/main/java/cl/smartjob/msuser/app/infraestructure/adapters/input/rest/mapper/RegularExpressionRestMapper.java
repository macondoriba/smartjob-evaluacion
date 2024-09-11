package cl.smartjob.msuser.app.infraestructure.adapters.input.rest.mapper;

import cl.smartjob.msuser.app.domain.model.RegularExpression;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request.RegularExpressionCreateRequest;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request.RegularExpressionUpdateRequest;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.response.RegularExpressionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy =  ReportingPolicy.IGNORE)
public interface RegularExpressionRestMapper {
    RegularExpression toDomain(RegularExpressionUpdateRequest request);
    RegularExpression toDomain(RegularExpressionCreateRequest request);
    RegularExpressionResponse toResponse(RegularExpression domain);
}