package AC.dto.update;

import AC.domain.Income;
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

        private String ok;

        public static Response from(Income income) {

            return Response.builder()
                    .id(income.getId())
                    .ok("수정 완료")
                    .build();
        }
    }
}
