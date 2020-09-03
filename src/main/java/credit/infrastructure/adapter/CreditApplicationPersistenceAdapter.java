package credit.infrastructure.adapter;

import credit.domain.model.CreditApplication;
import credit.domain.spi.CreditApplicationPersistencePort;
import credit.infrastructure.repository.CreditApplicationRepository;

import java.util.List;

public class CreditApplicationPersistenceAdapter implements CreditApplicationPersistencePort {

    private CreditApplicationRepository creditApplicationRepository;

    public CreditApplicationPersistenceAdapter(CreditApplicationRepository creditApplicationRepository) {
        this.creditApplicationRepository = creditApplicationRepository;
    }

    @Override
    public CreditApplication create(CreditApplication application) {
        return creditApplicationRepository.save(application);
    }

    @Override
    public List<CreditApplication> findAll() {
        return creditApplicationRepository.findAll();
    }
}
