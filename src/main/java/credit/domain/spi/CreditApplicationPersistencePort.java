package credit.domain.spi;

import credit.domain.model.CreditApplication;

import java.util.List;

public interface CreditApplicationPersistencePort {

    CreditApplication create(CreditApplication application);

    List<CreditApplication> findAll();
}
