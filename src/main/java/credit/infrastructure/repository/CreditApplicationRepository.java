package credit.infrastructure.repository;

import credit.domain.model.CreditApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long>, PagingAndSortingRepository<CreditApplication, Long> {
//    List<Application> findAll(Pageable pageable);
    List<CreditApplication> findAllByFirstName(String firstName);

}
