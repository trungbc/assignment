package com.assignment.exception.handler;

import com.assignment.dto.ErrorResponse;
import javax.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ServiceExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ErrorResponse onConstraintValidationException(EntityNotFoundException e) {
    log.error("Exception", e);
    return ErrorResponse.builder().code(HttpStatus.NOT_FOUND.value()).error(e.getMessage()).build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ErrorResponse exception(Exception e) {
    log.error("Exception", e);
    return ErrorResponse.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .error(e.getMessage()).build();
  }
}
