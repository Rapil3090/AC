package AC.dto.update;

import AC.domain.Expense;
import AC.domain.Income;
import lombok.*;

public class UpdateExpenseDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private Long id;

        private String year;

        private String month;

        private String day;

        private Long amount;

        private String type;

        private String category;

        private String memo;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {

        private Long id;

        private String year;

        private String month;

        private String day;

        private Long amount;

        private String type;

        private String category;

        private String memo;

        private String ok;

        public static UpdateExpenseDTO.Response from(Expense expense) {

            return Response.builder()
                    .id(expense.getId())
                    .year(expense.getYear())
                    .month(expense.getMonth())
                    .day(expense.getDay())
                    .amount(expense.getAmount())
                    .type(expense.getType())
                    .category(expense.getCategory())
                    .memo(expense.getMemo())
                    .ok("수정 완료")
                    .build();
        }
    }
}
