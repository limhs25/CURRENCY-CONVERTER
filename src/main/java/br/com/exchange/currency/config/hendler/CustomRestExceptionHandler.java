package br.com.exchange.currency.config.hendler;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomRestExceptionHandler {
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage resourceHttpMessageNotReadableException(HttpMessageNotReadableException  ex, WebRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        JsonMappingException jme = (JsonMappingException) ex.getCause();
        String FieldName = jme.getPath().stream().map(e -> e.getFieldName() + ".").collect(Collectors.joining());
        return ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value()).message("An invalid argument on "+FieldName).build();
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage resourceMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        return ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value()).message(ex.getMessage()).build();
    }
    @ExceptionHandler({HttpServerErrorException.class })
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage interceptorHttpServerErrorException(HttpClientErrorException ex) {
        return ErrorMessage.builder().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("Internal Server Error").build();
    }
}

