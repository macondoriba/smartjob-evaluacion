package cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Builder
@Getter
@Setter
public class ErrorResponse {
    private String message;
    private List<String> details;
}
