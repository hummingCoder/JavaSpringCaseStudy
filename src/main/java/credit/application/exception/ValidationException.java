package credit.application.exception;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException {
    private Errors errors;
    public ValidationException(Errors errors){
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
    public List<String> getErrorsAsStringList(){

        List<String> errs = new ArrayList();

        for(FieldError error:errors.getFieldErrors())
        {
            errs.add(error.getField());
        }

        return errs;
    }
}
