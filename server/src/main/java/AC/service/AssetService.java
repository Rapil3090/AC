package AC.service;

import AC.dto.AssetDTO;

public interface AssetService {

    public AssetDTO getAsset(Long expenseId, Long incomeId, Long assetId);
}
