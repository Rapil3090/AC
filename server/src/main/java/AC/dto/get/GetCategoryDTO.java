package AC.dto.get;

import AC.type.Category;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetCategoryDTO {

    private Long userId;

    private Category category;
}
