package AC.dto.create;

import AC.domain.Income;
import lombok.*;

public class CreateIncomeDTO {


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private String year;

        private String month;

        private String day;

        private Long amount;

        private String memo;

        private String type;

        private String category;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long id;

        private String ok;

        public static Response from(Income income) {
            return Response.builder()
                    .id(income.getId())
                    .ok("생성 완료")
                    .build();
        }

    }


    }