package credit.application.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateApplicationRequest {
    private String identificationNumber;
    private String firstName;
    private String lastName;
    private double monthlyIncome;
    private String phoneNumber;


}
