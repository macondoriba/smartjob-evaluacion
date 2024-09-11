package cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneRequest {
    @NotBlank(message = "Field number cannot be empty or null")
    private String number;
    @NotBlank(message = "Field cityCode cannot be empty or null")
    @JsonProperty("citycode")
    private String cityCode;
    @NotBlank(message = "Field countryCode cannot be empty or null")
    @JsonProperty("countrycode")
    private String countryCode;
}