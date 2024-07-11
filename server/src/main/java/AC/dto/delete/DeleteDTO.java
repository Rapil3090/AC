package AC.dto.delete;

import jakarta.validation.constraints.NotNull;
import lombok.*;


public class DeleteDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    @Builder
    public static class Request {

        @NotNull
        private Long id;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    @Builder
    public static class Response {

        private String ok;

        public static DeleteDTO.Response from() {
            return Response.builder()
                    .ok("삭제 완료")
                    .build();
        }
    }
}
