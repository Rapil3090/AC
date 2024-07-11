package AC.service;

import AC.domain.Income;
import AC.dto.AssetDTO;

import java.util.List;

public interface AssetService {

    AssetDTO getAsset(Long userId, String year, String month);

}
