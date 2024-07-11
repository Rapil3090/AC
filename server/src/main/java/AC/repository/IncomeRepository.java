package AC.repository;

import AC.domain.Income;
import AC.domain.User;
import AC.type.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query("SELECT i FROM Income i WHERE i.user.id = :userId AND i.year = :year AND i.month = :month")
    List<Income> findByUserIdAndYearAndMonth(
            @Param("userId") Long userId,
            @Param("year") String year,
            @Param("month") String month);

    @Query("SELECT i FROM Income i WHERE i.user.id = :userId AND i.category = :category")
    List<Income> findByUserIdAndCategory(@Param("userId") Long userId, @Param("category") Category category);

}
