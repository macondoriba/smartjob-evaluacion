package cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegularExpressionCreateRequest {
    @NotBlank(message = "Field code cannot be empty or null")
    private String code;
    @NotBlank(message = "Field regular expression cannot be empty or null")
    private String expression;
}
