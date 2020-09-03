package credit.application.dto.response;

import credit.domain.model.CreditApplication;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class CreateApplicationResponse {
    private Boolean success;
    private double creditAmount;

    public CreateApplicationResponse(CreditApplication creditApplication) {
        this.success = creditApplication.getSuccess();
        this.creditAmount = creditApplication.getCreditAmount();
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }
}
