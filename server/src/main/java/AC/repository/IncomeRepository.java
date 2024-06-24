package AC.repository;

import AC.domain.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query("SELECT i FROM Income i WHERE i.incomId = :incomeId AND i.year = :year AND i.month = :month")
    List<Income> findByIncomeIdAndYearAndMonth(
            @Param("incomeId") Long incomeId,
            @Param("year") String year,
            @Param("month") String month);


}
