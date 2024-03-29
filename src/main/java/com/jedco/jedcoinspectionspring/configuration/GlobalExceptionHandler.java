package com.jedco.jedcoinspectionspring.configuration;


import com.jedco.jedcoinspectionspring.exceptions.AuthenticationException;
import com.jedco.jedcoinspectionspring.exceptions.ResponseException;
import com.jedco.jedcoinspectionspring.rest.responses.JwtAuthenticationResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<JwtAuthenticationResponse> handleAuthenticationFailureException(AuthenticationException ex) {
        JwtAuthenticationResponse response = new JwtAuthenticationResponse("","", new HashSet<>(), false, ex.getMessage());
        return ResponseEntity.ok(response);
    }
    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<ResponseDTO> handleResponseException(ResponseException ex){
        ResponseDTO responseDTO= new ResponseDTO(false, ex.getMessage());
        return ResponseEntity.ok(responseDTO);
    }
}
