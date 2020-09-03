package credit.application.dto.response;
import credit.domain.model.CreditApplication;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public class GetApplicationsResponse {

    private List<CreditApplication> applicationList;

    public GetApplicationsResponse(List<CreditApplication> applicationList) {
        this.applicationList = applicationList;
    }

    public List<CreditApplication> getCreditApplicationList() {
        return applicationList;
    }

    public void setCreditApplicationList(List<CreditApplication> applicationList) {
        this.applicationList = applicationList;
    }
}
