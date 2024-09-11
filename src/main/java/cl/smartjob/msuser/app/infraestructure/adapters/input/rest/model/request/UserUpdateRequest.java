package cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request;

import cl.smartjob.msuser.app.domain.model.Phone;
import cl.smartjob.msuser.app.infraestructure.utils.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserUpdateRequest {
    private UUID id;
    @NotBlank(message = "Field name cannot be empty or null")
    private String name;
    @NotBlank(message = "Field email cannot be empty or null")
    @Pattern(regexp = Constants.EMAIL_ADDRESS_REGULAR_EXPRESSION, message = "Email invalid format")
    private String email;
    @NotBlank(message = "Field password cannot be empty or null")
    private String password;
    private List<PhoneRequest> phones;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;
}

