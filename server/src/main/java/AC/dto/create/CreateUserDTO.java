package AC.dto.create;

import AC.domain.User;
import lombok.*;
import org.springframework.data.repository.query.Param;

public class CreateUserDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Request {

        private String name;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long id;

        private String ok;

        public static CreateUserDTO.Response from(User user) {
            return Response.builder()
                    .id(user.getId())
                    .ok("생성 완료")
                    .build();
        }
    }
}
