package cl.smartjob.msuser.app.infraestructure.adapters.input.rest.mapper;

import cl.smartjob.msuser.app.domain.model.User;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request.UserCreateRequest;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request.UserUpdateRequest;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy =  ReportingPolicy.IGNORE)
public interface UserRestMapper {
    User toDomain(UserCreateRequest request);
    User toDomain(UserUpdateRequest request);
    UserResponse toResponse(User domain);
}