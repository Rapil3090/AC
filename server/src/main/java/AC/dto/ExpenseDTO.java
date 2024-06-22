package AC.dto;

import AC.domain.Expense;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

    private Long id;

    private String year;

    private String month;

    private String day;

    private Long amount;

    private String memo;

    private String type;

    private String category;

    public ExpenseDTO(Expense expense) {
        this.id = expense.getId();
        this.year = expense.getYear();
        this.month = expense.getMonth();
        this.day = expense.getDay();
        this.amount  =expense.getAmount();
        this.memo = expense.getMemo();
        this.type = expense.getType();
        this.category = expense.getCategory();
    }
}
