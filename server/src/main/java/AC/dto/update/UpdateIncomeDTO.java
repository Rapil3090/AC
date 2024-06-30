package AC.dto.update;

import AC.domain.Income;
import AC.type.Category;
import AC.type.Type;
import lombok.*;

public class UpdateIncomeDTO {


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

        private Type type;

        private Category category;

        private String memo;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {

        private Long id;

        private String ok;

        public static Response from(Income income) {

            return Response.builder()
                    .id(income.getId())
                    .ok("수정 완료")
                    .build();
        }
    }
}
