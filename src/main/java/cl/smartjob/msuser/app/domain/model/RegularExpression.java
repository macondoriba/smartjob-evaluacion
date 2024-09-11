package cl.smartjob.msuser.app.domain.model;

import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegularExpression {
    private UUID id;
    private String code;
    private String expression;
    private LocalDateTime created;
    private LocalDateTime modified;
}
