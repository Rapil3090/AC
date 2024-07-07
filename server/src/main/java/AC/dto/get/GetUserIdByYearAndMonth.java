package AC.dto.get;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetUserIdByYearAndMonth {

    private Long userId;

    private String year;

    private String month;

}
