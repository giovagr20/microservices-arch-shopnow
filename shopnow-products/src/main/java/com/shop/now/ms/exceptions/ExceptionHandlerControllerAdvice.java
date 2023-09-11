package com.shop.now.ms.exceptions;

import com.shop.now.ms.models.exception.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse handleResourceNotFound(final NotFoundException exception,
                                                                  final HttpServletRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(exception.getMessage());
        exceptionResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        exceptionResponse.setTimestamp(LocalDateTime.now().toString());
        exceptionResponse.setUri(request.getRequestURI());

        return exceptionResponse;
    }
}
