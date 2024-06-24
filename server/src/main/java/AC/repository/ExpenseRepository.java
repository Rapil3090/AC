package AC.repository;

import AC.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {


    @Query("SELECT e FROM Expense e WHERE e.expenseId = :expenseId AND e.year = :year AND e.month = :month")
    List<Expense> findByExpenseIdAndYearAndMonth(
            @Param("expenseId") Long expenseId,
            @Param("year") String year,
            @Param("month") String month);
}
