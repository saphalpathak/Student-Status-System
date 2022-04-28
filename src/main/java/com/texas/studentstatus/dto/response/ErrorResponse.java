package com.texas.studentstatus.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ErrorResponse {

    private HttpStatus status;
    private String message;
    private List<String> errors;


    public ErrorResponse(HttpStatus status, String message, List<String> error){
        this.errors= error;
        this.message = message;
        this.status = status;
    }

}
