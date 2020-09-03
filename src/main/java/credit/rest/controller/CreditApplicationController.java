package credit.rest.controller;

import credit.application.dto.request.GetApplicationsRequest;
import credit.application.exception.ValidationException;
import credit.application.service.CreditApplicationService;
import credit.application.dto.request.CreateApplicationRequest;
import credit.application.dto.response.CreateApplicationResponse;
import credit.application.dto.response.GetApplicationsResponse;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/creditApplication")
public class CreditApplicationController extends BaseController {

    private final CreditApplicationService applicationService;

    public CreditApplicationController(CreditApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response successfully returned"),
            @ApiResponse(code = 400, message = "Request is not valid"),
    })
    public CreateApplicationResponse createApplication(@RequestBody CreateApplicationRequest request) throws ValidationException {
        CreateApplicationResponse response =applicationService.createApplication(request);
        return response;
    }

    @GetMapping("/")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response successfully returned"),
    })
    public GetApplicationsResponse getApplications() {
        GetApplicationsResponse response = applicationService.getApplications(new GetApplicationsRequest());
        return  response;
    }
}
