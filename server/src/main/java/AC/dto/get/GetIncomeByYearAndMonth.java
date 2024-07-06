package AC.dto.get;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetIncomeByYearAndMonth {

    private Long userId;

    private String year;

    private String month;

}
