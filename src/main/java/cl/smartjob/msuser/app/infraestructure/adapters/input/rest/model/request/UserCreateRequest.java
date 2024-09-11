package cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request;

import cl.smartjob.msuser.app.infraestructure.utils.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateRequest {
    @NotBlank(message = "Field name cannot be empty or null")
    private String name;
    @NotBlank(message = "Field email cannot be empty or null")
    @Pattern(regexp = Constants.EMAIL_ADDRESS_REGULAR_EXPRESSION, message = "Email invalid format")
    private String email;
    @NotBlank(message = "Field password cannot be empty or null")
    private String password;
    private List<PhoneRequest> phones;
}