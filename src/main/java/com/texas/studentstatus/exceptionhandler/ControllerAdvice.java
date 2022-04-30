//package com.texas.studentstatus.exceptionhandler;
//
//import com.texas.studentstatus.dto.response.ErrorResponse;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@RestControllerAdvice
//public class ControllerAdvice extends ResponseEntityExceptionHandler {
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status,
//                                                                  WebRequest request) {
//        List<String> errors = new ArrayList<>();
//        for (FieldError error : ex.getFieldErrors()) {
//            errors.add(error.getField() + " " +error.getDefaultMessage());
//        }
//        ErrorResponse errorResponse = new ErrorResponse(status, ex.getClass().getName().split("\\.")[4], errors);
//        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    protected ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,ex.getMessage(),
//                Collections.singletonList(ex.getClass().getName().split("\\.")[2]));
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(ArithmeticException.class)
//    protected ResponseEntity<Object> handleArithmeticException(ArithmeticException ex){
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_ACCEPTABLE,ex.getMessage(),
//                Collections.singletonList(ex.getClass().getName().split("\\.")[3]));
//        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
//    }
//
//
////    @ExceptionHandler(IOException.class)
////    protected ResponseEntity<Object> handleIOException(IOException ex){
////        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_ACCEPTABLE,ex.getMessage(),
////                Collections.singletonList(ex.getClass().getName().split("\\.")[3]));
////        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
////    }
//}
