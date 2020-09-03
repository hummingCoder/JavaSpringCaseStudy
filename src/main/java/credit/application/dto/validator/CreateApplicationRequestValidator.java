package credit.application.dto.validator;
import credit.application.dto.request.CreateApplicationRequest;
import credit.application.util.TurkishIdNumber;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class CreateApplicationRequestValidator implements Validator {

    public CreateApplicationRequestValidator(){

    }
    @Override
    public boolean supports(Class<?> aClass) {
        return CreateApplicationRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CreateApplicationRequest request = (CreateApplicationRequest)o;
        if(!TurkishIdNumber.isValid(request.getPhoneNumber())){
            errors.rejectValue("identificationNumber","not valid");
        }

    }
}
