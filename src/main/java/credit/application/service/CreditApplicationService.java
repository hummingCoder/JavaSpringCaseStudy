package credit.application.service;

import credit.application.ApplicationConfiguration;
import credit.application.dto.request.CreateApplicationRequest;
import credit.application.dto.request.GetApplicationsRequest;
import credit.application.dto.response.CreateApplicationResponse;
import credit.application.dto.response.GetApplicationsResponse;
import credit.application.dto.validator.CreateApplicationRequestValidator;
import credit.application.exception.ValidationException;
import credit.domain.model.CreditApplication;
import credit.domain.spi.CreditApplicationPersistencePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CreditApplicationService {
    private CreditApplicationPersistencePort creditApplicationPersistencePort;
    private ApplicationConfiguration applicationConfiguration;

    Logger logger = LoggerFactory.getLogger(CreditApplicationService.class);

    public CreditApplicationService(CreditApplicationPersistencePort creditApplicationPersistencePort, ApplicationConfiguration applicationConfiguration, CreateApplicationRequestValidator createApplicationRequestValidator){
        this.creditApplicationPersistencePort = creditApplicationPersistencePort;
        this.applicationConfiguration = applicationConfiguration;
        this.createApplicationRequestValidator = createApplicationRequestValidator;
    }

    private final CreateApplicationRequestValidator createApplicationRequestValidator;

    public CreateApplicationResponse createApplication(CreateApplicationRequest request) throws ValidationException {
        logger.info(String.format("%s %s is applied",request.getFirstName(),request.getLastName()));
        Errors errors = new BeanPropertyBindingResult(request, "CreateApplicationRequest");
        createApplicationRequestValidator.validate(request,errors);
        if(errors.hasErrors())
        {
            throw new ValidationException(errors);
        }

        CreditApplication application=new CreditApplication(0,request.getIdentificationNumber(),request.getFirstName(),request.getLastName(),request.getMonthlyIncome(),request.getPhoneNumber(),false,0);
        double creditScore = getCreditScore();
        double creditAmount = calculateCreditAmount(creditScore,request.getMonthlyIncome());

        application.setSuccess(creditAmount>0);
        application.setCreditAmount(creditAmount);


        creditApplicationPersistencePort.create(application);

        if(creditAmount>0)
        {
            logger.info(String.format("Credit application of %s %s is accepted with %s credit score. Credit amount is %s TRY",request.getFirstName(),request.getLastName(),creditScore,creditAmount));
        }
        else{
            logger.info(String.format("Credit application of%s %s is rejected due to low credit score: %s",request.getFirstName(),request.getLastName(),creditScore));
        }

        return new CreateApplicationResponse(application);
    }



    public GetApplicationsResponse getApplications(GetApplicationsRequest request)
    {
        List<CreditApplication> creditApplicationList=creditApplicationPersistencePort.findAll();

        return  new GetApplicationsResponse(creditApplicationList);
    }




    private double getCreditScore(){
        return Math.random()*2000;
    }


    public double calculateCreditAmount(double creditScore,double monthlyIncome){
        if(creditScore<500)
        {
            return 0;
        }


        if(creditScore<1000)
        {
            return 5000;
        }
        double creditAmount = BigDecimal.valueOf(applicationConfiguration.getFactor()).multiply(BigDecimal.valueOf(monthlyIncome)).doubleValue();

        //missing rule

        if(creditAmount<5000)
        {
            creditAmount = 5000;
        }
        return creditAmount;
    }


}
