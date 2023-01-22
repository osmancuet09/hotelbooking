package com.example.hotelbooking.exceptionHandler;


import com.example.hotelbooking.Dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ErrorDto> handleNodataFoundException(
            NoDataFoundException ex) {
        ErrorDto errorDto = new ErrorDto(new String(ex.getMessage()));
        return new ResponseEntity(errorDto, ex.getHttpStatus());
    }
}
