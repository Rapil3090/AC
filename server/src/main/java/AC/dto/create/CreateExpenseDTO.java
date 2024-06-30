package AC.dto.create;

import AC.domain.Expense;
import AC.domain.Income;
import AC.type.Category;
import AC.type.Type;
import lombok.*;

public class CreateExpenseDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private Long userId;

        private String year;

        private String month;

        private String day;

        private Long amount;

        private String memo;

        private Type type;

        private Category category;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long id;

        private String ok;

        public static CreateExpenseDTO.Response from(Expense expense) {
            return CreateExpenseDTO.Response.builder()
                    .id(expense.getId())
                    .ok("생성 완료")
                    .build();
        }

    }

}
