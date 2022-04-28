package com.texas.studentstatus.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceName, String fieldName, Integer id){
        super(String.format("%s not found with %s: %s",resourceName,fieldName,id));
    }

}
