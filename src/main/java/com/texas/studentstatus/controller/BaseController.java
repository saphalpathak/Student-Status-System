package com.texas.studentstatus.controller;

import com.texas.studentstatus.dto.response.ResponseDto;

public class BaseController {

    public ResponseDto successResponse(String message, Object data){
        return new ResponseDto(1,message,data);
    }

    public ResponseDto errorResponse(String message){
        return new ResponseDto(0,message,null);
    }

}
