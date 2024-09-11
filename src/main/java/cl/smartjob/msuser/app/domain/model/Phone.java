package cl.smartjob.msuser.app.domain.model;

import lombok.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Phone {
    private UUID id;
    private String number;
    private String cityCode;
    private String countryCode;
}
