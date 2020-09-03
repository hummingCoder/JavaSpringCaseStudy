package credit.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Builder
@Data
@AllArgsConstructor
public class CreditApplication {

    protected CreditApplication() {}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long applicationId;
    private String identificationNumber;
    private String firstName;
    private String lastName;
    private double monthlyIncome;
    private String phoneNumber;
    private Boolean success;
    private double creditAmount;



}
