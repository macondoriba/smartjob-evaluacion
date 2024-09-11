package cl.smartjob.msuser.app.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegularExpressionException extends  RuntimeException{
    private String message;
}

