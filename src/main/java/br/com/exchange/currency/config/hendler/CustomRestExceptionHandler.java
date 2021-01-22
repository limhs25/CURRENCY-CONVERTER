package br.com.exchange.currency.config.hendler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestControllerAdvice
public class CustomRestExceptionHandler {
    @ExceptionHandler(value = {InvalidFormatException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage resourceNotFoundException(InvalidFormatException ex, WebRequest request) {
        StringBuilder sb = new StringBuilder();
        final StringBuilder pathReference = ex.getPathReference(sb);
        return ErrorMessage.builder().message("The value" +ex.getValue()+"is Invalid!").build();
    }
}
