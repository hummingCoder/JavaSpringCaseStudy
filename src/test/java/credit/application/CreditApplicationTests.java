package credit.application;

import credit.application.service.CreditApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class CreditApplicationTests {

    @Autowired
    private CreditApplicationService creditApplicationService;

    @Autowired
    private ApplicationConfiguration applicationConfiguration;

    @Test
    void creditCalculator() {
        double creditAmount1 = creditApplicationService.calculateCreditAmount(400,10000);
        assert creditAmount1 ==0:"Credit amount must return 0";


        double creditAmount2 = creditApplicationService.calculateCreditAmount(500,10000);
        assert creditAmount2 ==5000:"Credit amount must be 5000";


        double creditAmount3 = creditApplicationService.calculateCreditAmount(600,10000);
        assert creditAmount3 ==5000:"Credit amount must be 5000";


        double creditAmount4 = creditApplicationService.calculateCreditAmount(1000,10000);
        assert creditAmount4 == BigDecimal.valueOf(10000).multiply(BigDecimal.valueOf(applicationConfiguration.getFactor())).doubleValue() : "Credit amount is not correct";

        double creditAmount5 = creditApplicationService.calculateCreditAmount(1200,10000);
        assert creditAmount5 == BigDecimal.valueOf(10000).multiply(BigDecimal.valueOf(applicationConfiguration.getFactor())).doubleValue() : "Credit amount is not correct";

        double creditAmount6 = creditApplicationService.calculateCreditAmount(1200,1000);
        assert creditAmount6 >=5000:"Credit amount cannot be less than 5000 due to lower-credit-scored users should not get more credit ";
    }

}
