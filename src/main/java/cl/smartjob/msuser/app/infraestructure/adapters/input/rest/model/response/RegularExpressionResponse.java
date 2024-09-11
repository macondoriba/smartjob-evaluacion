package cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegularExpressionResponse {
    private UUID id;
    private String code;
    private String expression;
    private LocalDateTime created;
    private LocalDateTime modified;
}
