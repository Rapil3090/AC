package AC.dto.delete;

import lombok.*;


public class DeleteDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    @Builder
    public static class Request {

        @NonNull
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
