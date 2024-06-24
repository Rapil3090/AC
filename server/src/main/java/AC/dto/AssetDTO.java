package AC.dto;

import AC.domain.Asset;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssetDTO {

    private Long id;

    private Long totalAssets;

    private String category;

    public AssetDTO(Asset asset, Long totalAssets) {
        this.id = asset.getId();
        this.totalAssets = totalAssets;
    }
}
