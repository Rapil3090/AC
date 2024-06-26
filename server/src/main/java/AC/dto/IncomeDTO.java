package AC.dto;

import AC.domain.Income;
import AC.type.Category;
import AC.type.Type;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDTO {

    private Long id;

    private String year;

    private String month;

    private String day;

    private Long amount;

    private Type type;

    private Category category;

    private String memo;


    public IncomeDTO(Income income) {
        this.id = income.getId();
        this.year = income.getYear();
        this.month = income.getMonth();
        this.day = income.getDay();
        this.amount = income.getAmount();
        this.type = income.getType();
        this.category = income.getCategory();
        this.memo = income.getMemo();
    }
}
