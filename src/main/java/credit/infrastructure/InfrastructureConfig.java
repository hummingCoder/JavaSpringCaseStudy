package credit.infrastructure;

import credit.domain.model.CreditApplication;
import credit.domain.spi.CreditApplicationPersistencePort;
import credit.infrastructure.adapter.CreditApplicationPersistenceAdapter;
import credit.infrastructure.repository.CreditApplicationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureConfig {
    @Bean
    public CreditApplicationPersistencePort getCreditApplicationPersistencePort(CreditApplicationRepository creditApplicationRepository){
        return new CreditApplicationPersistenceAdapter(creditApplicationRepository);
    }
}
