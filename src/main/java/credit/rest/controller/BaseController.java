package credit.rest.controller;

import credit.application.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity validationException(HttpServletRequest req, ValidationException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrorsAsStringList());
//        return ex.getErrors().toString();
    }
}
