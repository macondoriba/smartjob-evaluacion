package cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private List<PhoneResponse> phones;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;

}
