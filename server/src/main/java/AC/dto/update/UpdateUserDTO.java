package AC.dto.update;

import AC.domain.User;
import lombok.*;

public class UpdateUserDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private Long id;

        private String name;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {

        private Long id;

        private String name;

        private String ok;


        public static UpdateUserDTO.Response from(User user) {

            return Response.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .ok("수정 완료")
                    .build();
        }
    }
}
