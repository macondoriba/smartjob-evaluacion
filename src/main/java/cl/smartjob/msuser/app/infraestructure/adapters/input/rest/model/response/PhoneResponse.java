package cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.response;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneResponse {
    private UUID id;
    private String number;
    private String cityCode;
    private String countryCode;
}