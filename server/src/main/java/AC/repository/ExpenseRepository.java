package AC.repository;

import AC.domain.Expense;
import AC.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {


    @Query("SELECT e FROM Expense e WHERE e.user.id = :userId AND e.year = :year AND e.month = :month")
    List<Expense> findByUserIdAndYearAndMonth(
            @Param("userId") Long userId,
            @Param("year") String year,
            @Param("month") String month);
}
