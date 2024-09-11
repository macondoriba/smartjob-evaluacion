package cl.smartjob.msuser.app.infraestructure.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    RESOURCE_NOT_FOUND("ERR_RESOURCE_001", "Resource not found."),
    INVALID_USER("ERR_USER_002", "Invalid user parameters."),
    GENERIC_ERROR("ERR_GEN_001", "An unexpected error ocurred."),
    REGULAR_EXPRESSION("ERR_USER_002", "Invalid regular expression parameters.");

    private final String code;
    private final String message;;
    ErrorCatalog(String code, String message){
        this.code = code;
        this.message = message;
    }

}
