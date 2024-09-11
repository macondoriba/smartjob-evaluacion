package cl.smartjob.msuser.app.infraestructure.adapters.input.rest;

import cl.smartjob.msuser.app.domain.exception.RegularExpressionException;
import cl.smartjob.msuser.app.domain.exception.UserException;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.response.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

import static cl.smartjob.msuser.app.infraestructure.utils.ErrorCatalog.*;

@RestControllerAdvice
public class GlobalControlAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserException.class, RegularExpressionException.class})
    public ErrorResponse handleUserException(){
         return ErrorResponse.builder()
                 .message(RESOURCE_NOT_FOUND.getMessage())
                 .build();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        BindingResult result = exception.getBindingResult();
        return ErrorResponse.builder()
                .message(INVALID_USER.getMessage() + result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList())

                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericError(Exception exception){
        return ErrorResponse.builder()
                .message(GENERIC_ERROR.getMessage() + Collections.singletonList(exception.getMessage()))
                .build();
    }

}
